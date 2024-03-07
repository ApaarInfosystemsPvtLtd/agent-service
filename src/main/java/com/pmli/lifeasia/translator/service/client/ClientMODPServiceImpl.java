package com.pmli.lifeasia.translator.service.client;

import com.google.gson.Gson;
import com.pmli.lifeasia.translator.Exception.client.ClientFailure;
import com.pmli.lifeasia.translator.Exception.client.ClientSuccess;
import com.pmli.lifeasia.translator.Exception.runtime.CustomException;
import com.pmli.lifeasia.translator.connector.ConsumeLifeAsiaConnector;
import com.pmli.lifeasia.translator.model.DmsState;
import com.pmli.lifeasia.translator.model.client.*;
import com.pmli.lifeasia.translator.repo.ClientCRPSuccessRepository;
import com.pmli.lifeasia.translator.repo.ClientFailureRepository;
import com.pmli.lifeasia.translator.repo.ClientMODPRequestRepository;
import com.pmli.lifeasia.translator.repo.DmsStateRepo;
import com.pmli.lifeasia.translator.util.ClientMODPResponseParser;
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
public class ClientMODPServiceImpl implements ClientMODPService {

    private final static Logger log = LogManager.getLogger(ClientMODPServiceImpl.class);

    @Autowired
    DmsStateRepo dmsStateRepo;

    @Autowired
    ConsumeLifeAsiaConnector consumeLifeAsiaConnector;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    MongoTemplate mongoDBTemplate;

    @Autowired
    ClientMODPRequestRepository clientMODPRequestRepository;

    @Autowired
    ClientCRPSuccessRepository successRepository;

    @Autowired
    ClientFailureRepository failureRepository;

    @Autowired
    ClientMODPResponseParser parser;

    @Value("${leader.header.USRPRF}")
    private String usrprf;

