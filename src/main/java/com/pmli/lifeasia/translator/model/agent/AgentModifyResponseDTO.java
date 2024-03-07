package com.pmli.lifeasia.translator.model.agent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class AgentModifyResponseDTO
{

    private String clientnum="        ";
    private String agentnum="        ";
    private String state="";
    private String message ="";

    public String getClientnum() {
        return clientnum;
    }

    public void setClientnum(String clientnum) {
        this.clientnum = clientnum;
    }

    public String getAgentnum() {
        return agentnum;
    }

    public void setAgentnum(String agentnum) {
        this.agentnum = agentnum;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AgentModifyResponseDTO that = (AgentModifyResponseDTO) o;

        return new EqualsBuilder()
                .append(getClientnum(), that.getClientnum())
                .append(getAgentnum(),that.getAgentnum())
                .append(getState(),that.getState())
                .append(getMessage(),that.getMessage())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getClientnum())
                .append(getAgentnum())
                .append(getState())
                .append(getMessage())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "AgentModifyResponseDTO{" +
                "clientnum='" + clientnum + '\'' +
                ", agentnum='" + agentnum + '\'' +
                ", status='" + state + '\'' +
                ", Message='" + message + '\'' +
                '}';
    }
}
