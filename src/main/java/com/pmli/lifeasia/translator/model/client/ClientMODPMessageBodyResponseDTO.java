package com.pmli.lifeasia.translator.model.client;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class ClientMODPMessageBodyResponseDTO
{
    private String 	clntnum="        ";
    private String 	cltstat="  ";
    private String  pepflag=" ";
    private String  pepdate="        ";
    private String  state="";
    private String  message="";

    public String getClntnum() {
        return clntnum;
    }

    public void setClntnum(String clntnum) {
        this.clntnum = clntnum;
    }

    public String getCltstat() {
        return cltstat;
    }

    public void setCltstat(String cltstat) {
        this.cltstat = cltstat;
    }

    public String getPepflag() {
        return pepflag;
    }

    public void setPepflag(String pepflag) {
        this.pepflag = pepflag;
    }

    public String getPepdate() {
        return pepdate;
    }

    public void setPepdate(String pepdate) {
        this.pepdate = pepdate;
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

        ClientMODPMessageBodyResponseDTO that = (ClientMODPMessageBodyResponseDTO) o;

        return new EqualsBuilder()
                .append(getClntnum(),that.getClntnum())
                .append(getCltstat(),that.getCltstat())
                .append(getPepflag(),that.getPepflag())
                .append(getPepdate(),that.getPepdate())
                .append(getState(),that.getState())
                .append(getMessage(),that.getMessage())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getClntnum())
                .append(getCltstat())
                .append(getPepflag())
                .append(getPepdate())
                .append(getState())
                .append(getMessage())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "ClientMODPMessageBodyResponseDTO{" +
                "clntnum='" + clntnum + '\'' +
                ", cltstat='" + cltstat + '\'' +
                ", pepflag='" + pepflag + '\'' +
                ", pepdate='" + pepdate + '\'' +
                ", Client_state='" + state + '\'' +
                ", Client_Error_message='" + message + '\'' +
                '}';
    }
}
