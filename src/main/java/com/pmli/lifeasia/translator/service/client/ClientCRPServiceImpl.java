package com.pmli.lifeasia.translator.service.client;

import com.google.gson.Gson;
import com.pmli.lifeasia.translator.Exception.client.ClientFailure;
import com.pmli.lifeasia.translator.Exception.client.ClientSuccess;
import com.pmli.lifeasia.translator.Exception.runtime.CustomException;
import com.pmli.lifeasia.translator.connector.ConsumeLifeAsiaConnector;
import com.pmli.lifeasia.translator.model.DmsState;
import com.pmli.lifeasia.translator.model.client.*;
import com.pmli.lifeasia.translator.repo.ClientCRPRequestRepository;
import com.pmli.lifeasia.translator.repo.ClientCRPSuccessRepository;
import com.pmli.lifeasia.translator.repo.ClientFailureRepository;
import com.pmli.lifeasia.translator.repo.DmsStateRepo;
import com.pmli.lifeasia.translator.util.ClientCRPResponseParser;
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
public class ClientCRPServiceImpl implements ClientCRPService
{

    private final static Logger log = LogManager.getLogger(ClientCRPServiceImpl.class);

    @Autowired
    DmsStateRepo dmsStateRepo;

    @Autowired
    ConsumeLifeAsiaConnector consumeLifeAsiaConnector;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    MongoTemplate mongoDBTemplate;

    @Autowired
    ClientCRPRequestRepository clientCRPRequestRepository;

    @Autowired
    ClientCRPSuccessRepository successRepository;

    @Autowired
    ClientFailureRepository failureRepository;

    @Autowired
    ClientCRPResponseParser parser;

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
    public List<ClientCRPMessageBodyResponseDTO> createClient(ClientCRPMessageBodyRequestDTO clientCRPMessageBodyRequestDTO, DmsState state) {
        List<ClientCRPMessageBodyResponseDTO> clientCRPMessageBodyResponseDTOS = new ArrayList<>();
        log.info("ClientCRPServiceImpl::createClient::EntryTime::{}", LocalDateTime.now());
        ClientCRPMessageBodyResponse clientCRPMessageBodyResponses = new ClientCRPMessageBodyResponse();
        log.info("ClientCRPServiceImpl::createClient::************Inside Client Creation Process*******::");
        LocalDateTime startDate = null;
        LocalDateTime endDate = null;
        try {
            log.info("ClientCRPServiceImpl::ClientCRPMessageBodyRequestDTO::Data is Saved in Database.");
            clientCRPRequestRepository.save(clientCRPMessageBodyRequestDTO);
            ClientCRPMessageBodyRequest clientCRPMessageBodyRequest = mapClientCRPIMessage(clientCRPMessageBodyRequestDTO);
            setMessage(buildClientCRPIBOMessage(clientCRPMessageBodyRequest));
            log.info("ClientCRPServiceImpl::createClient::request message::{}::",message);
            log.info("ClientCRPServiceImpl::consumeLifeAsiaConnector::EntryTime::{}", LocalDateTime.now());
            startDate = LocalDateTime.now();
            ResponseEntity<String> response = consumeLifeAsiaConnector.createClient(message);
            endDate = LocalDateTime.now();
            log.info("ClientCRPServiceImpl::consumeLifeAsiaConnector::ExitTime::{}", LocalDateTime.now());
            //ResponseEntity<String> response = lifeasiaClient.createClient(message);
            log.info("ClientCRPServiceImpl::createClient::Response Entity ::{}",response.toString());
            clientCRPMessageBodyResponses = parseResponse(response.getBody());
            ClientCRPResponseParser responseParser = new ClientCRPResponseParser();
            String messageHeader = responseParser.extractClientCRPMessageText(response.getBody(), 0, 130);
            ClientCRPMessageHeader clientCRPMessageHeader = responseParser.buildClientCRPMessageHeader(messageHeader);

            if ("CLNPERO   ".equalsIgnoreCase(clientCRPMessageHeader.getMSGID())) { //As Per Client Change the String
                updateClientStatus("Completed");
                successfulClient(response,state,startDate,endDate);
            }
            else if ("BOVERR    ".equalsIgnoreCase(clientCRPMessageHeader.getMSGID())) { //As Per Client Change the String
                updateClientStatus("Validation Error");
                validationError(response,state,startDate,endDate);
            } else {
                updateClientStatus("Validation Error");
                validationError(response,state,startDate,endDate);
            }
        }
        catch (RuntimeException e)
        {
            updateClientStatus("ClientCreation::LifeAsia connection Error");
            unSuccessfulClient(e,state,startDate);
            state.setExitTimeStamp(LocalDateTime.now());
            state.setStatus("FAILURE");
            dmsStateRepo.save(state);
            log.error("ClientCRPServiceImpl::ClientCreation::LifeAsia connection Error::{}", Arrays.asList(e.getStackTrace()));
            throw new CustomException("ClientCreation::LifeAsia connection Error");

        }
        ClientCRPMessageBodyResponseDTO clientCRPMessageBodyResponseDTO = modelMapper.map(clientCRPMessageBodyResponses,ClientCRPMessageBodyResponseDTO.class);
        clientCRPMessageBodyResponseDTOS.add(clientCRPMessageBodyResponseDTO);
        log.info("ClientCRPServiceImpl::createClient::EntryTime::{}", LocalDateTime.now());
        return clientCRPMessageBodyResponseDTOS;
    }

