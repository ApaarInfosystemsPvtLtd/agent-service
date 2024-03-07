package com.pmli.lifeasia.translator.model.agent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AgentCreateResponse")
public class AgentCreateResponseDTO {

    private String clientnum="        ";
    private String agentnum="        ";
    private String state="";
    private String message="";

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

    public void setMessage(String error) {
        message = error;

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

        AgentCreateResponseDTO that = (AgentCreateResponseDTO) o;

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
        return "AgentCreateResponseDTO{" +
                "clientnum='" + clientnum + '\'' +
                ", agentnum='" + agentnum + '\'' +
                ", status='" + state + '\'' +
                ", Message='" + message + '\'' +
                '}';
    }
}
