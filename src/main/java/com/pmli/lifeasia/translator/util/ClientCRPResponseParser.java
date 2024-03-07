package com.pmli.lifeasia.translator.util;

import com.google.gson.Gson;
import com.pmli.lifeasia.translator.model.client.ClientCRPMessageBodyResponse;
import com.pmli.lifeasia.translator.model.client.ClientCRPMessageHeader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ClientCRPResponseParser
{
    private final static Logger log = LogManager.getLogger(ClientCRPResponseParser.class);
    public ClientCRPMessageBodyResponse parseResponse(final String response){
        ClientCRPMessageBodyResponse clientCRPMessage = new ClientCRPMessageBodyResponse();
        String messageHeader = extractClientCRPMessageText(response, 0 , 130);
        ClientCRPMessageHeader clientCRPMessageHeader = buildClientCRPMessageHeader(messageHeader);
        if ("CLNPERO   ".equalsIgnoreCase(clientCRPMessageHeader.getMSGID())) {
            log.info("ClientCRPResponseParser::parseResponse::ClientCreateMessageHeader::{}",new Gson().toJson(clientCRPMessageHeader));
            log.info("ClientCRPResponseParser::parseResponse::ClientCreateMessageHeader:::MSGLNG::{}",clientCRPMessageHeader.getMSGLNG());
            String messageBody = extractClientCRPMessageText(response, 130, Integer.parseInt(
                    clientCRPMessageHeader.getMSGLNG())+130);
            clientCRPMessage = buildClientSuccessMessageBody(messageBody);
            clientCRPMessage.setState("Success");
            clientCRPMessage.setMessage("Client created Successfully.");
            log.info("ClientCRPResponseParser::parseResponse::ClientCRPMessageBodyResponse::{}",new Gson().toJson(clientCRPMessage));
        }
        else if("BOVERR    ".equalsIgnoreCase(clientCRPMessageHeader.getMSGID())){
            log.error("ClientCRPResponseParser::parseResponse::ClientCreateMessageHeader::{}",new Gson().toJson(clientCRPMessageHeader));
            log.error("ClientCRPResponseParser::parseResponse::ClientCreateMessageHeader:::MSGLNG::{}",clientCRPMessageHeader.getMSGLNG());
            String messageBody = extractClientCRPMessageText(response, 130, Integer.parseInt(
                    clientCRPMessageHeader.getMSGLNG())+130);
            clientCRPMessage = buildClientFailureBody(messageBody);
            clientCRPMessage.setState("Failure");
            log.error("ClientCRPResponseParser::parseResponse::ClientCRPMessageBodyResponse::{}",new Gson().toJson(clientCRPMessage));
        }
        else{
            log.error("ClientCRPResponseParser::parseResponse::ClientCreateMessageHeader::{}",new Gson().toJson(clientCRPMessageHeader));
            log.error("ClientCRPResponseParser::parseResponse::ClientCreateMessageHeader:::MSGLNG::{}",clientCRPMessageHeader.getMSGLNG());
            String messageBody = extractClientCRPMessageText(response, 130, Integer.parseInt(
                    clientCRPMessageHeader.getMSGLNG())+130);
            clientCRPMessage = buildClientFailureBody(messageBody);
            clientCRPMessage.setState("Failure");
            log.error("ClientCRPResponseParser::parseResponse::ClientCRPMessageBodyResponse::{}",new Gson().toJson(clientCRPMessage));
        }
        return clientCRPMessage;
    }

    public ClientCRPMessageHeader buildClientCRPMessageHeader(String messageHeader) {
        log.info("ClientCRPResponseParser::buildClientCRPMessageHeader::messageHeader####::{}::#######",messageHeader);
        ClientCRPMessageHeader clientCreateMessageHeader = new ClientCRPMessageHeader();
        clientCreateMessageHeader.setMSGID(extractClientCRPMessageText(messageHeader,100,110));
        clientCreateMessageHeader.setMSGLNG(extractClientCRPMessageText(messageHeader,110,115));
        clientCreateMessageHeader.setMSGCNT(extractClientCRPMessageText(messageHeader,115,120));
        clientCreateMessageHeader.setFILLER(extractClientCRPMessageText(messageHeader,120,130));
        return clientCreateMessageHeader;
    }

    public ClientCRPMessageBodyResponse buildClientSuccessMessageBody(String messageBody) {
         int startIndex = 0;
            ClientCRPMessageBodyResponse clientCRPMessageBodyResponse = new ClientCRPMessageBodyResponse();
            clientCRPMessageBodyResponse.setclntnum(extractClientCRPMessageText(messageBody, startIndex + 0, startIndex + 8));
            clientCRPMessageBodyResponse.setcltstat(extractClientCRPMessageText(messageBody,startIndex + 8,startIndex + 10));
        return clientCRPMessageBodyResponse;
    }
    public ClientCRPMessageBodyResponse buildClientFailureBody(String messageBody){
        ClientCRPMessageBodyResponse clientCRPMessageBodyResponse = new ClientCRPMessageBodyResponse();
        clientCRPMessageBodyResponse.setclntnum("");
        clientCRPMessageBodyResponse.setMessage(extractClientCRPMessageText(messageBody,0,messageBody.length()).trim());
        return clientCRPMessageBodyResponse;
    }

    public String extractClientCRPMessageText(final String response, int startIndex, int endIndex) {
        String subResponse = response.substring(startIndex,endIndex);
        return subResponse;
    }

}
