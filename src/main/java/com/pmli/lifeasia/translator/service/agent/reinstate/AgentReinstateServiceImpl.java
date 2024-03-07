package com.pmli.lifeasia.translator.service.agent.reinstate;

import com.google.gson.Gson;
import com.pmli.lifeasia.translator.Exception.agent.AgentFailure;
import com.pmli.lifeasia.translator.Exception.agent.AgentSuccess;
import com.pmli.lifeasia.translator.Exception.runtime.CustomException;
import com.pmli.lifeasia.translator.connector.ConsumeLifeAsiaConnector;
import com.pmli.lifeasia.translator.model.DmsState;
import com.pmli.lifeasia.translator.model.agent.AgentModificationMessageBodyRequest;
import com.pmli.lifeasia.translator.model.agent.AgentModificationMessageBodyRequestDTO;
import com.pmli.lifeasia.translator.model.agent.AgentModificationMessageBodyResponseDTO;
import com.pmli.lifeasia.translator.model.agent.reinstate.AgentReinstateLeaderHeader;
import com.pmli.lifeasia.translator.model.agent.reinstate.AgentReinstateMessageBody;
import com.pmli.lifeasia.translator.model.agent.reinstate.AgentReinstateMessageBodyResponse;
import com.pmli.lifeasia.translator.model.agent.reinstate.AgentReinstateMessageHeader;
import com.pmli.lifeasia.translator.repo.AgentModificationFailureRepository;
import com.pmli.lifeasia.translator.repo.AgentModificationSuccessRepository;
import com.pmli.lifeasia.translator.repo.DmsStateRepo;
import com.pmli.lifeasia.translator.repo.agent.reinstate.AgentReinstateRequestRepository;
import com.pmli.lifeasia.translator.util.AgentReinstateResponseParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;


@Component
public class AgentReinstateServiceImpl implements AgentReinstateService {

    private final static Logger log = LogManager.getLogger(AgentReinstateServiceImpl.class);

    @Autowired
    ConsumeLifeAsiaConnector consumeLifeAsiaConnector;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AgentReinstateRequestRepository agentReinstateRequestRepository;

    @Autowired
    AgentModificationSuccessRepository successRepository;

    @Autowired
    AgentModificationFailureRepository failureRepository;

    @Autowired
    AgentReinstateResponseParser parser;

    @Autowired
    MongoTemplate mongoDBTemplate;

    @Autowired
    Gson gson;

    @Autowired
    DmsStateRepo dmsStateRepo;

    @Value("${leader.header.USRPRF}")
    private String usrprf;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void storeSuccessAgentRequest(AgentSuccess agentSuccess) {
        successRepository.save(agentSuccess);
    }

    @Override
    public void storeFailureAgentRequest(AgentFailure agentFailure) {
        failureRepository.save(agentFailure);
    }

    @Override
    public AgentModificationMessageBodyResponseDTO reinstateAgent(DmsState state, AgentReinstateMessageBody agentReinstateMessageBody) {

        AgentReinstateMessageBodyResponse agentReinstateMessageBodyResponse = new AgentReinstateMessageBodyResponse();
        log.info("AgentReinstateServiceImpl::reinstateAgent::************Inside Agent Reinstate Process*******::");
        LocalDateTime startDate = null;
        LocalDateTime endDate;
        try {
            agentReinstateRequestRepository.save(agentReinstateMessageBody);
            log.info("AgentReinstateServiceImpl::reinstateAgent::agnReinstateMessageBodyRequest::{}",gson.toJson(agentReinstateMessageBody));
            setMessage(buildAgentReinstateBOMessage(agentReinstateMessageBody));
            log.info("AgentReinstateServiceImpl::reinstateAgent::Message::" + message + "::");
            startDate = LocalDateTime.now();
            ResponseEntity<String> response = consumeLifeAsiaConnector.reinstateAgent(message);
            endDate = LocalDateTime.now();
            log.info("AgentReinstateServiceImpl::reinstateAgent::Response Entity ::" + response.toString());
            agentReinstateMessageBodyResponse = parseResponse(response.getBody());
            String messageHeader = parser.extractAgentReinstateMessageText(response.getBody(), 0, 130);
            AgentReinstateMessageHeader agentReinstateMessageHeader = parser.buildAgentReinstateMessageHeader(messageHeader);

            if ("AGNRTAO   ".equalsIgnoreCase(agentReinstateMessageHeader.getMSGID())) {
                updateAgentStatus("Completed");
                successfulAgent(response,state,startDate,endDate);
            } else if ("BOVERR    ".equalsIgnoreCase(agentReinstateMessageHeader.getMSGID())) {
                updateAgentStatus("Validation Error");
                validationError(response,state,startDate,endDate);
            } else {
                updateAgentStatus("Validation Error");
                validationError(response,state,startDate,endDate);
            }
        } catch (RuntimeException e) {
            updateAgentStatus("LifeAsia connection Error");
            unSuccessfulAgent(e,state,startDate);
            state.setStatus("FAILURE");
            state.setExitTimeStamp(LocalDateTime.now());
            dmsStateRepo.save(state);
            log.error("AgentReinstateServiceImpl::reinstateAgent::LifeAsia connection Error::{}", Arrays.asList(e.getStackTrace()));
            throw new CustomException("LifeAsia connection Error");
        }
        return modelMapper.map(agentReinstateMessageBodyResponse, AgentModificationMessageBodyResponseDTO.class);
    }

