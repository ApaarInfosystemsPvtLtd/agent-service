package com.pmli.lifeasia.translator.service.agent.reinstate;

import com.pmli.lifeasia.translator.Exception.agent.AgentFailure;
import com.pmli.lifeasia.translator.Exception.agent.AgentSuccess;
import com.pmli.lifeasia.translator.model.DmsState;
import com.pmli.lifeasia.translator.model.agent.AgentModificationMessageBodyResponseDTO;
import com.pmli.lifeasia.translator.model.agent.reinstate.AgentReinstateMessageBody;

public interface AgentReinstateService {
    AgentModificationMessageBodyResponseDTO reinstateAgent(DmsState state,AgentReinstateMessageBody agentReinstateMessageBody);
    void storeSuccessAgentRequest(AgentSuccess agentSuccess);
    void storeFailureAgentRequest(AgentFailure agentFailure);
}
