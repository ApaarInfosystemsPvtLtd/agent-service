package com.pmli.lifeasia.translator.model.agent.reinstate;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class AgentReinstateLeaderHeader
{
    private String 	MSGREFNO	=   "        ";   // 08 Character
    private String 	USRPRF	    =	"          "; // 10 Character
    private String 	WKSID	    =	"QPADEV002G"; // 10 Character
    private String 	OBJID	    =	"AGN       "; // 10 Character
    private String 	VRBID	    =	"RTA       "; // 10 Character
    private String 	TOTMSGLNG	=	"00700";      // 05 Character
    private String 	OPMODE	    =	"1";          // 01 Character
    private String 	CMTCONTROL	=	"Y";          // 01 Character
    private String 	RSPMODE	    =	"I";          // 01 Character
    private String 	MSGINDENT	=	"R";          // 01 Character
    private String 	MOREIND	    =	"N";          // 01 Character
    private String 	ERRLVL	    =	"0";          // 01 Character
    private String 	IGNOREDRIVERHELD= " ";        // 01 Character
    private String 	SUPPRESSRCLRSC	= " ";        // 01 Character
    private String 	FILLER	        = "                                       ";  // 39 Character

    public String getMSGREFNO() {
        return MSGREFNO;
    }

    public void setMSGREFNO(String MSGREFNO) {
        this.MSGREFNO = MSGREFNO;
    }

    public String getUSRPRF() {
        return USRPRF;
    }

    public void setUSRPRF(String USRPRF) {
        this.USRPRF = formatStringLengthPadRight(USRPRF,10);
    }

    public String getWKSID() {
        return WKSID;
    }

    public void setWKSID(String WKSID) {
        this.WKSID = WKSID;
    }

    public String getOBJID() {
        return OBJID;
    }

    public void setOBJID(String OBJID) {
        this.OBJID = OBJID;
    }

    public String getVRBID() {
        return VRBID;
    }

    public void setVRBID(String VRBID) {
        this.VRBID = VRBID;
    }

    public String getTOTMSGLNG() {
        return TOTMSGLNG;
    }

    public void setTOTMSGLNG(String TOTMSGLNG) {
        this.TOTMSGLNG = TOTMSGLNG;
    }

    public String getOPMODE() {
        return OPMODE;
    }

    public void setOPMODE(String OPMODE) {
        this.OPMODE = OPMODE;
    }

    public String getCMTCONTROL() {
        return CMTCONTROL;
    }

    public void setCMTCONTROL(String CMTCONTROL) {
        this.CMTCONTROL = CMTCONTROL;
    }

    public String getRSPMODE() {
        return RSPMODE;
    }

    public void setRSPMODE(String RSPMODE) {
        this.RSPMODE = RSPMODE;
    }

    public String getMSGINDENT() {
        return MSGINDENT;
    }

    public void setMSGINDENT(String MSGINDENT) {
        this.MSGINDENT = MSGINDENT;
    }

    public String getMOREIND() {
        return MOREIND;
    }

    public void setMOREIND(String MOREIND) {
        this.MOREIND = MOREIND;
    }

    public String getERRLVL() {
        return ERRLVL;
    }

    public void setERRLVL(String ERRLVL) {
        this.ERRLVL = ERRLVL;
    }

    public String getIGNOREDRIVERHELD() {
        return IGNOREDRIVERHELD;
    }

    public void setIGNOREDRIVERHELD(String IGNOREDRIVERHELD) {
        this.IGNOREDRIVERHELD = IGNOREDRIVERHELD;
    }

    public String getSUPPRESSRCLRSC() {
        return SUPPRESSRCLRSC;
    }

    public void setSUPPRESSRCLRSC(String SUPPRESSRCLRSC) {
        this.SUPPRESSRCLRSC = SUPPRESSRCLRSC;
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

        AgentReinstateLeaderHeader that = (AgentReinstateLeaderHeader) o;

        return new EqualsBuilder()
                .append(getMSGREFNO(), that.getMSGREFNO())
                .append(getUSRPRF(), that.getUSRPRF())
                .append(getWKSID(), that.getWKSID())
                .append(getOBJID(), that.getOBJID())
                .append(getVRBID(), that.getVRBID())
                .append(getTOTMSGLNG(), that.getTOTMSGLNG())
                .append(getOPMODE(), that.getOPMODE())
                .append(getCMTCONTROL(), that.getCMTCONTROL())
                .append(getRSPMODE(), that.getRSPMODE())
                .append(getMSGINDENT(), that.getMSGINDENT())
                .append(getMOREIND(), that.getMOREIND())
                .append(getERRLVL(), that.getERRLVL())
                .append(getIGNOREDRIVERHELD(), that.getIGNOREDRIVERHELD())
                .append(getSUPPRESSRCLRSC(), that.getSUPPRESSRCLRSC())
                .append(getFILLER(), that.getFILLER())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getMSGREFNO())
                .append(getUSRPRF())
                .append(getWKSID())
                .append(getOBJID())
                .append(getVRBID())
                .append(getTOTMSGLNG())
                .append(getOPMODE())
                .append(getCMTCONTROL())
                .append(getRSPMODE())
                .append(getMSGINDENT())
                .append(getMOREIND())
                .append(getERRLVL())
                .append(getIGNOREDRIVERHELD())
                .append(getSUPPRESSRCLRSC())
                .append(getFILLER())
                .toHashCode();
    }

    public String toJson() {
        return "LeaderHeader{" +
                "MSGREFNO='" + MSGREFNO + '\'' +
                ", USRPRF='" + USRPRF + '\'' +
                ", WKSID='" + WKSID + '\'' +
                ", OBJID='" + OBJID + '\'' +
                ", VRBID='" + VRBID + '\'' +
                ", TOTMSGLNG='" + TOTMSGLNG + '\'' +
                ", OPMODE='" + OPMODE + '\'' +
                ", CMTCONTROL='" + CMTCONTROL + '\'' +
                ", RSPMODE='" + RSPMODE + '\'' +
                ", MSGINDENT='" + MSGINDENT + '\'' +
                ", MOREIND='" + MOREIND + '\'' +
                ", ERRLVL='" + ERRLVL + '\'' +
                ", IGNOREDRIVERHELD='" + IGNOREDRIVERHELD + '\'' +
                ", SUPPRESSRCLRSC='" + SUPPRESSRCLRSC + '\'' +
                ", FILLER='" + FILLER + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(getMSGREFNO())
                .append(getUSRPRF())
                .append(getWKSID())
                .append(getOBJID())
                .append(getVRBID())
                .append(getTOTMSGLNG())
                .append(getOPMODE())
                .append(getCMTCONTROL())
                .append(getRSPMODE())
                .append(getMSGINDENT())
                .append(getMOREIND())
                .append(getERRLVL())
                .append(getIGNOREDRIVERHELD())
                .append(getSUPPRESSRCLRSC())
                .append(getFILLER())
                .toString();
    }

    private String formatStringLengthPadRight(String string, int length) {
        return StringUtils.rightPad(string,length);
    }
}
