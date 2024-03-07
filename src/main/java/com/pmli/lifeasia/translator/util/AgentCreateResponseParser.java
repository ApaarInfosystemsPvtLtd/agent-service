package com.pmli.lifeasia.translator.util;

import com.pmli.lifeasia.translator.model.agent.AgentCreateMessageBodyResponse;
import com.pmli.lifeasia.translator.model.agent.AgentCreateMessageHeader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class AgentCreateResponseParser {

    private final static Logger log = LogManager.getLogger(AgentCreateResponseParser.class);

    public AgentCreateMessageBodyResponse parseResponse(final String response){
        AgentCreateMessageBodyResponse agentCreateMessage = new AgentCreateMessageBodyResponse();
        String messageHeader = extractAgentCRTMessageText(response, 0 , 130);
        AgentCreateMessageHeader agentCreateMessageHeader = buildAgentCRTMessageHeader(messageHeader);
        if ("AGNCRTO   ".equalsIgnoreCase(agentCreateMessageHeader.getMSGID())) {
            log.info("AgentCreateResponseParser::parseResponse::agentCreateMessageHeader::{}",agentCreateMessageHeader.toJson());
            log.info("AgentCreateResponseParser::parseResponse::agentCreateMessageHeader:::MSGLNG::{}",agentCreateMessageHeader.getMSGLNG());
            String messageBody = extractAgentCRTMessageText(response, 130, Integer.parseInt(
                    agentCreateMessageHeader.getMSGLNG())+130);
            agentCreateMessage=buildAgentSuccessMessageBody(messageBody);
            agentCreateMessage.setState("Success");
            agentCreateMessage.setMessage("Agent Created Successfully.");
            //agentCRTMessageList = buildAgentMessageBody(messageBody);
        }
        else if("BOVERR    ".equalsIgnoreCase(agentCreateMessageHeader.getMSGID())) {
            log.info("AgentCreateResponseParser::parseResponse::agentCreateMessageHeader::{}",agentCreateMessageHeader.toJson());
            log.info("AgentCreateResponseParser::parseResponse::agentCreateMessageHeader:::MSGLNG::{}",agentCreateMessageHeader.getMSGLNG());
            String messageBody = extractAgentCRTMessageText(response, 130, Integer.parseInt(
                    agentCreateMessageHeader.getMSGLNG())+130);
            agentCreateMessage = buildAgentFailureMessageBody(messageBody);
            agentCreateMessage.setState("Failure");
        }
        else {
            log.info("AgentCreateResponseParser::parseResponse::agentCreateMessageHeader::{}",agentCreateMessageHeader.toJson());
            log.info("AgentCreateResponseParser::parseResponse::agentCreateMessageHeader:::MSGLNG::{}",agentCreateMessageHeader.getMSGLNG());
            String messageBody = extractAgentCRTMessageText(response, 130, Integer.parseInt(
                    agentCreateMessageHeader.getMSGLNG())+130);
            agentCreateMessage = buildAgentFailureMessageBody(messageBody);
            agentCreateMessage.setState("Failure");
        }
        return agentCreateMessage;
    }

    public AgentCreateMessageHeader buildAgentCRTMessageHeader(String messageHeader) {
        log.info("AgentCreateResponseParser::messageHeader####"+messageHeader+"#######");
        AgentCreateMessageHeader agentCreateMessageHeader = new AgentCreateMessageHeader();
        agentCreateMessageHeader.setMSGID(extractAgentCRTMessageText(messageHeader,100,110));
        agentCreateMessageHeader.setMSGLNG(extractAgentCRTMessageText(messageHeader,110,115));
        agentCreateMessageHeader.setMSGCNT(extractAgentCRTMessageText(messageHeader,115,120));
        agentCreateMessageHeader.setFILLER(extractAgentCRTMessageText(messageHeader,120,130));
        return agentCreateMessageHeader;
    }

    private AgentCreateMessageBodyResponse buildAgentSuccessMessageBody(String messageBody) {
        int startIndex = 0;
        AgentCreateMessageBodyResponse agentCreateMessageBodyResponse = new AgentCreateMessageBodyResponse();
        agentCreateMessageBodyResponse.setagnum(extractAgentCRTMessageText(messageBody,
                startIndex+0, startIndex+8));
        return agentCreateMessageBodyResponse;
    }

    private AgentCreateMessageBodyResponse buildAgentFailureMessageBody(String messageBody){
        AgentCreateMessageBodyResponse agentCreateMessageBodyResponse = new AgentCreateMessageBodyResponse();
        agentCreateMessageBodyResponse.setagnum("");
        agentCreateMessageBodyResponse.setMessage(extractAgentCRTMessageText(messageBody,0,messageBody.length()).trim());
        return  agentCreateMessageBodyResponse;
    }

    public String extractAgentCRTMessageText(final String response, int startIndex, int endIndex) {
        String subResponse = response.substring(startIndex,endIndex);
        return subResponse;
    }

}
