package com.pmli.lifeasia.translator.model;

import com.pmli.lifeasia.translator.Exception.agent.AgentFailure;
import com.pmli.lifeasia.translator.Exception.agent.AgentSuccess;
import com.pmli.lifeasia.translator.Exception.client.ClientFailure;
import com.pmli.lifeasia.translator.Exception.client.ClientSuccess;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "DMS_State")
public class DmsState {

    private LocalDateTime entryTimeStamp;
    private String request;
    private String process;
    private String agentCode;
    ClientSuccess clientSuccess;
    ClientFailure clientFailure;
    AgentSuccess agentSuccess;
    AgentFailure agentFailure;
    private String response;
    private String status;
    private LocalDateTime exitTimeStamp;

    public LocalDateTime getEntryTimeStamp() {
        return entryTimeStamp;
    }

    public void setEntryTimeStamp(LocalDateTime entryTimeStamp) {
        this.entryTimeStamp = entryTimeStamp;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public ClientSuccess getClientSuccess() {
        return clientSuccess;
    }

    public void setClientSuccess(ClientSuccess clientSuccess) {
        this.clientSuccess = clientSuccess;
    }

    public ClientFailure getClientFailure() {
        return clientFailure;
    }

    public void setClientFailure(ClientFailure clientFailure) {
        this.clientFailure = clientFailure;
    }

    public AgentSuccess getAgentSuccess() {
        return agentSuccess;
    }

    public void setAgentSuccess(AgentSuccess agentSuccess) {
        this.agentSuccess = agentSuccess;
    }

    public AgentFailure getAgentFailure() {
        return agentFailure;
    }

    public void setAgentFailure(AgentFailure agentFailure) {
        this.agentFailure = agentFailure;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getExitTimeStamp() {
        return exitTimeStamp;
    }

    public void setExitTimeStamp(LocalDateTime exitTimeStamp) {
        this.exitTimeStamp = exitTimeStamp;
    }
}
