package com.pmli.lifeasia.translator.Exception.runtime;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class CustomErrorResponse
{
    private String clientnum="";
    private String agentNum="";
    private String state="";
    private String message="";

    public CustomErrorResponse() {
    }

    public String getClientnum() {
        return clientnum;
    }

    public void setClientnum(String clientnum) {
        this.clientnum = clientnum;
    }

    public String getAgentNum() {
        return agentNum;
    }

    public void setAgentNum(String agentNum) {
        this.agentNum = agentNum;
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

        if (!(o instanceof CustomErrorResponse)) return false;

        CustomErrorResponse that = (CustomErrorResponse) o;

        return new EqualsBuilder()
                .append(getClientnum(), that.getClientnum())
                .append(getAgentNum(), that.getAgentNum())
                .append(getState(), that.getState())
                .append(getMessage(), that.getMessage())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getClientnum())
                .append(getAgentNum())
                .append(getState())
                .append(getMessage())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "CustomErrorResponse{" +
                "clientnum='" + clientnum + '\'' +
                ", agentNum='" + agentNum + '\'' +
                ", state='" + state + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
