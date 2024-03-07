package com.pmli.lifeasia.translator.service.agent;

import com.google.gson.Gson;
import com.pmli.lifeasia.translator.Exception.agent.AgentFailure;
import com.pmli.lifeasia.translator.Exception.agent.AgentSuccess;
import com.pmli.lifeasia.translator.Exception.runtime.CustomException;
import com.pmli.lifeasia.translator.connector.ConsumeLifeAsiaConnector;
import com.pmli.lifeasia.translator.model.DmsState;
import com.pmli.lifeasia.translator.model.agent.*;
import com.pmli.lifeasia.translator.repo.AgentCreationFailureRepository;
import com.pmli.lifeasia.translator.repo.AgentCreationSuccessRepository;
import com.pmli.lifeasia.translator.repo.AgnCreationRequestRepository;
import com.pmli.lifeasia.translator.repo.DmsStateRepo;
import com.pmli.lifeasia.translator.util.AgentCreateResponseParser;
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
public class AgentCreateServiceImpl implements AgentCreateService {

    private final static Logger log = LogManager.getLogger(AgentCreateServiceImpl.class);

    @Autowired
    ConsumeLifeAsiaConnector consumeLifeAsiaConnector;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AgnCreationRequestRepository agnCreationRequestRepository;

    @Autowired
    AgentCreationSuccessRepository successRepository;

    @Autowired
    AgentCreationFailureRepository failureRepository;

    @Autowired
    AgentCreateResponseParser parser;

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
    public List<AgentCreateMessageBodyResponseDTO> createAgent(AgentCreateMessageBodyRequestDTO agentCreateMessageBodyRequestDTO, DmsState state)
    {
        log.info("AgentCreateRequestServiceImpl::AgentCreateResponseDTO::EntryTime::{}", LocalDateTime.now());
        List<AgentCreateMessageBodyResponseDTO> agentCreateMessageBodyResponseDTOS = new ArrayList<>();
        AgentCreateMessageBodyResponse agentCreateMessageBodyResponses = new AgentCreateMessageBodyResponse();
        log.info("AgentCreateServiceImpl::createAgent::************Inside Agent Creation Process*******::");
        LocalDateTime startDate = null;
        LocalDateTime endDate = null;
        try {
            agnCreationRequestRepository.save(agentCreateMessageBodyRequestDTO);
            AgentCreateMessageBodyRequest agentCRTMessageBodyRequest = mapAgentCRTIMessage(agentCreateMessageBodyRequestDTO);
            log.info("AgentCreateServiceImpl::createAgent::agnCRTMessageBodyRequest::"+gson.toJson(agentCRTMessageBodyRequest));
            setMessage(buildAgentCRTIBOMessage(agentCRTMessageBodyRequest));
            log.info("AgentCreateServiceImpl::createAgent::Message::" + message + "::");
            startDate = LocalDateTime.now();
            ResponseEntity<String> response = consumeLifeAsiaConnector.createAgent(message);
            endDate = LocalDateTime.now();
            log.info("AgentCreateServiceImpl::createAgent::Response Entity ::{}",response.getBody());
            agentCreateMessageBodyResponses = parseResponse(response.getBody());

            AgentCreateResponseParser responseParser = new AgentCreateResponseParser();
            String messageHeader = responseParser.extractAgentCRTMessageText(response.getBody(), 0, 130);
            AgentCreateMessageHeader agentCreateMessageHeader = responseParser.buildAgentCRTMessageHeader(messageHeader);

            if ("AGNCRTO   ".equalsIgnoreCase(agentCreateMessageHeader.getMSGID())) {
                updateAgentStatus("Completed");
                successfulAgent(response,state,startDate,endDate);
            }
            else if ("BOVERR    ".equalsIgnoreCase(agentCreateMessageHeader.getMSGID())) {
                updateAgentStatus("Validation Error");
                validationError(response,state,startDate,endDate);
            } else {
                updateAgentStatus("Validation Error");
                validationError(response,state,startDate,endDate);
            }
        }
        catch (RuntimeException e)
        {
            updateAgentStatus("AgentCreation::LifeAsia connection Error");
            unSuccessfulAgent(e,state,startDate);
            state.setStatus("FAILURE");
            state.setExitTimeStamp(LocalDateTime.now());
            dmsStateRepo.save(state);
            log.error("AgentCreateServiceImpl::AgentCreation::LifeAsia connection Error::{}", Arrays.asList(e.getStackTrace()));
            throw new CustomException("AgentCreation::LifeAsia connection Error");
        }
        AgentCreateMessageBodyResponseDTO agentCreateMessageBodyResponseDTO = modelMapper.map(agentCreateMessageBodyResponses,AgentCreateMessageBodyResponseDTO.class);
        agentCreateMessageBodyResponseDTOS.add(agentCreateMessageBodyResponseDTO);
        return agentCreateMessageBodyResponseDTOS;
    }
    private AgentCreateMessageBodyRequest mapAgentCRTIMessage(AgentCreateMessageBodyRequestDTO agentCreateMessageBodyRequestDTO) {
        AgentCreateMessageBodyRequest agentCRTMessageBodyRequest =modelMapper.map(agentCreateMessageBodyRequestDTO, AgentCreateMessageBodyRequest.class);
        agentCRTMessageBodyRequest.setAction("A");

        if(agentCRTMessageBodyRequest.getTlicexpdt().equalsIgnoreCase("        ")){
            agentCRTMessageBodyRequest.setTlicexpdt("20991231");
        }

        return agentCRTMessageBodyRequest;
    }

