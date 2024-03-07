package com.pmli.lifeasia.translator.util;

import com.pmli.lifeasia.translator.model.agent.reinstate.AgentReinstateMessageBodyResponse;
import com.pmli.lifeasia.translator.model.agent.reinstate.AgentReinstateMessageHeader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class AgentReinstateResponseParser {

    private final static Logger log = LogManager.getLogger(AgentReinstateResponseParser.class);

    public AgentReinstateMessageBodyResponse parseResponse(final String response) {
        AgentReinstateMessageBodyResponse agentReinstateMessageBodyResponse = new AgentReinstateMessageBodyResponse();
        String messageHeader = extractAgentReinstateMessageText(response, 0, 130);
        AgentReinstateMessageHeader agentReinstateMessageHeader = buildAgentReinstateMessageHeader(messageHeader);

        if ("AGNRTAO   ".equalsIgnoreCase(agentReinstateMessageHeader.getMSGID())) {
            log.info("AgentReinstateResponseParser::parseResponse::agentReinstateMessageHeader:::" + agentReinstateMessageHeader.toJson());
            log.info("AgentReinstateResponseParser::parseResponse::agentReinstateMessageHeader:::MSGLNG:::" + agentReinstateMessageHeader.getMSGLNG());
            String messageBody = extractAgentReinstateMessageText(response, 130, Integer.parseInt(
                    agentReinstateMessageHeader.getMSGLNG()) + 130);
            agentReinstateMessageBodyResponse = buildAgentSuccessMessageBody(messageBody);
            agentReinstateMessageBodyResponse.setState("Success");
            agentReinstateMessageBodyResponse.setMessage("Agent Modified Successfully.");

        } else if ("BOVERR    ".equalsIgnoreCase(agentReinstateMessageHeader.getMSGID())) {
            log.info("AgentReinstateResponseParser::parseResponse::agentReinstateMessageHeader:::" + agentReinstateMessageHeader.toJson());
            log.info("AgentReinstateResponseParser::parseResponse::agentReinstateMessageHeader:::MSGLNG:::" + agentReinstateMessageHeader.getMSGLNG());
            String messageBody = extractAgentReinstateMessageText(response, 130, Integer.parseInt(
                    agentReinstateMessageHeader.getMSGLNG()) + 130);
            agentReinstateMessageBodyResponse = buildAgentFailureMessageBody(messageBody);
            agentReinstateMessageBodyResponse.setState("Failure");

        } else {
            log.info("AgentReinstateResponseParser::parseResponse::agentReinstateMessageHeader:::" + agentReinstateMessageHeader.toJson());
            log.info("AgentReinstateResponseParser::parseResponse::agentReinstateMessageHeader:::MSGLNG:::" + agentReinstateMessageHeader.getMSGLNG());
            String messageBody = extractAgentReinstateMessageText(response, 130, Integer.parseInt(
                    agentReinstateMessageHeader.getMSGLNG()) + 130);
            agentReinstateMessageBodyResponse = buildAgentFailureMessageBody(messageBody);
            agentReinstateMessageBodyResponse.setState("Failure");
        }

        return agentReinstateMessageBodyResponse;
    }

    public AgentReinstateMessageHeader buildAgentReinstateMessageHeader(String messageHeader) {
        log.info("AgentReinstateResponseParser::buildAgentReinstateMessageHeader::messageHeader####" + messageHeader + "#######");
        AgentReinstateMessageHeader agentReinstateMessageHeader = new AgentReinstateMessageHeader();
        agentReinstateMessageHeader.setMSGID(extractAgentReinstateMessageText(messageHeader, 100, 110));
        agentReinstateMessageHeader.setMSGLNG(extractAgentReinstateMessageText(messageHeader, 110, 115));
        agentReinstateMessageHeader.setMSGCNT(extractAgentReinstateMessageText(messageHeader, 115, 120));
        agentReinstateMessageHeader.setFILLER(extractAgentReinstateMessageText(messageHeader, 120, 130));
        return agentReinstateMessageHeader;
    }

    public AgentReinstateMessageBodyResponse buildAgentSuccessMessageBody(String messageBody) {
        int startIndex = 0;
        AgentReinstateMessageBodyResponse agentReinstateMessageBodyResponse = new AgentReinstateMessageBodyResponse();
        agentReinstateMessageBodyResponse.setFiller(extractAgentReinstateMessageText(messageBody, startIndex + 0, startIndex + 1));
        return agentReinstateMessageBodyResponse;
    }

    public AgentReinstateMessageBodyResponse buildAgentFailureMessageBody(String messageBody) {
        AgentReinstateMessageBodyResponse agentReinstateMessageBodyResponse = new AgentReinstateMessageBodyResponse();
        agentReinstateMessageBodyResponse.setMessage(extractAgentReinstateMessageText(messageBody, 0, messageBody.length()).trim());
        return agentReinstateMessageBodyResponse;
    }

    public String extractAgentReinstateMessageText(final String response, int startIndex, int endIndex) {
        String subResponse = response.substring(startIndex, endIndex);
        return subResponse;
    }

}
