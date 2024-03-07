package com.pmli.lifeasia.translator.service.agent;

import com.pmli.lifeasia.translator.model.agent.AgentModificationMessageBodyRequestDTO;
import com.pmli.lifeasia.translator.model.agent.AgentModifyRequestDTO;
import com.pmli.lifeasia.translator.model.client.ClientMODPMessageBodyRequestDTO;

public interface AgentModifyRequestService
{
    AgentModifyRequestDTO saveRequest(AgentModifyRequestDTO agentModifyRequestDTO);
    AgentModificationMessageBodyRequestDTO mapAgent(AgentModifyRequestDTO agentModifyRequestDTO);
    ClientMODPMessageBodyRequestDTO mapClient(AgentModifyRequestDTO agentModifyRequestDTO);
}