    private String buildAgentCRTIBOMessage(AgentCreateMessageBodyRequest agentCRTMessageBodyRequest) {
        return new StringBuilder()
                .append(buildAgentCRTLeaderHeader())
                .append("SESSIONI  0001000001          210E000000")
                .append(buildAgentMessageHeader())
                .append(buildAgentCRTIMessageBody(agentCRTMessageBodyRequest)).toString();

//        return "        DMSAUTO   QPADEV002GCLN2      AGN       003251YIRN0                                         SESSIONI  0001000001          210E000000AGNCRTI   0015500001          K19940119    591307                Div Midname                                                 C                                                                                                                                 ";
    }

    private String buildAgentMessageHeader() {
        log.info("AgentCreateServiceImpl::AgentMessageHeader::"+ new AgentCreateMessageHeader().toJson());
        return new AgentCreateMessageHeader().toString();
    }

    private String buildAgentCRTIMessageBody(AgentCreateMessageBodyRequest agentCRTMessageBodyRequest) {
        log.info("AgentCreateServiceImpl::AgentCRTIMessageBody::"+agentCRTMessageBodyRequest.toJson());
        return agentCRTMessageBodyRequest.toString();
    }

    private String buildAgentCRTLeaderHeader() {
        AgentCreateLeaderHeader agentCreateLeaderHeader = new AgentCreateLeaderHeader();
        agentCreateLeaderHeader.setUSRPRF(usrprf);
        log.info("AgentCreateServiceImpl::AgentCRTLeaderHeader::"+gson.toJson(agentCreateLeaderHeader));
        return agentCreateLeaderHeader.toString();
    }

    private AgentCreateMessageBodyResponse parseResponse(String response) {
        log.info("AgentCreateServiceImpl::Response::"+response);
        AgentCreateMessageBodyResponse agentCRTMessageBody = parser.parseResponse(response);
        return agentCRTMessageBody;
    }

    private void updateAgentStatus(String status) {
        Query query = new Query();
        query.addCriteria(Criteria.where("status").is("Received"));
        Update update = new Update();
        update.set("status", status);
        mongoDBTemplate.upsert(query,update, AgentCreateMessageBodyRequestDTO.class);
    }

    private void successfulAgent(ResponseEntity entity, DmsState state, LocalDateTime startDate, LocalDateTime endDate) {
        AgentSuccess agentSuccess = new AgentSuccess();
        agentSuccess.setEntryTimeStamp(startDate);
        agentSuccess.setRequest_Type("AGNCRT");
        agentSuccess.setRequest(getMessage());
        agentSuccess.setResponse(entity.getBody().toString());
        agentSuccess.setExitTimeStamp(endDate);
        SuccessAgentRequest(agentSuccess);
        state.setAgentSuccess(agentSuccess);
        log.info("AgentCreateServiceImpl::Agent Success::{}",gson.toJson(agentSuccess));
    }

    private void unSuccessfulAgent(RuntimeException e, DmsState state, LocalDateTime startDate) {
        AgentFailure agentFailure = new AgentFailure();
        agentFailure.setEntryTimeStamp(startDate);
        agentFailure.setRequest_type("AGNCRT");
        agentFailure.setStatus(HttpStatus.NO_CONTENT);
        agentFailure.setRequest(getMessage());
        agentFailure.setResponseError("IBM 2033 Exception occurred");
        agentFailure.setMessage("Response is null");
        agentFailure.setPath("/pnbmetlife/v1/agent");
        agentFailure.setExitTimeStamp(LocalDateTime.now());
        FailureAgentRequest(agentFailure);
        state.setAgentFailure(agentFailure);
        log.error("AgentCreateServiceImpl::Agent Failure::{}",gson.toJson(agentFailure));
    }

    private void validationError(ResponseEntity entity, DmsState state, LocalDateTime startDate, LocalDateTime endDate){
        log.error("Life Asia is unable to create the agent due to Validation error.");
        AgentFailure agentFailure = new AgentFailure();
        agentFailure.setEntryTimeStamp(startDate);
        agentFailure.setRequest_type("AGNCRT");
        agentFailure.setStatus(HttpStatus.BAD_REQUEST);
        agentFailure.setRequest(getMessage());
        agentFailure.setResponseError(entity.getBody().toString());
        agentFailure.setMessage("Response contains validation errors");
        agentFailure.setPath("/pnbmetlife/v1/agent");
        agentFailure.setExitTimeStamp(endDate);
        FailureAgentRequest(agentFailure);
        state.setAgentFailure(agentFailure);
        log.info("AgentCreateServiceImpl::Agent Validation Failure::{}",gson.toJson(agentFailure));
    }

}
