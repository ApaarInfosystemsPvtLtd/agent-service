package com.pmli.lifeasia.translator.service.agent;


import com.pmli.lifeasia.translator.Exception.agent.AgentFailure;
import com.pmli.lifeasia.translator.Exception.agent.AgentSuccess;
import com.pmli.lifeasia.translator.model.DmsState;
import com.pmli.lifeasia.translator.model.agent.AgentCreateMessageBodyRequestDTO;
import com.pmli.lifeasia.translator.model.agent.AgentCreateMessageBodyResponseDTO;

import java.util.List;

public interface AgentCreateService
{
    List<AgentCreateMessageBodyResponseDTO> createAgent(AgentCreateMessageBodyRequestDTO agentCreateMessageBodyRequestDTO, DmsState state);
    /*List<AgentCreateMessageBodyRequest> saveCreateAgent(List<AgentCreateMessageBodyRequestDTO> agentCreateMessageBodyRequestDTO);*/
    void SuccessAgentRequest(AgentSuccess agentSuccess);
    void FailureAgentRequest(AgentFailure agentFailure);
}
