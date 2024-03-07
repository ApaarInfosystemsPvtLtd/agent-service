package com.pmli.lifeasia.translator.service.agent;


import com.google.gson.Gson;
import com.pmli.lifeasia.translator.initialize.MasterStore;
import com.pmli.lifeasia.translator.model.DmsState;
import com.pmli.lifeasia.translator.model.Validation;
import com.pmli.lifeasia.translator.model.agent.*;
import com.pmli.lifeasia.translator.model.client.ClientCRPMessageBodyRequestDTO;
import com.pmli.lifeasia.translator.model.client.ClientCRPMessageBodyResponseDTO;
import com.pmli.lifeasia.translator.repo.AgentCreateRequestRepository;
import com.pmli.lifeasia.translator.repo.DmsStateRepo;
import com.pmli.lifeasia.translator.service.client.ClientCRPServiceImpl;
import com.pmli.lifeasia.translator.util.AgentModelMapper;
import com.pmli.lifeasia.translator.util.validation.CreateValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;


@Component
public class AgentCreateRequestServiceImpl implements AgentCreateRequestService {
    private final static Logger log = LogManager.getLogger(AgentCreateRequestServiceImpl.class);

    @Autowired
    AgentCreateRequestRepository createRequestRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ClientCRPServiceImpl clientCRPService;

    @Autowired
    AgentCreateServiceImpl agnCRTIService;

    @Autowired
    AgentModelMapper agentModelMapper;

    @Autowired
    MasterStore masterStore;

    @Autowired
    Gson gson;

    @Autowired
    DmsStateRepo dmsStateRepo;

    @Override
    public AgentCreateRequestDTO saveRequest(AgentCreateRequestDTO agentCreateRequestDTO) {
        return createRequestRepository.save(agentCreateRequestDTO);
    }

    @Override
    public AgentCreateMessageBodyRequestDTO mapAgent(AgentCreateRequestDTO agentCreateRequestDTO) {
        AgentCreateMessageBodyRequestDTO agentCreateMessageBodyRequestDTO = modelMapper.map(agentCreateRequestDTO, AgentCreateMessageBodyRequestDTO.class);
        ClientCRPMessageBodyResponseDTO clientCRPMessageBodyResponseDTO = new ClientCRPMessageBodyResponseDTO();
        agentCreateMessageBodyRequestDTO.setClnsel(clientCRPMessageBodyResponseDTO.getclntnum());
        log.info("AgentCreateRequestServiceImpl::mapAgent::AgentCreateMessageBodyRequestDTO::" + agentCreateMessageBodyRequestDTO);
        return agentCreateMessageBodyRequestDTO;
    }

    @Override
    public ClientCRPMessageBodyRequestDTO mapClient(AgentCreateRequestDTO agentCreateRequestDTO) {
        ClientCRPMessageBodyRequestDTO clientCRPMessageBodyRequestDTO = modelMapper.map(agentCreateRequestDTO, ClientCRPMessageBodyRequestDTO.class);
        log.info("AgentCreateRequestServiceImpl::mapClient::ClientCRPMessageBodyRequestDTO::{}", gson.toJson(clientCRPMessageBodyRequestDTO));
        return clientCRPMessageBodyRequestDTO;
    }

