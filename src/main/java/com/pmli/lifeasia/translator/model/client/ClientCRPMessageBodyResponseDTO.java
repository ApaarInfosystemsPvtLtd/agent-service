package com.pmli.lifeasia.translator.model.client;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class ClientCRPMessageBodyResponseDTO
{

    private String 	clntnum="        ";
    private String 	cltstat="  ";
    private String  state="";
    private String  message="";


    public String getclntnum() {
        return clntnum;
    }

    public void setclntnum(String clntnum) {
        this.clntnum = clntnum;
    }

    public String getcltstat() {
        return cltstat;
    }

    public void setcltstat(String cltstat) {
        this.cltstat = cltstat;
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

        ClientCRPMessageBodyResponseDTO that = (ClientCRPMessageBodyResponseDTO) o;

        return new EqualsBuilder()
                .append(getclntnum(),that.getclntnum())
                .append(getcltstat(),that.getcltstat())
                .append(getState(),that.getState())
                .append(getMessage(),that.getMessage())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getclntnum())
                .append(getcltstat())
                .append(getState())
                .append(getMessage())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "ClientCRPMessageBodyResponseDTO{" +
                "clntnum='" + clntnum + '\'' +
                ", cltstat='" + cltstat + '\'' +
                ", Client_state='" + state + '\'' +
                ", Error_message='" + message + '\'' +
                '}';
    }
}