    private AgentModificationMessageBodyRequest mapAgentModificationMessage(
            AgentModificationMessageBodyRequestDTO agentModificationMessageBodyRequestDTO) {
        AgentModificationMessageBodyRequest agentModificationMessageBodyRequest = modelMapper.map(
                agentModificationMessageBodyRequestDTO, AgentModificationMessageBodyRequest.class);
        agentModificationMessageBodyRequest.setAction("B");
        return agentModificationMessageBodyRequest;
    }

    private String buildAgentReinstateBOMessage(
            AgentReinstateMessageBody agentReinstateMessageBody) {
        return new StringBuilder()
                .append(buildAgentReinstateLeaderHeader())
                .append("SESSIONI  0001000001          210E000000")
                .append(buildReinstateAgentMessageHeader())
                .append(buildAgentReinstateMessageBody(agentReinstateMessageBody)).toString();

    }

    private String buildReinstateAgentMessageHeader() {
        log.info("AgentReinstateServiceImpl::buildReinstateAgentMessageHeader::AgentReinstateMessageHeader::" + new AgentReinstateMessageHeader().toJson());
        return new AgentReinstateMessageHeader().toString();
    }

    private String buildAgentReinstateMessageBody(
            AgentReinstateMessageBody agentReinstateMessageBody) {
        //System.out.println(agentReinstateMessageBody);
        log.info("AgentReinstateServiceImpl::buildAgentReinstateMessageBody::agentReinstateMessageBody::" + agentReinstateMessageBody);
        return agentReinstateMessageBody.toString();
    }

    private String buildAgentReinstateLeaderHeader() {
        AgentReinstateLeaderHeader agentReinstateLeaderHeader = new AgentReinstateLeaderHeader();
        agentReinstateLeaderHeader.setUSRPRF(usrprf);
        log.info("AgentReinstateServiceImpl::reinstateAgent::AgentTerminateLeaderHeader::" + gson.toJson(agentReinstateLeaderHeader));
        return agentReinstateLeaderHeader.toString();
    }

    private AgentReinstateMessageBodyResponse parseResponse(String response) {
        log.info("AgentReinstateServiceImpl::parseResponse::response:" + response);
        AgentReinstateMessageBodyResponse agentReinstateMessageBodyResponse = parser.parseResponse(response);
        log.info("AgentReinstateServiceImpl::parseResponse::response:{}", gson.toJson(agentReinstateMessageBodyResponse));
        return agentReinstateMessageBodyResponse;
    }

    private void updateAgentStatus(String status) {
        Query query = new Query();
        query.addCriteria(Criteria.where("status").is("Received"));
        Update update = new Update();
        update.set("status", status);
        mongoDBTemplate.upsert(query, update, AgentModificationMessageBodyRequestDTO.class);
    }

    private void successfulAgent(ResponseEntity entity,DmsState state, LocalDateTime startDate, LocalDateTime endDate) {
        AgentSuccess agentSuccess = new AgentSuccess();
        agentSuccess.setEntryTimeStamp(startDate);
        agentSuccess.setRequest_Type("AGNTER");
        agentSuccess.setRequest(getMessage());
        agentSuccess.setResponse(entity.getBody().toString());
        agentSuccess.setExitTimeStamp(endDate);
        storeSuccessAgentRequest(agentSuccess);
        state.setAgentSuccess(agentSuccess);
        log.info("AgentReinstateServiceImpl::successfulAgent::Agent Success::{}",gson.toJson(agentSuccess));
    }

    private void unSuccessfulAgent(RuntimeException e,DmsState state, LocalDateTime startDate) {
        AgentFailure agentFailure = new AgentFailure();
        agentFailure.setEntryTimeStamp(startDate);
        agentFailure.setRequest_type("AGNRTA");
        agentFailure.setStatus(HttpStatus.NO_CONTENT);
        agentFailure.setRequest(getMessage());
        agentFailure.setResponseError("IBM 2033 Exception occurred");
        agentFailure.setMessage("Response is null");
        agentFailure.setPath("/pnbmetlife/v1/agent");
        agentFailure.setExitTimeStamp(LocalDateTime.now());
        storeFailureAgentRequest(agentFailure);
        state.setAgentFailure(agentFailure);
        log.error("AgentReinstateServiceImpl::unSuccessfulAgent::Agent Failure::{}",gson.toJson(agentFailure));
    }

    private void validationError(ResponseEntity entity,DmsState state, LocalDateTime startDate, LocalDateTime endDate) {
        AgentFailure agentFailure = new AgentFailure();
        agentFailure.setEntryTimeStamp(startDate);
        agentFailure.setRequest_type("AGNRTA");
        agentFailure.setStatus(HttpStatus.BAD_REQUEST);
        agentFailure.setRequest(getMessage());
        agentFailure.setResponseError(entity.getBody().toString());
        agentFailure.setMessage("Response contains validation errors");
        agentFailure.setPath("/pnbmetlife/v1/agent");
        agentFailure.setExitTimeStamp(endDate);
        storeFailureAgentRequest(agentFailure);
        state.setAgentFailure(agentFailure);
        log.error("AgentReinstateServiceImpl::unSuccessfulAgent::Agent Failure::{}",gson.toJson(agentFailure));
    }
}
