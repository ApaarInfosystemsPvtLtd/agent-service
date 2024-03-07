package com.pmli.lifeasia.translator.service.agent.terminate;

import com.google.gson.Gson;
import com.pmli.lifeasia.translator.Exception.agent.AgentFailure;
import com.pmli.lifeasia.translator.Exception.agent.AgentSuccess;
import com.pmli.lifeasia.translator.Exception.runtime.CustomException;
import com.pmli.lifeasia.translator.connector.ConsumeLifeAsiaConnector;
import com.pmli.lifeasia.translator.model.DmsState;
import com.pmli.lifeasia.translator.model.agent.*;
import com.pmli.lifeasia.translator.model.agent.terminate.AgentTerminateLeaderHeader;
import com.pmli.lifeasia.translator.model.agent.terminate.AgentTerminateMessageBody;
import com.pmli.lifeasia.translator.model.agent.terminate.AgentTerminateMessageBodyResponse;
import com.pmli.lifeasia.translator.model.agent.terminate.AgentTerminateMessageHeader;
import com.pmli.lifeasia.translator.repo.AgentModificationFailureRepository;
import com.pmli.lifeasia.translator.repo.AgentModificationSuccessRepository;
import com.pmli.lifeasia.translator.repo.DmsStateRepo;
import com.pmli.lifeasia.translator.repo.agent.terminate.AgentTerminateRequestRepository;
import com.pmli.lifeasia.translator.util.AgentTerminateResponseParser;
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
public class AgentTerminateServiceImpl implements AgentTerminateService {

    private final static Logger log = LogManager.getLogger(AgentTerminateServiceImpl.class);

    @Autowired
    ConsumeLifeAsiaConnector consumeLifeAsiaConnector;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AgentTerminateRequestRepository agentTerminateRequestRepository;

    @Autowired
    AgentModificationSuccessRepository successRepository;

    @Autowired
    AgentModificationFailureRepository failureRepository;

