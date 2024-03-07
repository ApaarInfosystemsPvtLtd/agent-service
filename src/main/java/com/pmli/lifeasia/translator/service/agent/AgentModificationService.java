package com.pmli.lifeasia.translator.service.agent;

import com.pmli.lifeasia.translator.Exception.agent.AgentFailure;
import com.pmli.lifeasia.translator.Exception.agent.AgentSuccess;
import com.pmli.lifeasia.translator.model.DmsState;
import com.pmli.lifeasia.translator.model.agent.AgentModificationMessageBodyRequestDTO;
import com.pmli.lifeasia.translator.model.agent.AgentModificationMessageBodyResponseDTO;

import java.util.List;

public interface AgentModificationService
{
    /*List<AgentModificationMessageBodyRequestDTO> saveModifyAgent(List<AgentModificationMessageBodyRequestDTO> agentModificationMessageBodyRequestDTO);*/
    List<AgentModificationMessageBodyResponseDTO> modifyAgent(AgentModificationMessageBodyRequestDTO agentModificationMessageBodyRequestDTO, DmsState state);
    void SuccessAgentRequest(AgentSuccess agentSuccess);
    void FailureAgentRequest(AgentFailure agentFailure);
}
