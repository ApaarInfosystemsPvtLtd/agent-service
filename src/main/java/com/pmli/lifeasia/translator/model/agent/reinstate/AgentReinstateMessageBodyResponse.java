package com.pmli.lifeasia.translator.model.agent.reinstate;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class AgentReinstateMessageBodyResponse {
    private String filler=" ";
    private String state="";
    private String message="";
    public String getFiller() {
        return filler;
    }

    public void setFiller(String filler) {
        this.filler = filler;
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

        AgentReinstateMessageBodyResponse that = (AgentReinstateMessageBodyResponse) o;

        return new EqualsBuilder()
                .append(filler, that.filler)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(filler)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "AgentTerminateMessageBodyResponse{" +
                "filler='" + filler + '\'' +
                ", message='" + message + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
