package com.pmli.lifeasia.translator.service.agent;

import com.google.gson.Gson;
import com.pmli.lifeasia.translator.initialize.MasterStore;
import com.pmli.lifeasia.translator.model.DmsState;
import com.pmli.lifeasia.translator.model.Validation;
import com.pmli.lifeasia.translator.model.agent.*;
import com.pmli.lifeasia.translator.model.agent.reinstate.AgentReinstateMessageBody;
import com.pmli.lifeasia.translator.model.agent.terminate.AgentTerminateMessageBody;
import com.pmli.lifeasia.translator.model.client.ClientMODPMessageBodyRequestDTO;
import com.pmli.lifeasia.translator.model.client.ClientMODPMessageBodyResponseDTO;
import com.pmli.lifeasia.translator.repo.AgentModifyRequestRepository;
import com.pmli.lifeasia.translator.repo.DmsStateRepo;
import com.pmli.lifeasia.translator.service.agent.reinstate.AgentReinstateService;
import com.pmli.lifeasia.translator.service.agent.terminate.AgentTerminateService;
import com.pmli.lifeasia.translator.service.client.ClientMODPServiceImpl;
import com.pmli.lifeasia.translator.util.AgentModelMapper;
import com.pmli.lifeasia.translator.util.validation.ModifyValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class AgentModifyRequestServiceImpl implements AgentModifyRequestService {

    private final static Logger log = LogManager.getLogger(AgentModifyRequestServiceImpl.class);

    @Autowired
    AgentModifyRequestRepository agentModifyRequestRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ClientMODPServiceImpl clientMODPService;

    @Autowired
    AgentModificationServiceImpl agentModificationService;

    @Autowired
    AgentTerminateService agentTerminateService;

    @Autowired
    AgentReinstateService agentReinstateService;

    @Autowired
    AgentModelMapper agentModelMapper;

    @Autowired
    MasterStore masterStore;

    @Autowired
    Gson gson;

    @Autowired
    DmsStateRepo dmsStateRepo;

    @Override
    public AgentModifyRequestDTO saveRequest(AgentModifyRequestDTO agentModifyRequestDTO) {
        return agentModifyRequestRepository.save(agentModifyRequestDTO);
    }

    @Override
    public AgentModificationMessageBodyRequestDTO mapAgent(AgentModifyRequestDTO agentModifyRequestDTO) {
        AgentModificationMessageBodyRequestDTO agentModificationMessageBodyRequestDTO = modelMapper.map(agentModifyRequestDTO, AgentModificationMessageBodyRequestDTO.class);
        return agentModificationMessageBodyRequestDTO;
    }

    @Override
    public ClientMODPMessageBodyRequestDTO mapClient(AgentModifyRequestDTO agentModifyRequestDTO) {
        ClientMODPMessageBodyRequestDTO clientMODPMessageBodyRequestDTO = modelMapper.map(agentModifyRequestDTO, ClientMODPMessageBodyRequestDTO.class);
        log.info("AgentControllerV1::mapClient::ClientMapping::{}", gson.toJson(clientMODPMessageBodyRequestDTO));
        return clientMODPMessageBodyRequestDTO;
    }

    public AgentModifyResponseDTO agentModification(ModifyRequestDTO modifyRequestDTO) {
        ModifyRequestDTO requestDTO = modelMapper.map(modifyRequestDTO,ModifyRequestDTO.class);
        /*Logging details In DB*/
        DmsState state = new DmsState();
        state.setEntryTimeStamp(LocalDateTime.now());
        state.setRequest(gson.toJson(requestDTO));
        state.setAgentCode(requestDTO.getAgentCode());

        AgentModifyResponseDTO agentModifyResponseDTO = new AgentModifyResponseDTO();
        if (isTerminateAgent(requestDTO)) {
            log.info("AgentModifyRequestServiceImpl::agentModification::isTerminateAgent.");
            state.setProcess("Agent Termination");
            terminateAgent(requestDTO, agentModifyResponseDTO,state);
        } else if (isReInstantiateAgent(requestDTO)) {
            log.info("AgentModifyRequestServiceImpl::agentModification::isReInstantiateAgent.");
            state.setProcess("Agent ReInstantiate");
            reinstateAgent(requestDTO, agentModifyResponseDTO,state);
        } else {
            log.info("AgentModifyRequestServiceImpl::agentModification::updateAgent.");
            state.setProcess("Agent Modification");
            updateAgent(requestDTO, agentModifyResponseDTO,state);
        }
        state.setResponse(gson.toJson(agentModifyResponseDTO));
        state.setExitTimeStamp(LocalDateTime.now());
        /*Saving DMS_State inside MongoDB*/
        dmsStateRepo.save(state);
        return agentModifyResponseDTO;
    }

    boolean isReInstantiateAgent(ModifyRequestDTO modifyRequestDTO) {
        return "REINSTATE".equalsIgnoreCase(modifyRequestDTO.getAgentStatus());
    }

    void terminateAgent(ModifyRequestDTO modifyRequestDTO, AgentModifyResponseDTO agentModifyResponseDTO,DmsState state) {
        if (modifyRequestDTO.getDateOfTermination() == null || "".equalsIgnoreCase(modifyRequestDTO.getDateOfTermination().trim())) {
            agentModifyResponseDTO.setClientnum("");
            agentModifyResponseDTO.setAgentnum("");
            agentModifyResponseDTO.setState("Agent Termination Failed");
            agentModifyResponseDTO.setMessage("Termination Date should be valid.");
            state.setStatus("FAILURE");
            log.error("AgentModifyRequestServiceImpl::terminateAgent::Agent Termination Error::{}",gson.toJson(agentModifyResponseDTO));
        }

        AgentModificationMessageBodyResponseDTO agentModificationMessageBodyResponseDTO = agentTerminateService.terminateAgent(state,new AgentTerminateMessageBody(modifyRequestDTO.getAgentCode(), modifyRequestDTO.getDateOfTermination(),modifyRequestDTO.getAllowCommissionPayment()));
        if ("Success".equalsIgnoreCase(agentModificationMessageBodyResponseDTO.getState())) {
            agentModifyResponseDTO.setClientnum(modifyRequestDTO.getClientCode());
            agentModifyResponseDTO.setAgentnum(modifyRequestDTO.getAgentCode());
            agentModifyResponseDTO.setState("Success");
            agentModifyResponseDTO.setMessage("Agent Terminated Successfully.");
            state.setStatus("SUCCESS");
            log.info("AgentModifyRequestServiceImpl::terminateAgent::Agent Terminated Successfully::{}",gson.toJson(agentModifyResponseDTO));

        } else if ("Failure".equalsIgnoreCase(agentModificationMessageBodyResponseDTO.getState())) {

            agentModifyResponseDTO.setClientnum(modifyRequestDTO.getClientCode());
            agentModifyResponseDTO.setAgentnum(modifyRequestDTO.getAgentCode());
            agentModifyResponseDTO.setState("Agent Failure.");
            state.setStatus("FAILURE");
            agentModifyResponseDTO.setMessage(agentModificationMessageBodyResponseDTO.getMessage());
            log.error("AgentModifyRequestServiceImpl::terminateAgent::Agent Termination Error::{}",gson.toJson(agentModifyResponseDTO));
        }
    }

    boolean isTerminateAgent(ModifyRequestDTO modifyRequestDTO) {
        return "TERMINATE".equalsIgnoreCase(modifyRequestDTO.getAgentStatus());
    }

    void updateAgent(ModifyRequestDTO modifyRequestDTO, AgentModifyResponseDTO agentModifyResponseDTO,DmsState state) {

        Validation validation = ModifyValidator.validate(modifyRequestDTO, masterStore);
        if (!validation.isValid()) {
            agentModifyResponseDTO.setClientnum("");
            agentModifyResponseDTO.setAgentnum("");
            agentModifyResponseDTO.setState("Client Failure");
            state.setStatus("FAILURE");
            agentModifyResponseDTO.setMessage(validation.getErrors().toString());
            log.error("AgentModifyRequestServiceImpl::updateAgent::Agent Modification Validation Error::{}",gson.toJson(agentModifyResponseDTO));
        }

        AgentModifyRequestDTO agentModifyRequestDTO = agentModelMapper.modifyAgentMap(modifyRequestDTO);
        log.info("AgentModifyRequestServiceImpl::updateAgent::After Mapping the AgentModifyRequestDTO::" + gson.toJson(agentModifyRequestDTO));
        log.info("AgentModifyRequestServiceImpl::updateAgent::AgentModifyRequestDTO::Data is saved in database.");
        saveRequest(agentModifyRequestDTO);
        ClientMODPMessageBodyRequestDTO clientMODPMessageBodyRequestDTO = mapClient(agentModifyRequestDTO);

        ClientMODPMessageBodyResponseDTO clientMODPMessageBodyResponseDTO = clientMODPService.modifyClient(clientMODPMessageBodyRequestDTO,state).get(0);
        log.info("AgentModifyRequestServiceImpl::updateAgent::ClientMODPMessageBodyResponseDTO::{}",gson.toJson(clientMODPMessageBodyResponseDTO));

        if ("Success".equalsIgnoreCase(clientMODPMessageBodyResponseDTO.getState())) {
            AgentModificationMessageBodyRequestDTO agentModificationMessageBodyRequestDTO = mapAgent(agentModifyRequestDTO);
            log.info("AgentControllerV1::AgentModifyRequestDTO::AgentMapping::" + agentModificationMessageBodyRequestDTO);
            AgentModificationMessageBodyResponseDTO agentModificationMessageBodyResponseDTO = agentModificationService.modifyAgent(agentModificationMessageBodyRequestDTO,state).get(0);
            log.info("AgentModifyRequestServiceImpl::updateAgent::AgentModificationMessageBodyResponseDTO::{}",gson.toJson(agentModificationMessageBodyResponseDTO));

            if ("Success".equalsIgnoreCase(agentModificationMessageBodyResponseDTO.getState())) {
                agentModifyResponseDTO.setClientnum(clientMODPMessageBodyResponseDTO.getClntnum());
                agentModifyResponseDTO.setAgentnum(agentModificationMessageBodyRequestDTO.getAgntsel());
                agentModifyResponseDTO.setState("Success");
                agentModifyResponseDTO.setMessage("Agent Modified Successfully.");
                state.setStatus("SUCCESS");
                log.info("AgentModifyRequestServiceImpl::updateAgent::Agent Modification Error::{}",gson.toJson(agentModifyResponseDTO));
            } else if ("Failure".equalsIgnoreCase(agentModificationMessageBodyResponseDTO.getState())) {
                agentModifyResponseDTO.setClientnum(clientMODPMessageBodyResponseDTO.getClntnum());
                agentModifyResponseDTO.setAgentnum(agentModificationMessageBodyRequestDTO.getAgntsel());
                agentModifyResponseDTO.setState("Agent Failure.");
                state.setStatus("FAILURE");
                agentModifyResponseDTO.setMessage(agentModificationMessageBodyResponseDTO.getMessage());
                log.error("AgentModifyRequestServiceImpl::updateAgent::Agent Modification Error::{}",gson.toJson(agentModifyResponseDTO));
            }
        } else if ("Failure".equalsIgnoreCase(clientMODPMessageBodyResponseDTO.getState())) {
            agentModifyResponseDTO.setClientnum("");
            agentModifyResponseDTO.setAgentnum("");
            agentModifyResponseDTO.setState("Client Failure");
            state.setStatus("FAILURE");
            agentModifyResponseDTO.setMessage(clientMODPMessageBodyResponseDTO.getMessage());
            log.error("AgentModifyRequestServiceImpl::updateAgent::Agent Modification Error::{}",gson.toJson(agentModifyResponseDTO));
        }
    }

    void reinstateAgent(ModifyRequestDTO modifyRequestDTO, AgentModifyResponseDTO agentModifyResponseDTO,DmsState state) {
        AgentModificationMessageBodyResponseDTO agentModificationMessageBodyResponseDTO =
                agentReinstateService.reinstateAgent(state,new AgentReinstateMessageBody(
                        modifyRequestDTO.getAgentCode(), "99999999"));
        if ("Success".equalsIgnoreCase(agentModificationMessageBodyResponseDTO.getState())) {
            agentModifyResponseDTO.setClientnum(modifyRequestDTO.getAgentCode());
            agentModifyResponseDTO.setAgentnum(modifyRequestDTO.getClientCode());
            agentModifyResponseDTO.setState("Success");
            agentModifyResponseDTO.setMessage("Agent Reinstated Successfully.");
            state.setStatus("SUCCESS");
            log.info("AgentModifyRequestServiceImpl::reinstateAgentAgent::Reinstated Successfully::{}",gson.toJson(agentModifyResponseDTO));

        } else if ("Failure".equalsIgnoreCase(agentModificationMessageBodyResponseDTO.getState())) {

            agentModifyResponseDTO.setClientnum(modifyRequestDTO.getAgentCode());
            agentModifyResponseDTO.setAgentnum(modifyRequestDTO.getClientCode());
            agentModifyResponseDTO.setState("Agent Failure.");
            agentModifyResponseDTO.setMessage(agentModificationMessageBodyResponseDTO.getMessage());
            state.setStatus("FAILURE");
            log.error("AgentModifyRequestServiceImpl::reinstateAgentAgent::Agent Reinstate Error::{}",gson.toJson(agentModifyResponseDTO));
        }
    }

}