    private ClientCRPMessageBodyRequest mapClientCRPIMessage(ClientCRPMessageBodyRequestDTO clientCRPMessageBodyRequestDTO)
    {
        ClientCRPMessageBodyRequest clientCRPMessageBodyRequest = modelMapper.
                map(clientCRPMessageBodyRequestDTO,ClientCRPMessageBodyRequest.class);
        clientCRPMessageBodyRequest.setAction("A");
        log.info("ClientCRPServiceImpl::mapClientCRPIMessage::ClientCRPMessageBodyRequest::{}",new Gson().toJson(clientCRPMessageBodyRequest));
        return clientCRPMessageBodyRequest;
    }

    private String buildClientCRPIBOMessage(ClientCRPMessageBodyRequest clientCRPMessageBodyRequest)
    {
        return new StringBuilder()
                .append(buildClientCRPLeaderHeader())
                .append("SESSIONI  0001000001          210E000000")
                .append(buildClientMessageHeader())
                .append(buildClientCRPIMessageBody(clientCRPMessageBodyRequest)).toString();

//        return "        DMSAUTO   QPADEV002GCLN2      AGN       003251YIRN0                                         SESSIONI  0001000001          210E000000AGNCRTI   0015500001          K19940119    591307                Div Midname                                                 C                                                                                                                                 ";
    }

    private String buildClientMessageHeader() {
        log.info("ClientCRPServiceImpl::buildClientMessageHeader::{}",new ClientCRPMessageHeader().toJson());
        return new ClientCRPMessageHeader().toString();
    }

    private String buildClientCRPIMessageBody(ClientCRPMessageBodyRequest clientCRPMessageBodyRequest) {
        log.info("ClientCRPServiceImpl::buildClientCRPIMessageBody::{}",new Gson().toJson(clientCRPMessageBodyRequest));
        return clientCRPMessageBodyRequest.toString();
    }

    private String buildClientCRPLeaderHeader() {
        ClientCRPLeaderHeader clientCRPLeaderHeader = new ClientCRPLeaderHeader();
        clientCRPLeaderHeader.setUSRPRF(usrprf);
        log.info("ClientCRPServiceImpl::buildClientCRPLeaderHeader::{}",new Gson().toJson(clientCRPLeaderHeader));
        return  clientCRPLeaderHeader.toString();
    }

    private ClientCRPMessageBodyResponse parseResponse(String response) {
        log.info("ClientCRPServiceImpl::parseResponse::{}",response);
        ClientCRPMessageBodyResponse crpMessageBodyResponse = parser.parseResponse(response);
        return crpMessageBodyResponse;
    }

    private void updateClientStatus(String status) {
        Query query = new Query();
        query.addCriteria(Criteria.where("status").is("Received"));
        Update update = new Update();
        update.set("status", status);
        mongoDBTemplate.upsert(query,update, ClientCRPMessageBodyRequestDTO.class);
    }

    private void successfulClient(ResponseEntity entity,DmsState state,LocalDateTime startDate,LocalDateTime endDate) {
        ClientSuccess clientSuccess = new ClientSuccess();
        clientSuccess.setEntryTimeStamp(startDate);
        clientSuccess.setRequest_Type("CLNCRT");
        clientSuccess.setRequest(getMessage());
        clientSuccess.setResponse(entity.getBody().toString());
        clientSuccess.setExitTimeStamp(endDate);
        SuccessClientRequest(clientSuccess);
        state.setClientSuccess(clientSuccess);
        log.info("ClientCRPServiceImpl::successfulClient::{}",new Gson().toJson(clientSuccess));
    }

    private void unSuccessfulClient(RuntimeException e,DmsState state, LocalDateTime startDate) {
        log.info("ClientCRPServiceImpl::unSuccessfulClient::Life asia is unable to create the client.{}",Arrays.asList(e.getStackTrace()));
        ClientFailure clientFailure = new ClientFailure();
        clientFailure.setEntryTimeStamp(startDate);
        clientFailure.setRequest_type("CLNCRT");
        clientFailure.setStatus(HttpStatus.NO_CONTENT);
        clientFailure.setRequest(getMessage());
        clientFailure.setResponseError("IBM 2033 Exception occurred");
        clientFailure.setMessage("Response is null");
        clientFailure.setPath("/pnbmetlife/v1/agent");
        clientFailure.setExitTimeStamp(LocalDateTime.now());
        FailureClientRequest(clientFailure);
        state.setClientFailure(clientFailure);
        log.info("ClientCRPServiceImpl::unSuccessfulClient::{}",new Gson().toJson(clientFailure));
    }

    private void validationError(ResponseEntity entity,DmsState state,LocalDateTime startDate,LocalDateTime endDate){
        log.info("ClientCRPServiceImpl::validationError::Life Asia is unable to create the agent due to Validation error.");
        //System.out.println("Life Asia is unable to create the agent due to Validation error.");
        ClientFailure clientFailure = new ClientFailure();
        clientFailure.setEntryTimeStamp(startDate);
        clientFailure.setRequest_type("CLNCRT");
        clientFailure.setStatus(HttpStatus.BAD_REQUEST);
        clientFailure.setRequest(getMessage());
        clientFailure.setResponseError(entity.getBody().toString());
        clientFailure.setMessage("Response contains validation errors");
        clientFailure.setPath("/pnbmetlife/v1/agent");
        clientFailure.setExitTimeStamp(endDate);
        FailureClientRequest(clientFailure);
        state.setClientFailure(clientFailure);
        log.info("ClientRPServiceImpl::validationError::{}",new Gson().toJson(clientFailure));
    }

}
