package com.pmli.lifeasia.translator.service.agent;

import com.pmli.lifeasia.translator.model.agent.AgentCreateMessageBodyRequestDTO;
import com.pmli.lifeasia.translator.model.agent.AgentCreateRequestDTO;
import com.pmli.lifeasia.translator.model.client.ClientCRPMessageBodyRequestDTO;

public interface AgentCreateRequestService {

    AgentCreateRequestDTO saveRequest(AgentCreateRequestDTO agentCreateRequestDTO);
    AgentCreateMessageBodyRequestDTO mapAgent(AgentCreateRequestDTO agentCreateRequestDTO);
    ClientCRPMessageBodyRequestDTO mapClient(AgentCreateRequestDTO agentCreateRequestDTO);
}