    public AgentCreateResponseDTO agentCreation(CreateRequestDTO createRequestDTO) {
        /**
         * Logging details In DB
         * */
        log.info("AgentCreateRequestServiceImpl::AgentCreateResponseDTO::EntryTime::{}", LocalDateTime.now());
        DmsState state = new DmsState();
        state.setEntryTimeStamp(LocalDateTime.now());
        state.setRequest(gson.toJson(createRequestDTO));
        state.setAgentCode(createRequestDTO.getAgentCode());
        state.setProcess("Agent Creation");

        AgentCreateResponseDTO agentCreateResponseDTO = new AgentCreateResponseDTO();
        Validation validation = CreateValidator.validate(createRequestDTO, masterStore);
        if (!validation.isValid()) {
            agentCreateResponseDTO.setClientnum("");
            agentCreateResponseDTO.setAgentnum("");
            agentCreateResponseDTO.setState("Agent Failure");
            agentCreateResponseDTO.setMessage(validation.getErrors().toString());
            state.setStatus("FAILURE");
            state.setResponse(gson.toJson(agentCreateResponseDTO));
            log.error("AgentCreateRequestServiceImpl::agentCreation::validationError::{}", gson.toJson(validation));
            return agentCreateResponseDTO;
        }
        AgentCreateRequestDTO agentCreateRequestDTO = agentModelMapper.createAgentMap(createRequestDTO);
        log.info("AgentCreateRequestServiceImpl::agentCreation::After Mapping the AgentCreateRequestDTO::{}", gson.toJson(agentCreateRequestDTO));
        log.info("AgentControllerV1::AgentCreateRequestDTO::Data is saved in database.");
        saveRequest(agentCreateRequestDTO);
        ClientCRPMessageBodyRequestDTO clientCRPMessageBodyRequestDTO = mapClient(agentCreateRequestDTO);

        ClientCRPMessageBodyResponseDTO clientCRPMessageBodyResponseDTO = clientCRPService.createClient(clientCRPMessageBodyRequestDTO, state).get(0);
        log.info("AgentCreateRequestServiceImpl::agentCreation::ClientCRPMessageBodyResponseDTO::{}", gson.toJson(clientCRPMessageBodyResponseDTO));

        if ("Success".equalsIgnoreCase(clientCRPMessageBodyResponseDTO.getState())) {
            AgentCreateMessageBodyRequestDTO agentCreateMessageBodyRequestDTO = mapAgent(agentCreateRequestDTO);
            agentCreateMessageBodyRequestDTO.setClnsel(clientCRPMessageBodyResponseDTO.getclntnum() + "  ");
            waitForLACommit();
            AgentCreateMessageBodyResponseDTO agentCreateMessageBodyResponseDTO = agnCRTIService.createAgent(agentCreateMessageBodyRequestDTO, state).get(0);

            if ("Success".equalsIgnoreCase(agentCreateMessageBodyResponseDTO.getState())) {
                agentCreateResponseDTO.setClientnum(clientCRPMessageBodyResponseDTO.getclntnum());
                agentCreateResponseDTO.setAgentnum(agentCreateMessageBodyResponseDTO.getagnum());
                agentCreateResponseDTO.setState("Success");
                agentCreateResponseDTO.setMessage("Agent Created Successfully.");
                state.setStatus("SUCCESS");
                state.setResponse(gson.toJson(agentCreateResponseDTO));
                log.info("AgentCreateMessageBodyResponseDTO::" + agentCreateResponseDTO);
            } else if ("Failure".equalsIgnoreCase(agentCreateMessageBodyResponseDTO.getState())) {
                agentCreateResponseDTO.setClientnum(clientCRPMessageBodyResponseDTO.getclntnum());
                agentCreateResponseDTO.setAgentnum("");
                agentCreateResponseDTO.setState("Agent Failure");
                agentCreateResponseDTO.setMessage(agentCreateMessageBodyResponseDTO.getMessage());
                state.setResponse(gson.toJson(agentCreateResponseDTO));
                state.setStatus("FAILURE");
                log.error("AgentCreateMessageBodyResponseDTO::" + agentCreateResponseDTO);
            }
        } else if ("Failure".equalsIgnoreCase(clientCRPMessageBodyResponseDTO.getState())) {
            agentCreateResponseDTO.setClientnum("");
            agentCreateResponseDTO.setAgentnum("");
            agentCreateResponseDTO.setState("Client Failure");
            agentCreateResponseDTO.setMessage(clientCRPMessageBodyResponseDTO.getMessage());
            state.setResponse(gson.toJson(agentCreateResponseDTO));
            state.setStatus("FAILURE");
            log.error("AgentCreateMessageBodyResponseDTO::" + agentCreateResponseDTO);
        }
        /**
         * Saving DMS_State inside MongoDB.
         * */
        state.setExitTimeStamp(LocalDateTime.now());
        dmsStateRepo.save(state);
        log.info("AgentCreateRequestServiceImpl::AgentCreateResponseDTO::ExitTime::{}", LocalDateTime.now());

        return agentCreateResponseDTO;
    }

    private void waitForLACommit() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error("waitForLACommit::Interrupted Exception::{}", Arrays.asList(e.getStackTrace()));
            System.out.println("Interrupted Exception" + e);
            Thread.currentThread().interrupt();
        }
    }
}
