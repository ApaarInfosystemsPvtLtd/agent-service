package com.pmli.lifeasia.translator.service.agent;

import com.google.gson.Gson;
import com.pmli.lifeasia.translator.Exception.agent.AgentFailure;
import com.pmli.lifeasia.translator.Exception.agent.AgentSuccess;
import com.pmli.lifeasia.translator.Exception.runtime.CustomException;
import com.pmli.lifeasia.translator.connector.ConsumeLifeAsiaConnector;
import com.pmli.lifeasia.translator.model.DmsState;
import com.pmli.lifeasia.translator.model.agent.*;
import com.pmli.lifeasia.translator.repo.AgentModificationFailureRepository;
import com.pmli.lifeasia.translator.repo.AgentModificationRequestRepository;
import com.pmli.lifeasia.translator.repo.AgentModificationSuccessRepository;
import com.pmli.lifeasia.translator.repo.DmsStateRepo;
import com.pmli.lifeasia.translator.util.AgentModificationResponseParser;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class AgentModificationServiceImpl implements AgentModificationService {

    private final static Logger log = LogManager.getLogger(AgentModificationServiceImpl.class);

    @Autowired
    ConsumeLifeAsiaConnector consumeLifeAsiaConnector;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AgentModificationRequestRepository agentModificationRequestRepository;

    @Autowired
    AgentModificationSuccessRepository successRepository;

    @Autowired
    AgentModificationFailureRepository failureRepository;

    @Autowired
    AgentModificationResponseParser parser;

    @Autowired
    MongoTemplate mongoDBTemplate;

    @Autowired
    Gson gson;

    @Autowired
    DmsStateRepo dmsStateRepo;

    @Value("${leader.header.USRPRF}")
    private String usrprf;

    private String message;

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    @Override
    public void SuccessAgentRequest(AgentSuccess agentSuccess) {
        successRepository.save(agentSuccess);
    }

    @Override
    public void FailureAgentRequest(AgentFailure agentFailure) {
        failureRepository.save(agentFailure);
    }

    @Override
    public List<AgentModificationMessageBodyResponseDTO> modifyAgent(AgentModificationMessageBodyRequestDTO agentModificationMessageBodyRequestDTO, DmsState state) {
        List<AgentModificationMessageBodyResponseDTO> agentModificationMessageBodyResponseDTOS = new ArrayList<>();
        AgentModificationMessageBodyResponse agentModificationMessageBodyResponses = new AgentModificationMessageBodyResponse();
        log.info("AgentModificationServiceImpl::modifyAgent::************Inside Agent Modification Process*******::");
        LocalDateTime startDate = null;
        LocalDateTime endDate;
        try {
            agentModificationRequestRepository.save(agentModificationMessageBodyRequestDTO);
            AgentModificationMessageBodyRequest agentModificationMessageBodyRequest = mapAgentModificationMessage(agentModificationMessageBodyRequestDTO);
            log.info("AgentModificationServiceImpl::modifyAgent::agnCRTMessageBodyRequest::{}",new Gson().toJson(agentModificationMessageBodyRequest));
            setMessage(buildAgentModificationBOMessage(agentModificationMessageBodyRequest));
            log.info("AgentModificationServiceImpl::modifyAgent::Message::" + message + "::");
            startDate = LocalDateTime.now();
            ResponseEntity<String>response = consumeLifeAsiaConnector.modifyAgent(message);
            endDate = LocalDateTime.now();
            log.info("AgentModificationServiceImpl::modifyAgent::Response Entity ::"+ response.toString());
            agentModificationMessageBodyResponses = parseResponse(response.getBody());
            AgentModificationResponseParser responseParser = new AgentModificationResponseParser();
            String messageHeader = responseParser.extractAgentModificationMessageText(response.getBody(), 0 , 130);
            AgentModificationMessageHeader agentModificationMessageHeader = responseParser.buildAgentModifyMessageHeader(messageHeader);

            if ("AGNMODO   ".equalsIgnoreCase(agentModificationMessageHeader.getMSGID())) {
                updateAgentStatus("Completed");
                successfulAgent(response,state,startDate,endDate);
            }
            else if("BOVERR    ".equalsIgnoreCase(agentModificationMessageHeader.getMSGID())) {
                updateAgentStatus("Validation Error");
                validationError(response,state,startDate,endDate);
            }
            else {
                updateAgentStatus("Validation Error");
                validationError(response,state,startDate,endDate);
            }
        }
        catch (RuntimeException e) {
            updateAgentStatus("AgentModification::LifeAsia connection Error");
            unSuccessfulAgent(e,state,startDate);
            state.setStatus("FAILURE");
            state.setExitTimeStamp(LocalDateTime.now());
            dmsStateRepo.save(state);
            log.error("AgentModificationServiceImpl::modifyAgent::AgentModification::LifeAsia connection Error::{}", Arrays.asList(e.getStackTrace()));
            throw new CustomException("AgentModification::LifeAsia connection Error");
        }
        AgentModificationMessageBodyResponseDTO agentModificationMessageBodyResponseDTO = modelMapper.map(agentModificationMessageBodyResponses,AgentModificationMessageBodyResponseDTO.class);
        agentModificationMessageBodyResponseDTOS.add(agentModificationMessageBodyResponseDTO);
        return agentModificationMessageBodyResponseDTOS;
    }

    private AgentModificationMessageBodyRequest mapAgentModificationMessage(
            AgentModificationMessageBodyRequestDTO agentModificationMessageBodyRequestDTO)
    {
        AgentModificationMessageBodyRequest agentModificationMessageBodyRequest=modelMapper.map(
                agentModificationMessageBodyRequestDTO, AgentModificationMessageBodyRequest.class);
        agentModificationMessageBodyRequest.setAction("B");
        log.info("AgentModificationServiceImpl::mapAgentModificationMessage::AgentModificationMessageBodyRequest::{}",gson.toJson(agentModificationMessageBodyRequest));
        return agentModificationMessageBodyRequest;
    }

    private String buildAgentModificationBOMessage(
            AgentModificationMessageBodyRequest agentModificationMessageBodyRequest) {
        return new StringBuilder()
                .append(buildAgentModificationLeaderHeader())
                .append("SESSIONI  0001000001          210E000000")
                .append(buildAgentMessageHeader())
                .append(buildAgentModificationMessageBody(agentModificationMessageBodyRequest)).toString();

//        return "        DMSAUTO   QPADEV002GCLN2      AGN       003251YIRN0                                         SESSIONI  0001000001          210E000000AGNMODI   0015500001          K19940119    591307                Div Midname                                                 C                                                                                                                                 ";
    }

    private String buildAgentMessageHeader() {
        log.info("AgentMessageHeader::"+new AgentModificationMessageHeader().toJson());
        return new AgentModificationMessageHeader().toString();
    }

    private String buildAgentModificationMessageBody(
            AgentModificationMessageBodyRequest agentModificationMessageBodyRequest) {
        log.info("AgentModificationMessageBody::"+agentModificationMessageBodyRequest.toJson());
        return agentModificationMessageBodyRequest.toString();
    }

    private String buildAgentModificationLeaderHeader() {
        AgentModificationLeaderHeader agentModificationLeaderHeader = new AgentModificationLeaderHeader();
        agentModificationLeaderHeader.setUSRPRF(usrprf);
        log.info("AgentModificationLeaderHeader::"+gson.toJson(agentModificationLeaderHeader));
        return  agentModificationLeaderHeader.toString();
    }

    private AgentModificationMessageBodyResponse parseResponse(String response) {
        log.info("AgentModificationServiceImpl::parseResponse::response:"+response);
        AgentModificationMessageBodyResponse agentModificationMessageBodyResponseList = parser.parseResponse(response);
        log.info("AgentModificationServiceImpl::parseResponse::AgentModificationMessageBodyResponse::{}",new Gson().toJson(agentModificationMessageBodyResponseList));
        return agentModificationMessageBodyResponseList;
    }
    private void updateAgentStatus(String status) {
        Query query = new Query();
        query.addCriteria(Criteria.where("status").is("Received"));
        Update update = new Update();
        update.set("status", status);
        mongoDBTemplate.upsert(query,update, AgentModificationMessageBodyRequestDTO.class);
    }

    private void successfulAgent(ResponseEntity entity, DmsState state, LocalDateTime startDate, LocalDateTime endDate) {
        AgentSuccess agentSuccess = new AgentSuccess();
        agentSuccess.setEntryTimeStamp(startDate);
        agentSuccess.setRequest_Type("AGNMOD");
        agentSuccess.setRequest(getMessage());
        agentSuccess.setResponse(entity.getBody().toString());
        agentSuccess.setExitTimeStamp(endDate);
        SuccessAgentRequest(agentSuccess);
        state.setAgentSuccess(agentSuccess);
        log.info("AgentModificationServiceImpl::successfulAgent::Agent Success::{}",gson.toJson(agentSuccess));
    }

    private void unSuccessfulAgent(RuntimeException e, DmsState state, LocalDateTime startDate) {
        AgentFailure agentFailure = new AgentFailure();
        agentFailure.setEntryTimeStamp(startDate);
        agentFailure.setRequest_type("AGNMOD");
        agentFailure.setStatus(HttpStatus.NO_CONTENT);
        agentFailure.setRequest(getMessage());
        agentFailure.setResponseError("IBM 2033 Exception occurred");
        agentFailure.setMessage("Response is null");
        agentFailure.setPath("/pnbmetlife/v1/agent");
        agentFailure.setExitTimeStamp(LocalDateTime.now());
        FailureAgentRequest(agentFailure);
        state.setAgentFailure(agentFailure);
        log.error("AgentModificationServiceImpl::unSuccessfulAgent::Agent Failure::{}",gson.toJson(agentFailure));
    }

    private void validationError(ResponseEntity entity, DmsState state, LocalDateTime startDate, LocalDateTime endDate) {
        AgentFailure agentFailure = new AgentFailure();
        agentFailure.setEntryTimeStamp(startDate);
        agentFailure.setRequest_type("AGNMOD");
        agentFailure.setStatus(HttpStatus.BAD_REQUEST);
        agentFailure.setRequest(getMessage());
        agentFailure.setResponseError(entity.getBody().toString());
        agentFailure.setMessage("Response contains validation errors");
        agentFailure.setPath("/pnbmetlife/v1/agent");
        agentFailure.setExitTimeStamp(endDate);
        FailureAgentRequest(agentFailure);
        state.setAgentFailure(agentFailure);
        log.error("AgentModificationServiceImpl::validationError::Agent Failure::{}",gson.toJson(agentFailure));
    }
}
