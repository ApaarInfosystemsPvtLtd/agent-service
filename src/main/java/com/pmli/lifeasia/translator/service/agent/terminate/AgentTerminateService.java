package com.pmli.lifeasia.translator.service.agent.terminate;

import com.pmli.lifeasia.translator.Exception.agent.AgentFailure;
import com.pmli.lifeasia.translator.Exception.agent.AgentSuccess;
import com.pmli.lifeasia.translator.model.DmsState;
import com.pmli.lifeasia.translator.model.agent.AgentModificationMessageBodyResponseDTO;
import com.pmli.lifeasia.translator.model.agent.terminate.AgentTerminateMessageBody;

public interface AgentTerminateService {
    AgentModificationMessageBodyResponseDTO terminateAgent(DmsState state,AgentTerminateMessageBody agentTerminateMessageBody);
    void storeSuccessAgentRequest(AgentSuccess agentSuccess);
    void storeFailureAgentRequest(AgentFailure agentFailure);
}
