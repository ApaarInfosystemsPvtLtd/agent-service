package com.pmli.lifeasia.translator.model.client;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class ClientCRPMessageHeader
{
    private String MSGID="CLN2PERI  ";  // 10 Character
    private String MSGLNG="02600";      // 05 Character
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

        ClientCRPMessageHeader that = (ClientCRPMessageHeader) o;

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
        return "ClientCreateMessageHeader{" +
                "MSGID='" + MSGID + '\'' +
                ", MSGLNG='" + MSGLNG + '\'' +
                ", MSGCNT='" + MSGCNT + '\'' +
                ", FILLER='" + FILLER + '\'' +
                '}';
    }
}
