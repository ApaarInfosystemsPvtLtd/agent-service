package com.pmli.lifeasia.translator.util;

import com.pmli.lifeasia.translator.model.agent.AgentModificationMessageBodyResponse;
import com.pmli.lifeasia.translator.model.agent.AgentModificationMessageHeader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class AgentModificationResponseParser
{

    private final static Logger log = LogManager.getLogger(AgentModificationResponseParser.class);

    public AgentModificationMessageBodyResponse parseResponse(final String response){
        AgentModificationMessageBodyResponse agentModificationMessage = new AgentModificationMessageBodyResponse();
        String messageHeader = extractAgentModificationMessageText(response, 0 , 130);
        AgentModificationMessageHeader agentModificationMessageHeader = buildAgentModifyMessageHeader(messageHeader);
        if ("AGNMODO   ".equalsIgnoreCase(agentModificationMessageHeader.getMSGID())) {
            log.info("AgentModificationResponseParser::parseResponse::agentModificationMessageHeader:::" + agentModificationMessageHeader.toJson());
            log.info("AgentModificationResponseParser::parseResponse::agentModificationMessageHeader:::MSGLNG:::" + agentModificationMessageHeader.getMSGLNG());
            String messageBody = extractAgentModificationMessageText(response, 130, Integer.parseInt(
                    agentModificationMessageHeader.getMSGLNG())+130);
            agentModificationMessage = buildAgentSuccessMessageBody(messageBody);
            agentModificationMessage.setState("Success");
            agentModificationMessage.setMessage("Agent Modified Successfully.");
        }
        else if("BOVERR    ".equalsIgnoreCase(agentModificationMessageHeader.getMSGID())){
            log.info("AgentModificationResponseParser::parseResponse::agentModificationMessageHeader:::" + agentModificationMessageHeader.toJson());
            log.info("AgentModificationResponseParser::parseResponse::agentModificationMessageHeader:::MSGLNG:::" + agentModificationMessageHeader.getMSGLNG());
            String messageBody = extractAgentModificationMessageText(response, 130, Integer.parseInt(
                    agentModificationMessageHeader.getMSGLNG())+130);
            agentModificationMessage = buildAgentFailureMessageBody(messageBody);
            agentModificationMessage.setState("Failure");
        }
        else{
            log.info("AgentModificationResponseParser::parseResponse::agentModificationMessageHeader:::" + agentModificationMessageHeader.toJson());
            log.info("AgentModificationResponseParser::parseResponse::agentModificationMessageHeader:::MSGLNG:::" + agentModificationMessageHeader.getMSGLNG());
            String messageBody = extractAgentModificationMessageText(response, 130, Integer.parseInt(
                    agentModificationMessageHeader.getMSGLNG())+130);
            agentModificationMessage = buildAgentFailureMessageBody(messageBody);
            agentModificationMessage.setState("Failure");
        }

        return agentModificationMessage;
    }

    public AgentModificationMessageHeader buildAgentModifyMessageHeader(String messageHeader) {
        log.info("AgentModificationResponseParser::buildAgentModifyMessageHeader::messageHeader####"+messageHeader+"#######");
        AgentModificationMessageHeader modificationMessageHeader = new AgentModificationMessageHeader();
        modificationMessageHeader.setMSGID(extractAgentModificationMessageText(messageHeader,100,110));
        modificationMessageHeader.setMSGLNG(extractAgentModificationMessageText(messageHeader,110,115));
        modificationMessageHeader.setMSGCNT(extractAgentModificationMessageText(messageHeader,115,120));
        modificationMessageHeader.setFILLER(extractAgentModificationMessageText(messageHeader,120,130));
        return modificationMessageHeader;
    }

    public AgentModificationMessageBodyResponse buildAgentSuccessMessageBody(String messageBody) {
        int startIndex = 0;
        AgentModificationMessageBodyResponse agentModificationMessageBodyResponse = new AgentModificationMessageBodyResponse();
        agentModificationMessageBodyResponse.setFiller(extractAgentModificationMessageText(messageBody, startIndex+0, startIndex+1));
        return agentModificationMessageBodyResponse;
    }

    public AgentModificationMessageBodyResponse buildAgentFailureMessageBody(String messageBody) {
        AgentModificationMessageBodyResponse agentModificationMessageBodyResponse = new AgentModificationMessageBodyResponse();
        agentModificationMessageBodyResponse.setMessage(extractAgentModificationMessageText(messageBody,0,messageBody.length()).trim());
        return agentModificationMessageBodyResponse;
    }

    public String extractAgentModificationMessageText(final String response, int startIndex, int endIndex) {
        String subResponse = response.substring(startIndex,endIndex);
        return subResponse;
    }

}
