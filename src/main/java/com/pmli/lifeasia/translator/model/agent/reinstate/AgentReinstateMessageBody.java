package com.pmli.lifeasia.translator.model.agent.reinstate;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AgentReinstateMessageBody {

    private String ACTION="H";
    private String AGNTSEL="          ";
    private String DTETRM="99999999";
    private String PAYFLAG="N";
    private String TAGSUSIND=" ";
    /*
        C          Iss no Com    1     Issue but no Commission
        I          Iss not Al    1     Issue not Allowed
        X          Iss both      1     Issue no Commission & not Allo
    */
    private String ZAGNTSTS="LICE";
    private String STATCHANGEDATE=dateformatter();

    public AgentReinstateMessageBody(String AGNTSEL, String DTETRM) {
        this.AGNTSEL = formatStringLength(AGNTSEL,10);
        this.DTETRM = formatStringLength(formatString(DTETRM),8);
    }

    public String getACTION() {
        return ACTION;
    }

    public void setACTION(String ACTION) {
        this.ACTION = ACTION;
    }

    public String getAGNTSEL() {
        return AGNTSEL;
    }

    public void setAGNTSEL(String AGNTSEL) {
        this.AGNTSEL = formatStringLength(AGNTSEL,10);
    }

    public String getDTETRM() {
        return DTETRM;
    }

    public void setDTETRM(String DTETRM) {
        this.DTETRM = DTETRM;
    }

    public String getPAYFLAG() {
        return PAYFLAG;
    }

    public void setPAYFLAG(String PAYFLAG) {
        this.PAYFLAG = PAYFLAG;
    }

    public String getTAGSUSIND() {
        return TAGSUSIND;
    }

    public void setTAGSUSIND(String TAGSUSIND) {
        this.TAGSUSIND = TAGSUSIND;
    }

    public String getSTATCHANGEDATE() {
        return STATCHANGEDATE;
    }

    public void setSTATCHANGEDATE(String STATCHANGEDATE) {
        this.STATCHANGEDATE = STATCHANGEDATE;
    }

    public String getZAGNTSTS() {
        return ZAGNTSTS;
    }

    public void setZAGNTSTS(String ZAGNTSTS) {
        this.ZAGNTSTS = ZAGNTSTS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AgentReinstateMessageBody that = (AgentReinstateMessageBody) o;

        return new EqualsBuilder()
                .append(ACTION, that.ACTION)
                .append(AGNTSEL, that.AGNTSEL)
                .append(DTETRM, that.DTETRM)
                .append(PAYFLAG, that.PAYFLAG)
                .append(TAGSUSIND, that.TAGSUSIND)
                .append(ZAGNTSTS, that.ZAGNTSTS)
                .append(STATCHANGEDATE, that.STATCHANGEDATE)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(ACTION)
                .append(AGNTSEL)
                .append(DTETRM)
                .append(PAYFLAG)
                .append(TAGSUSIND)
                .append(ZAGNTSTS)
                .append(STATCHANGEDATE)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(ACTION)
                .append(AGNTSEL)
                .append(DTETRM)
                .append(PAYFLAG)
                .append(TAGSUSIND)
                .append(ZAGNTSTS)
                .append(STATCHANGEDATE)
                .toString();
    }

    public String toJson() {
        return "AgentTerminateMessageBody{" +
                "ACTION='" + ACTION + '\'' +
                ", AGNTSEL='" + AGNTSEL + '\'' +
                ", DTETRM='" + DTETRM + '\'' +
                ", PAYFLAG='" + PAYFLAG + '\'' +
                ", TAGSUSIND='" + TAGSUSIND + '\'' +
                ", ZAGNTSTS='" + ZAGNTSTS + '\'' +
                ", STATCHANGEDATE='" + STATCHANGEDATE + '\'' +
                '}';
    }

    public String dateformatter() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDateTime localDateTime = LocalDateTime.now();
        String date = dtf.format(localDateTime);
        return date;
    }

    private String formatStringLength(String string, int length) {
        return StringUtils.rightPad(string,length);
    }

    private String formatString(String message){
        return message.replace("-","");
    }
}
