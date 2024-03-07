package com.pmli.lifeasia.translator.util;

import com.pmli.lifeasia.translator.model.client.ClientMODPMessageBodyResponse;
import com.pmli.lifeasia.translator.model.client.ClientMODPMessageHeader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ClientMODPResponseParser
{
    private final static Logger log = LogManager.getLogger(ClientMODPResponseParser.class);

    public ClientMODPMessageBodyResponse parseResponse(final String response){
        ClientMODPMessageBodyResponse clientMODPMessage = new ClientMODPMessageBodyResponse();
        String messageHeader = extractClientMODPMessageText(response, 0 , 130);
        ClientMODPMessageHeader clientMODPMessageHeader = buildClientMODPMessageHeader(messageHeader);
        if ("CLNMODPO  ".equalsIgnoreCase(clientMODPMessageHeader.getMSGID())) {
            log.info("ClientMODPResponseParser::parseResponse::ClientCreateMessageHeader::" + clientMODPMessageHeader.toJson());
            log.info("ClientMODPResponseParser::parseResponse::ClientCreateMessageHeader::MSGLNG::" + clientMODPMessageHeader.getMSGLNG());
            String messageBody = extractClientMODPMessageText(response, 130, Integer.parseInt(
                    clientMODPMessageHeader.getMSGLNG())+130);
            clientMODPMessage = buildClientSuccessMessageBody(messageBody);
            clientMODPMessage.setState("Success");
            clientMODPMessage.setMessage("Client modified successfully.");
        }
        else if ("BOVERR    ".equalsIgnoreCase(clientMODPMessageHeader.getMSGID())){
            log.info("ClientMODPResponseParser::parseResponse::ClientCreateMessageHeader::" + clientMODPMessageHeader.toJson());
            log.info("ClientMODPResponseParser::parseResponse::ClientCreateMessageHeader::MSGLNG::" + clientMODPMessageHeader.getMSGLNG());
            String messageBody = extractClientMODPMessageText(response, 130, Integer.parseInt(
                    clientMODPMessageHeader.getMSGLNG())+130);
            clientMODPMessage = buildClientFailureMessageBody(messageBody);
            clientMODPMessage.setState("Failure");
        }
        else{
            log.info("ClientMODPResponseParser::parseResponse::ClientCreateMessageHeader::" + clientMODPMessageHeader.toJson());
            log.info("ClientMODPResponseParser::parseResponse::ClientCreateMessageHeader::MSGLNG::" + clientMODPMessageHeader.getMSGLNG());
            String messageBody = extractClientMODPMessageText(response, 130, Integer.parseInt(
                    clientMODPMessageHeader.getMSGLNG())+130);
            clientMODPMessage = buildClientFailureMessageBody(messageBody);
            clientMODPMessage.setState("Failure");
        }
        return clientMODPMessage;
    }

    public ClientMODPMessageHeader buildClientMODPMessageHeader(String messageHeader) {
        log.info("ClientMODPResponseParser::buildClientMODPMessageHeader::messageHeader####"+messageHeader+"#######");
        ClientMODPMessageHeader clientMODPMessageHeader = new ClientMODPMessageHeader();
        clientMODPMessageHeader.setMSGID(extractClientMODPMessageText(messageHeader,100,110));
        clientMODPMessageHeader.setMSGLNG(extractClientMODPMessageText(messageHeader,110,115));
        clientMODPMessageHeader.setMSGCNT(extractClientMODPMessageText(messageHeader,115,120));
        clientMODPMessageHeader.setFILLER(extractClientMODPMessageText(messageHeader,120,130));
        return clientMODPMessageHeader;
    }

    public ClientMODPMessageBodyResponse buildClientSuccessMessageBody(String messageBody) {

        int startIndex = 0;
        ClientMODPMessageBodyResponse clientMODPMessageBodyResponse = new ClientMODPMessageBodyResponse();
        clientMODPMessageBodyResponse.setClntnum(extractClientMODPMessageText(messageBody, startIndex + 0, startIndex + 8));
        clientMODPMessageBodyResponse.setCltstat(extractClientMODPMessageText(messageBody,startIndex + 8,startIndex + 10));
        clientMODPMessageBodyResponse.setPepflag(extractClientMODPMessageText(messageBody,startIndex + 10,startIndex + 11));
        clientMODPMessageBodyResponse.setPepdate(extractClientMODPMessageText(messageBody,startIndex + 11,startIndex + 19));

        return clientMODPMessageBodyResponse;
    }

    public ClientMODPMessageBodyResponse buildClientFailureMessageBody(String messageBody){
        ClientMODPMessageBodyResponse clientMODPMessageBodyResponse= new ClientMODPMessageBodyResponse();
        clientMODPMessageBodyResponse.setClntnum("");
        clientMODPMessageBodyResponse.setMessage(extractClientMODPMessageText(messageBody,0,messageBody.length()).trim());
        return clientMODPMessageBodyResponse;
    }


    public String extractClientMODPMessageText(final String response, int startIndex, int endIndex) {
        String subResponse = response.substring(startIndex,endIndex);
        return subResponse;
    }

}
