package com.pmli.lifeasia.translator.controller;

import com.google.gson.Gson;
import com.pmli.lifeasia.translator.initialize.MasterStore;
import com.pmli.lifeasia.translator.model.agent.AgentCreateResponseDTO;
import com.pmli.lifeasia.translator.model.agent.AgentModifyResponseDTO;
import com.pmli.lifeasia.translator.model.agent.CreateRequestDTO;
import com.pmli.lifeasia.translator.model.agent.ModifyRequestDTO;
import com.pmli.lifeasia.translator.service.agent.AgentCreateRequestServiceImpl;
import com.pmli.lifeasia.translator.service.agent.AgentModifyRequestServiceImpl;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/agent-sp-advisor/")
@Api(value = "Agent Service")
public class AgentControllerV1 {

    private final static Logger log = LogManager.getLogger(AgentControllerV1.class);

    @Autowired
    AgentModifyRequestServiceImpl agentModifyRequestService;
    @Autowired
    AgentCreateRequestServiceImpl agentCreateRequestService;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    MasterStore masterStore;

    @PostMapping(value = "/create-agent")
    public ResponseEntity<AgentCreateResponseDTO> createAgent(
            @RequestBody CreateRequestDTO createRequestDTO) {
        log.info("AgentControllerV1::createAgent::For Agent Code::{}::EntryTime::{}",createRequestDTO.getAgentCode(), LocalDateTime.now());
        log.info("AgentControllerV1::createAgent::CreateRequestDTO::{}",new Gson().toJson(createRequestDTO));
        AgentCreateResponseDTO agentCreateResponseDTO = agentCreateRequestService.agentCreation(createRequestDTO);
        log.info("AgentControllerV1::createAgent::AgentCreateResponseDTO::{}",new Gson().toJson(agentCreateResponseDTO));
        log.info("AgentControllerV1::createAgent::For Agent Code::{}::ExitTime::{}",createRequestDTO.getAgentCode(), LocalDateTime.now());
        return new ResponseEntity<>(agentCreateResponseDTO, HttpStatus.CREATED);
    }

    @PostMapping(value = "/update-agent")
    public ResponseEntity<AgentModifyResponseDTO> modifyAgent(
            @RequestBody ModifyRequestDTO modifyRequestDTO) {
        log.info("AgentControllerV1::modifyAgent::For Agent Code::{}::EntryTime::{}",modifyRequestDTO.getAgentCode(), LocalDateTime.now());
        log.info("AgentControllerV1::modifyAgent::ModifyRequestDTO::{}",new Gson().toJson(modifyRequestDTO));
        AgentModifyResponseDTO agentModifyResponseDTO = agentModifyRequestService.agentModification(modifyRequestDTO);
        log.info("AgentControllerV1::modifyAgent::AgentModifyResponseDTO::{}",new Gson().toJson(agentModifyResponseDTO));
        log.info("AgentControllerV1::modifyAgent::For Agent Code::{}::ExitTime::{}",modifyRequestDTO.getAgentCode(), LocalDateTime.now());
        return new ResponseEntity<>(agentModifyResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/refreshMaster")
    public ResponseEntity<String> refreshMasterStoreData() {
        log.info("Removing old initialized MasterStore Data.");
        masterStore.clear();
        log.info("Initializing new MasterStore Data form Mongo database.");
        masterStore.initialize();
        return  new ResponseEntity<>("New Data have been Initialized to MasterStore", HttpStatus.OK);
    }

}