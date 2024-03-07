package com.pmli.lifeasia.translator.model.agent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class AgentCreateMessageBodyResponse
{
    private String agnum="        ";
    private String state="";
    private String message="";

    public String getagnum() {
        return agnum;
    }

    public void setagnum(String agnum) {
        this.agnum = agnum;
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

        AgentCreateMessageBodyResponse that = (AgentCreateMessageBodyResponse) o;

        return new EqualsBuilder()
                .append(getagnum(), that.getagnum())
                .append(getState(),that.getState())
                .append(getMessage(),that.getMessage())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getagnum())
                .append(getState())
                .append(getMessage())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "AgentCreateMessageBodyResponse{" +
                "agnum='" + agnum + '\'' +
                ", state='" + state + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
