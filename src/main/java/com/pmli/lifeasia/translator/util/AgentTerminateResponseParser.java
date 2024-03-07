package com.pmli.lifeasia.translator.util;

import com.pmli.lifeasia.translator.model.agent.terminate.AgentTerminateMessageBodyResponse;
import com.pmli.lifeasia.translator.model.agent.terminate.AgentTerminateMessageHeader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class AgentTerminateResponseParser {

    private final static Logger log = LogManager.getLogger(AgentTerminateResponseParser.class);

    public AgentTerminateMessageBodyResponse parseResponse(final String response) {
        AgentTerminateMessageBodyResponse agentTerminateMessageBodyResponse = new AgentTerminateMessageBodyResponse();
        String messageHeader = extractAgentTerminateMessageText(response, 0, 130);
        AgentTerminateMessageHeader agentTerminateMessageHeader = buildAgentTerminateMessageHeader(messageHeader);

        if ("AGNTERO   ".equalsIgnoreCase(agentTerminateMessageHeader.getMSGID())) {
            log.info("AgentTerminateResponseParser::parseResponse::agentTerminateMessageHeader:::" + agentTerminateMessageHeader.toJson());
            log.info("AgentTerminateResponseParser::parseResponse::agentTerminateMessageHeader:::MSGLNG:::" + agentTerminateMessageHeader.getMSGLNG());
            String messageBody = extractAgentTerminateMessageText(response, 130, Integer.parseInt(
                    agentTerminateMessageHeader.getMSGLNG()) + 130);
            agentTerminateMessageBodyResponse = buildAgentSuccessMessageBody(messageBody);
            agentTerminateMessageBodyResponse.setState("Success");
            agentTerminateMessageBodyResponse.setMessage("Agent Modified Successfully.");

        } else if ("BOVERR    ".equalsIgnoreCase(agentTerminateMessageHeader.getMSGID())) {
            log.info("AgentTerminateResponseParser::parseResponse::agentTerminateMessageHeader:::" + agentTerminateMessageHeader.toJson());
            log.info("AgentTerminateResponseParser::parseResponse::agentTerminateMessageHeader:::MSGLNG:::" + agentTerminateMessageHeader.getMSGLNG());
            String messageBody = extractAgentTerminateMessageText(response, 130, Integer.parseInt(
                    agentTerminateMessageHeader.getMSGLNG()) + 130);
            agentTerminateMessageBodyResponse = buildAgentFailureMessageBody(messageBody);
            agentTerminateMessageBodyResponse.setState("Failure");

        } else {
            log.info("AgentTerminateResponseParser::parseResponse::agentTerminateMessageHeader:::" + agentTerminateMessageHeader.toJson());
            log.info("AgentTerminateResponseParser::parseResponse::agentTerminateMessageHeader:::MSGLNG:::" + agentTerminateMessageHeader.getMSGLNG());
            String messageBody = extractAgentTerminateMessageText(response, 130, Integer.parseInt(
                    agentTerminateMessageHeader.getMSGLNG()) + 130);
            agentTerminateMessageBodyResponse = buildAgentFailureMessageBody(messageBody);
            agentTerminateMessageBodyResponse.setState("Failure");
        }

        return agentTerminateMessageBodyResponse;
    }

    public AgentTerminateMessageHeader buildAgentTerminateMessageHeader(String messageHeader) {
        log.info("AgentTerminateResponseParser::buildAgentTerminateMessageHeader::messageHeader####" + messageHeader + "#######");
        AgentTerminateMessageHeader agentTerminateMessageHeader = new AgentTerminateMessageHeader();
        agentTerminateMessageHeader.setMSGID(extractAgentTerminateMessageText(messageHeader, 100, 110));
        agentTerminateMessageHeader.setMSGLNG(extractAgentTerminateMessageText(messageHeader, 110, 115));
        agentTerminateMessageHeader.setMSGCNT(extractAgentTerminateMessageText(messageHeader, 115, 120));
        agentTerminateMessageHeader.setFILLER(extractAgentTerminateMessageText(messageHeader, 120, 130));
        return agentTerminateMessageHeader;
    }

    public AgentTerminateMessageBodyResponse buildAgentSuccessMessageBody(String messageBody) {
        int startIndex = 0;
        AgentTerminateMessageBodyResponse agentTerminateMessageBodyResponse = new AgentTerminateMessageBodyResponse();
        agentTerminateMessageBodyResponse.setFiller(extractAgentTerminateMessageText(messageBody, startIndex + 0, startIndex + 1));
        return agentTerminateMessageBodyResponse;
    }

    public AgentTerminateMessageBodyResponse buildAgentFailureMessageBody(String messageBody) {
        AgentTerminateMessageBodyResponse agentTerminateMessageBodyResponse = new AgentTerminateMessageBodyResponse();
        agentTerminateMessageBodyResponse.setMessage(extractAgentTerminateMessageText(messageBody, 0, messageBody.length()).trim());
        return agentTerminateMessageBodyResponse;
    }

    public String extractAgentTerminateMessageText(final String response, int startIndex, int endIndex) {
        String subResponse = response.substring(startIndex, endIndex);
        return subResponse;
    }

}