    @Autowired
    AgentTerminateResponseParser parser;

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
    public AgentModificationMessageBodyResponseDTO terminateAgent(DmsState state, AgentTerminateMessageBody agentTerminateMessageBody) {

        log.info("AgentTerminateServiceImpl::terminateAgent::************Inside Agent Termination Process*******::");
        AgentTerminateMessageBodyResponse agentTerminateMessageBodyResponse = new AgentTerminateMessageBodyResponse();
        LocalDateTime startDate = null;
        LocalDateTime endDate = null;
        try {
            agentTerminateRequestRepository.save(agentTerminateMessageBody);
            log.info("AgentTerminateServiceImpl::terminateAgent::agnTerminateMessageBodyRequest::{}",gson.toJson(agentTerminateMessageBody));
            setMessage(buildAgentTerminateBOMessage(agentTerminateMessageBody));
            log.info("AgentTerminateServiceImpl::terminateAgent::Message::" + message + "::");
            startDate = LocalDateTime.now();
            ResponseEntity<String> response = consumeLifeAsiaConnector.terminateAgent(message);
            endDate = LocalDateTime.now();
            System.out.println("Response Entity ::" + response.toString());
            log.info("AgentTerminateServiceImpl::terminateAgent::Response Entity ::" + response.toString());
            agentTerminateMessageBodyResponse = parseResponse(response.getBody());
            String messageHeader = parser.extractAgentTerminateMessageText(response.getBody(), 0, 130);
            AgentTerminateMessageHeader agentTerminateMessageHeader = parser.buildAgentTerminateMessageHeader(messageHeader);

            if ("AGNTERO   ".equalsIgnoreCase(agentTerminateMessageHeader.getMSGID())) {
                updateAgentStatus("Completed");
                successfulAgent(response,state,startDate,endDate);
            } else if ("BOVERR    ".equalsIgnoreCase(agentTerminateMessageHeader.getMSGID())) {
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
            log.error("AgentTerminateServiceImpl::terminateAgent::LifeAsia connection Error::{}", Arrays.asList(e.getStackTrace()));
            throw new CustomException("LifeAsia connection Error");
        }
        return modelMapper.map(agentTerminateMessageBodyResponse, AgentModificationMessageBodyResponseDTO.class);
    }

    private AgentModificationMessageBodyRequest mapAgentModificationMessage(
            AgentModificationMessageBodyRequestDTO agentModificationMessageBodyRequestDTO) {
        AgentModificationMessageBodyRequest agentModificationMessageBodyRequest = modelMapper.map(
                agentModificationMessageBodyRequestDTO, AgentModificationMessageBodyRequest.class);
        agentModificationMessageBodyRequest.setAction("B");
        return agentModificationMessageBodyRequest;
    }

    private String buildAgentTerminateBOMessage(
            AgentTerminateMessageBody agentTerminateMessageBody) {
        return new StringBuilder()
                .append(buildAgentTerminateLeaderHeader())
                .append("SESSIONI  0001000001          210E000000")
                .append(buildTerminateAgentMessageHeader())
                .append(buildAgentTerminateMessageBody(agentTerminateMessageBody)).toString();

//        return "        DMSAUTO   QPADEV002GCLN2      AGN       003251YIRN0                                         SESSIONI  0001000001          210E000000AGNMODI   0015500001          K19940119    591307                Div Midname                                                 C                                                                                                                                 ";
    }

    private String buildTerminateAgentMessageHeader() {
        log.info("AgentTerminateServiceImpl::buildTerminateAgentMessageHeader::AgentTerminateMessageHeader::" + new AgentTerminateMessageHeader().toJson());
        return new AgentTerminateMessageHeader().toString();
    }

    private String buildAgentTerminateMessageBody(
            AgentTerminateMessageBody agentTerminateMessageBody) {
        log.info("AgentTerminateServiceImpl::buildAgentTerminateMessageBody::agentTerminateMessageBody::" + agentTerminateMessageBody);
        return agentTerminateMessageBody.toString();
    }

    private String buildAgentTerminateLeaderHeader() {
        AgentTerminateLeaderHeader agentTerminateLeaderHeader = new AgentTerminateLeaderHeader();
        agentTerminateLeaderHeader.setUSRPRF(usrprf);
        log.info("AgentTerminateServiceImpl::buildAgentTerminateLeaderHeader::AgentTerminateLeaderHeader::" + gson.toJson(agentTerminateLeaderHeader));
        return agentTerminateLeaderHeader.toString();
    }

    private AgentTerminateMessageBodyResponse parseResponse(String response) {
        log.info("AgentTerminateServiceImpl::parseResponse::response:" + response);
        AgentTerminateMessageBodyResponse agentTerminateMessageBodyResponse = parser.parseResponse(response);
        log.info("AgentTerminateServiceImpl::parseResponse::AgentTerminateMessageBodyResponse:" + gson.toJson(agentTerminateMessageBodyResponse));
        return agentTerminateMessageBodyResponse;
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
        log.info("AgentTerminateServiceImpl::successfulAgent::Agent Success::{}",gson.toJson(agentSuccess));
    }

    private void unSuccessfulAgent(RuntimeException e,DmsState state, LocalDateTime startDate) {
        AgentFailure agentFailure = new AgentFailure();
        agentFailure.setEntryTimeStamp(startDate);
        agentFailure.setRequest_type("AGNTER");
        agentFailure.setStatus(HttpStatus.NO_CONTENT);
        agentFailure.setRequest(getMessage());
        agentFailure.setResponseError("IBM 2033 Exception occurred");
        agentFailure.setMessage("Response is null");
        agentFailure.setPath("/pnbmetlife/v1/agent");
        agentFailure.setExitTimeStamp(LocalDateTime.now());
        storeFailureAgentRequest(agentFailure);
        state.setAgentFailure(agentFailure);
        log.error("AgentTerminateServiceImpl::unSuccessfulAgent::Agent Failure::{}",gson.toJson(agentFailure));
    }

    private void validationError(ResponseEntity entity,DmsState state, LocalDateTime startDate, LocalDateTime endDate) {
        AgentFailure agentFailure = new AgentFailure();
        agentFailure.setEntryTimeStamp(startDate);
        agentFailure.setRequest_type("AGNTER");
        agentFailure.setStatus(HttpStatus.BAD_REQUEST);
        agentFailure.setRequest(getMessage());
        agentFailure.setResponseError(entity.getBody().toString());
        agentFailure.setMessage("Response contains validation errors");
        agentFailure.setPath("/pnbmetlife/v1/agent");
        agentFailure.setExitTimeStamp(endDate);
        storeFailureAgentRequest(agentFailure);
        state.setAgentFailure(agentFailure);
        log.error("AgentTerminateServiceImpl::unSuccessfulAgent::Agent Failure::{}",gson.toJson(agentFailure));
    }
}