    private String message;

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }


    @Override
    public void SuccessClientRequest(ClientSuccess clientSuccess) { successRepository.save(clientSuccess); }

    @Override
    public void FailureClientRequest(ClientFailure clientFailure) { failureRepository.save(clientFailure); }

    @Override
    public List<ClientMODPMessageBodyResponseDTO> modifyClient(ClientMODPMessageBodyRequestDTO clientMODPMessageBodyRequestDTO, DmsState state) {
        List<ClientMODPMessageBodyResponseDTO> clientMODPMessageBodyResponseDTOS = new ArrayList<>();
        ClientMODPMessageBodyResponse clientMODPMessageBodyResponses = new ClientMODPMessageBodyResponse();
        log.info("ClientMODPServiceImpl::modifyClient::************Inside Client Modification Process*******::");
        LocalDateTime startDate = null;
        LocalDateTime endDate = null;
        try {
            clientMODPRequestRepository.save(clientMODPMessageBodyRequestDTO);
            ClientMODPMessageBodyRequest clientMODPMessageBodyRequest  = mapClientCRPIMessage(clientMODPMessageBodyRequestDTO);
            setMessage(buildClientMODPIBOMessage(clientMODPMessageBodyRequest));
            log.info("ClientMODPServiceImpl::modifyClient::Message::{}::",message);
            startDate = LocalDateTime.now();
            ResponseEntity<String> response = consumeLifeAsiaConnector.modifyClient(message);
            endDate = LocalDateTime.now();
            log.info("ClientMODPServiceImpl::modifyClient::Response Entity ::{}",response.toString());
            clientMODPMessageBodyResponses = parseResponse(response.getBody());
            ClientMODPResponseParser responseParser = new ClientMODPResponseParser();
            String messageHeader = responseParser.extractClientMODPMessageText(response.getBody(), 0, 130);
            ClientMODPMessageHeader clientMODPMessageHeader = responseParser.buildClientMODPMessageHeader(messageHeader);

            if ("CLNMODPO  ".equalsIgnoreCase(clientMODPMessageHeader.getMSGID())) { //As Per Client Change the String
                updateClientStatus("Completed");
                successfulClient(response,state,startDate,endDate);
            }
            else if ("BOVERR    ".equalsIgnoreCase(clientMODPMessageHeader.getMSGID())) { //As Per Client Change the String
                updateClientStatus("Validation Error");
                validationError(response,state,startDate,endDate);
            } else {
                updateClientStatus("Validation Error");
                validationError(response,state,startDate,endDate);
            }
        }
        catch (RuntimeException e)
        {
            updateClientStatus("ClientModification::LifeAsia connection Error");
            unSuccessfulClient(e,state,startDate);
            state.setStatus("FAILURE");
            state.setExitTimeStamp(LocalDateTime.now());
            dmsStateRepo.save(state);
            log.error("ClientModification::modifyClient::LifeAsia connection Error::{}", Arrays.asList(e.getStackTrace()));
            throw new CustomException("ClientModification::LifeAsia connection Error");
        }
        ClientMODPMessageBodyResponseDTO clientMODPMessageBodyResponseDTO = modelMapper.map(clientMODPMessageBodyResponses,ClientMODPMessageBodyResponseDTO.class);
        clientMODPMessageBodyResponseDTOS.add(clientMODPMessageBodyResponseDTO);
        return clientMODPMessageBodyResponseDTOS;
    }
    private ClientMODPMessageBodyRequest mapClientCRPIMessage(ClientMODPMessageBodyRequestDTO clientMODPMessageBodyRequestDTO)
    {
        ClientMODPMessageBodyRequest clientMODPMessageBodyRequest = modelMapper.
                map(clientMODPMessageBodyRequestDTO,ClientMODPMessageBodyRequest.class);
        clientMODPMessageBodyRequest.setAction("C");
        log.info("ClientMODPServiceImpl::mapClientCRPIMessage::ClientMODPMessageBodyRequest::{}",new Gson().toJson(clientMODPMessageBodyRequest));
        return clientMODPMessageBodyRequest;
    }

    private String buildClientMODPIBOMessage(ClientMODPMessageBodyRequest clientMODPMessageBodyRequest)
    {
        return new StringBuilder()
                .append(buildClientMODPLeaderHeader())
                .append("SESSIONI  0001000001          210E000000")
                .append(buildClientMODPMessageHeader())
                .append(buildClientMODPIMessageBody(clientMODPMessageBodyRequest)).toString();

//        return "        DMSAUTO   QPADEV002GCLN2      AGN       003251YIRN0                                         SESSIONI  0001000001          210E000000AGNCRTI   0015500001          K19940119    591307                Div Midname                                                 C                                                                                                                                 ";
    }

    private String buildClientMODPMessageHeader() {
        log.info("ClientMODPServiceImpl::buildClientMODPMessageHeader::{}",new ClientMODPMessageHeader().toJson());
        return new ClientMODPMessageHeader().toString();
    }

    private String buildClientMODPIMessageBody(ClientMODPMessageBodyRequest clientMODPMessageBodyRequest) {
        log.info("ClientMODPServiceImpl::buildClientMODPIMessageBody::{}",clientMODPMessageBodyRequest.toJson());
        return clientMODPMessageBodyRequest.toString();
    }

    private String buildClientMODPLeaderHeader() {
        ClientMODPLeaderHeader clientMODPLeaderHeader = new ClientMODPLeaderHeader();
        clientMODPLeaderHeader.setUSRPRF(usrprf);
        log.info("ClientMODPServiceImpl::buildClientMODPLeaderHeader::{}",new Gson().toJson(clientMODPLeaderHeader));
        return clientMODPLeaderHeader.toString();
    }

    private ClientMODPMessageBodyResponse parseResponse(String response) {
        ClientMODPMessageBodyResponse modpMessageBodyResponseList = parser.parseResponse(response);
        log.info("ClientMODPServiceImpl::parseResponse::{}",new Gson().toJson(modpMessageBodyResponseList));
        return modpMessageBodyResponseList;
    }
    private void updateClientStatus(String status) {
        Query query = new Query();
        query.addCriteria(Criteria.where("status").is("Received"));
        Update update = new Update();
        update.set("status", status);
        mongoDBTemplate.upsert(query,update, ClientCRPMessageBodyRequestDTO.class);
    }

    private void successfulClient(ResponseEntity entity, DmsState state, LocalDateTime startDate, LocalDateTime endDate) {
        ClientSuccess clientSuccess = new ClientSuccess();
        clientSuccess.setEntryTimeStamp(startDate);
        clientSuccess.setRequest_Type("CLNMOD");
        clientSuccess.setRequest(getMessage());
        clientSuccess.setResponse(entity.getBody().toString());
        clientSuccess.setExitTimeStamp(endDate);
        log.info("ClientMODPServiceImpl::successfulClient::{}",new Gson().toJson(clientSuccess));
        SuccessClientRequest(clientSuccess);
        state.setClientSuccess(clientSuccess);
    }

    private void unSuccessfulClient(RuntimeException e, DmsState state, LocalDateTime startDate) {
        log.error("Life asia is unable to create the agent::{}",Arrays.asList(e.getStackTrace()));
        ClientFailure clientFailure = new ClientFailure();
        clientFailure.setEntryTimeStamp(startDate);
        clientFailure.setRequest_type("CLNMOD");
        clientFailure.setStatus(HttpStatus.NO_CONTENT);
        clientFailure.setRequest(getMessage());
        clientFailure.setResponseError("IBM 2033 Exception occurred");
        clientFailure.setMessage("Response is null");
        clientFailure.setPath("/pnbmetlife/v1/agent");
        clientFailure.setExitTimeStamp(LocalDateTime.now());
        log.error("ClientMODPServiceImpl::unSuccessfulClient::{}",new Gson().toJson(clientFailure));
        FailureClientRequest(clientFailure);
        state.setClientFailure(clientFailure);
    }

    private void validationError(ResponseEntity entity, DmsState state, LocalDateTime startDate, LocalDateTime endDate){
        log.error("Life Asia is unable to create the agent due to Validation error.");
        ClientFailure clientFailure = new ClientFailure();
        clientFailure.setEntryTimeStamp(startDate);
        clientFailure.setRequest_type("CLNMOD");
        clientFailure.setStatus(HttpStatus.BAD_REQUEST);
        clientFailure.setRequest(getMessage());
        clientFailure.setResponseError(entity.getBody().toString());
        clientFailure.setMessage("Response contains validation errors");
        clientFailure.setPath("/pnbmetlife/v1/agent");
        clientFailure.setExitTimeStamp(endDate);
        log.error("ClientMODPServiceImpl::unSuccessfulClient::{}",new Gson().toJson(clientFailure));
        FailureClientRequest(clientFailure);
        state.setClientFailure(clientFailure);
    }

}
