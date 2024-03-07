package com.pmli.lifeasia.translator.model.agent.reinstate;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class AgentReinstateMessageHeader
{
    private String MSGID="AGNRTAI   ";  // 10 Character
    private String MSGLNG="00391";      // 05 Character
    private String MSGCNT="00001";      // 05 Character
    private String FILLER="          "; // 10 Character

    public String getMSGID() {
        return MSGID;
    }

    public void setMSGID(String MSGID) {
        this.MSGID = MSGID;
    }

    public String getMSGLNG() {
        return MSGLNG;
    }

    public void setMSGLNG(String MSGLNG) {
        this.MSGLNG = MSGLNG;
    }

    public String getMSGCNT() {
        return MSGCNT;
    }

    public void setMSGCNT(String MSGCNT) {
        this.MSGCNT = MSGCNT;
    }

    public String getFILLER() {
        return FILLER;
    }

    public void setFILLER(String FILLER) {
        this.FILLER = FILLER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AgentReinstateMessageHeader that = (AgentReinstateMessageHeader) o;

        return new EqualsBuilder()
                .append(getMSGID(), that.getMSGID())
                .append(getMSGLNG(), that.getMSGLNG())
                .append(getMSGCNT(), that.getMSGCNT())
                .append(getFILLER(), that.getFILLER())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getMSGID())
                .append(getMSGLNG())
                .append(getMSGCNT())
                .append(getFILLER())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(getMSGID())
                .append(getMSGLNG())
                .append(getMSGCNT())
                .append(getFILLER())
                .toString();
    }

    public String toJson() {
        return "AgentCreateMessageHeader{" +
                "MSGID='" + MSGID + '\'' +
                ", MSGLNG='" + MSGLNG + '\'' +
                ", MSGCNT='" + MSGCNT + '\'' +
                ", FILLER='" + FILLER + '\'' +
                '}';
    }
}
