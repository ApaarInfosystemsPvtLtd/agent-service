package com.pmli.lifeasia.translator.model.agent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class AgentModificationMessageBodyResponse {

    private String filler=" ";
    private String state="";
    private String message="";

    public String getFiller() {
        return filler;
    }

    public void setFiller(String filler) {
        this.filler = filler;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AgentModificationMessageBodyResponse that = (AgentModificationMessageBodyResponse) o;

        return new EqualsBuilder()
                .append(getFiller(), that.getFiller())
                .append(getState(),that.getState())
                .append(getMessage(),that.getMessage())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getFiller())
                .append(getState())
                .append(getMessage())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "AgentModificationMessageBodyResponse{" +
                "filler='" + filler + '\'' +
                ", state='" + state + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
