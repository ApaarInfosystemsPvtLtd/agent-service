package com.pmli.lifeasia.translator.model.agent;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Document(collection = "AgentCreateRequest")
public class AgentCreateMessageBodyRequestDTO
{
    private	String	agn_action=" ";
    private	String	agntsel="          ";         // Agent Number
    private	String	agcls="0002";                 //Commission Class - Default Value.('0002') -To Confirm
    private	String	agntbr="  ";                  // Agent Branch
    private	String	agtype="  ";                  // Agent Type
    private	String	aracde="   ";                 // Area Code
    private	String	bcmtab="    ";                // Basic Commission
    private	String	bctind=" ";                   // Default Blank
    private	String	clnsel="          ";          // Client Number attached to Agent
    private	String	currcode="INR";               // Currency - Default value.('INR')
    private	String	ddind=" ";                    // ?? - 1 digit
    private	String	xopt=" ";                     // IM Transfer
    private	String	agentno="        ";           // IM Agent Number
    private	String	ragtype="  ";                 // IM Agent Type - 2 digit
    private	String	dteapp="        ";            // Date of Appointment
    private	String	dtetrm="99999999";            // ?? - Default value.(8 '9's)
    private	String	excagr="Y";                   // Exclusive - Default value.('N')
    private	String	minsta="00000000000000000";   // Minimum Amount of Commission - Default value.(17 '0's)
    private	String	ocmtab="     ";               // Bonus Allocation Default value.('BA01 ')
    private	String	ovcpc="00000";                // OverRide Percentage Default value.(5 '0's)
    private	String	payflag=" ";                  // Allow Commission Payment Flag
    private	String	payfrq="12";                  // Payment Frequency - Default value.('12') - Monthly
    private	String	paymth="CQ";                  // Payment Month - Default value.('CQ') - Computer Cheque
    private	String	paysel="          ";          // ?? - 10 digits
    private	String	rcmtab="    ";                // Renewal Commission - 4 digits
    private	String	repsel="          ";          // ?? - 10 digits
    private	String	scmtab="    ";                // Servicing Commission - 4 digits
    private	String	tagd=" ";                     // ?? - 1 digit
    private	String	tagsusind=" ";                // BlackList Status - 1 digit
    private	String	tlaglicno="               ";  // License Number/Certificate Number - 10 digits
    private	String	tlicexpdt="    ";             // Default value.('20991231') - Mandatory
    private	String	tlicstrdt="    ";             // License Start Date/ License Issuance Date- Mandatory
    private	String	tsalesunt="     ";            // Sales Unit - Default Blank
    private	String	zrorind=" ";                  // ??
    private	String	effdate=dateformatter();      // Effective Date - Default Current Date
    private	String	zagntsts="LICE";              // Default Value.('LICE')
    private	String	stat_change_date=dateformatter(); // Status Change Date - Default Current Date
    private	String	bankacckey="                    "; // Bank Account Details < Bank Account Number - Default Blank - Not Mandatory
    private	String	bankkey="          ";         // Bank Account Details < Bank Code - Default Blank - Not Mandatory
    private	String	ifsccode="           ";       // Bank Account Details < IFSC - Default Blank  - Not Mandatory
    private	String	panno="          ";           // Bank Account Details < PanNumber - Default Blank  - Not Mandatory
    private String contact="                                                                        "; // ??
    private	String	agccqind="N";                 // Consolidate Payment to A/c. Payee
    private	String	bmaflg=" ";                   // Type of Termination
    private	String	carln=" ";                    // Tied Agent Details > Car Loan
    private	String	comln=" ";                    // Tied Agent Details > Computer Loan
    private	String	fixprc="0000";                // Tied Agent Details > Fixed Percent
    private	String	hseln=" ";                    // Tied Agent Details > Housing Loan
    private	String	intcrd="0000";                // Tied Agent Details > Instant Credit
    private	String	irdno="          ";           // Tied Agent Details > IRD Number
    private	String	offrent=" ";                  // Tied Agent Details > Office Rent
    private	String	othln=" ";                    // Tied Agent Details > Other Lane
    private	String	sprprc="0000";                // Tied Agent Details > Super Annuation Percent
    private	String	sprschm="        ";           // Tied Agent Details > Super Annuation Code
    private	String	taxalw="                  ";  // Tied Agent Details > Tax Allowed
    private	String	taxcde="  ";                  // Tied Agent Details > Tax Code
    private	String	taxmeth="ST";                 // Tied Agent Details > Tax Method
    private	String	tcolmax="               ";    // Tied Agent Details > Max Limit
    private	String	tcolprct="00000";             //  Tied Agent Details > Collateral Percentage
    private String  status="Received";
    @JsonFormat
    private String  timestamp= LocalDateTime.now().toString();
    private String requestId ="";
    private String retry="0";

    public String getRetry() {
        return retry;
    }

    public void setRetry(String retry) {
        this.retry = retry;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getAction() {
        return agn_action;
    }

    public void setAction(String agn_action) {
        this.agn_action = agn_action;
    }

    public String getAgntsel() {
        return agntsel;
    }

    public void setAgntsel(String agntsel) {
        this.agntsel = agntsel;
        this.agentno = agntsel.substring(0,agntsel.length()-2);
    }

    public String getAgcls() {
        return agcls;
    }

    public void setAgcls(String agcls) {
        this.agcls = agcls;
    }

    public String getAgntbr() {
        return agntbr;
    }

    public void setAgntbr(String agntbr) {
        this.agntbr = agntbr;
    }

    public String getAgtype() {
        return agtype;
    }

    public void setAgtype(String agtype) {
        this.agtype = agtype;
    }

    public String getAracde() {
        return aracde;
    }

    public void setAracde(String aracde) {
        this.aracde = aracde;
    }

    public String getBcmtab() {
        return bcmtab;
    }

    public void setBcmtab(String bcmtab) {
        this.bcmtab = bcmtab;
    }

    public String getBctind() {
        return bctind;
    }

    public void setBctind(String bctind) {
        this.bctind = bctind;
    }

    public String getClnsel() {
        return clnsel;
    }

    public void setClnsel(String clnsel) {
        this.clnsel = clnsel;
    }

    public String getCurrcode() {
        return currcode;
    }

    public void setCurrcode(String currcode) {
        this.currcode = currcode;
    }

    public String getDdind() {
        return ddind;
    }

    public void setDdind(String ddind) {
        this.ddind = ddind;
    }

    public String getXopt() {
        return xopt;
    }

    public void setXopt(String xopt) {
        this.xopt = xopt;
    }

    public String getAgentno() {
        return agentno;
    }

    public void setAgentno() {
    }

    public String getRagtype() {
        return ragtype;
    }

    public void setRagtype(String ragtype) {
        this.ragtype = ragtype;
    }

    public String getDteapp() {
        return dteapp;
    }

    public void setDteapp(String dteapp) {
        this.dteapp = dteapp;
    }

    public String getDtetrm() {
        return dtetrm;
    }

    public void setDtetrm(String dtetrm) {
        this.dtetrm = dtetrm;
    }

    public String getExcagr() {
        return excagr;
    }

    public void setExcagr(String excagr) {
        this.excagr = excagr;
    }

    public String getMinsta() {
        return minsta;
    }

    public void setMinsta(String minsta) {
        this.minsta = minsta;
    }

    public String getOcmtab() {
        return ocmtab;
    }

    public void setOcmtab(String ocmtab) {
        this.ocmtab = ocmtab;
    }

    public String getOvcpc() {
        return ovcpc;
    }

    public void setOvcpc(String ovcpc) {
        this.ovcpc = ovcpc;
    }

    public String getPayflag() {
        return payflag;
    }

    public void setPayflag(String payflag) {
        this.payflag = payflag;
    }

    public String getPayfrq() {
        return payfrq;
    }

    public void setPayfrq(String payfrq) {
        this.payfrq = payfrq;
    }

    public String getPaymth() {
        return paymth;
    }

    public void setPaymth(String paymth) {
        this.paymth = paymth;
    }

    public String getPaysel() {
        return paysel;
    }

    public void setPaysel(String paysel) {
        this.paysel = paysel;
    }

    public String getRcmtab() {
        return rcmtab;
    }

    public void setRcmtab(String rcmtab) {
        this.rcmtab = rcmtab;
    }

    public String getRepsel() {
        return repsel;
    }

    public void setRepsel(String repsel) {
        this.repsel = repsel;
    }

    public String getScmtab() {
        return scmtab;
    }

    public void setScmtab(String scmtab) {
        this.scmtab = scmtab;
    }

    public String getTagd() {
        return tagd;
    }

    public void setTagd(String tagd) {
        this.tagd = tagd;
    }

    public String getTagsusind() {
        return tagsusind;
    }

    public void setTagsusind(String tagsusind) {
        this.tagsusind = tagsusind;
    }

    public String getTlaglicno() {
        return tlaglicno;
    }

    public void setTlaglicno(String tlaglicno) {
        this.tlaglicno = tlaglicno;
    }

    public String getTlicexpdt() {
        return tlicexpdt;
    }

    public void setTlicexpdt(String tlicexpdt) {
        this.tlicexpdt = tlicexpdt;
    }

    public String getTlicstrdt() {
        return tlicstrdt;
    }

    public void setTlicstrdt(String tlicstrdt) {
        this.tlicstrdt = tlicstrdt;
    }

    public String getTsalesunt() {
        return tsalesunt;
    }

    public void setTsalesunt(String tsalesunt) {
        this.tsalesunt = tsalesunt;
    }

    public String getZrorind() {
        return zrorind;
    }

    public void setZrorind(String zrorind) {
        this.zrorind = zrorind;
    }

    public String getEffdate() {
        return effdate;
    }

    public void setEffdate(String effdate) {
        this.effdate = effdate;
    }

    public String getZagntsts() {
        return zagntsts;
    }

    public void setZagntsts(String zagntsts) {
        this.zagntsts = zagntsts;
    }

    public String getStat_change_date() {
        return stat_change_date;
    }

    public void setStat_change_date(String stat_change_date) {
        this.stat_change_date = stat_change_date;
    }

    public String getBankacckey() {
        return bankacckey;
    }

    public void setBankacckey(String bankacckey) {
        this.bankacckey = bankacckey;
    }

    public String getBankkey() {
        return bankkey;
    }

    public void setBankkey(String bankkey) {
        this.bankkey = bankkey;
    }

    public String getIfsccode() {
        return ifsccode;
    }

    public void setIfsccode(String ifsccode) {
        this.ifsccode = ifsccode;
    }

    public String getPanno() {
        return panno;
    }

    public void setPanno(String panno) {
        this.panno = panno;
    }

    public String getContact() {
        return contact;
    }

    public void setcontact(String contact) {
        this.contact = contact;
    }

    public String getAgccqind() {
        return agccqind;
    }

    public void setAgccqind(String agccqind) {
        this.agccqind = agccqind;
    }

    public String getBmaflg() {
        return bmaflg;
    }

    public void setBmaflg(String bmaflg) {
        this.bmaflg = bmaflg;
    }

    public String getCarln() {
        return carln;
    }

    public void setCarln(String carln) {
        this.carln = carln;
    }

    public String getComln() {
        return comln;
    }

    public void setComln(String comln) {
        this.comln = comln;
    }

    public String getFixprc() {
        return fixprc;
    }

    public void setFixprc(String fixprc) {
        this.fixprc = fixprc;
    }

    public String getHseln() {
        return hseln;
    }

    public void setHseln(String hseln) {
        this.hseln = hseln;
    }

    public String getIntcrd() {
        return intcrd;
    }

    public void setIntcrd(String intcrd) {
        this.intcrd = intcrd;
    }

    public String getIrdno() {
        return irdno;
    }

    public void setIrdno(String irdno) {
        this.irdno = irdno;
    }

    public String getOffrent() {
        return offrent;
    }

    public void setOffrent(String offrent) {
        this.offrent = offrent;
    }

    public String getOthln() {
        return othln;
    }

    public void setOthln(String othln) {
        this.othln = othln;
    }

    public String getSprprc() {
        return sprprc;
    }

    public void setSprprc(String sprprc) {
        this.sprprc = sprprc;
    }

    public String getSprschm() {
        return sprschm;
    }

    public void setSprschm(String sprschm) {
        this.sprschm = sprschm;
    }

    public String getTaxalw() {
        return taxalw;
    }

    public void setTaxalw(String taxalw) {
        this.taxalw = taxalw;
    }

    public String getTaxcde() {
        return taxcde;
    }

    public void setTaxcde(String taxcde) {
        this.taxcde = taxcde;
    }

    public String getTaxmeth() {
        return taxmeth;
    }

    public void setTaxmeth(String taxmeth) {
        this.taxmeth = taxmeth;
    }

    public String getTcolmax() {
        return tcolmax;
    }

    public void setTcolmax(String tcolmax) {
        this.tcolmax = tcolmax;
    }

    public String getTcolprct() {
        return tcolprct;
    }

    public void setTcolprct(String tcolprct) {
        this.tcolprct = tcolprct;
    }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AgentCreateMessageBodyRequestDTO that = (AgentCreateMessageBodyRequestDTO) o;

        return new EqualsBuilder()

                .append(getAction(),that.getAction())
                .append(getAgntsel(),that.getAgntsel())
                .append(getAgcls(),that.getAgcls())
                .append(getAgntbr(),that.getAgntbr())
                .append(getAgtype(),that.getAgtype())
                .append(getAracde(),that.getAracde())
                .append(getBcmtab(),that.getBcmtab())
                .append(getBctind(),that.getBctind())
                .append(getClnsel(),that.getClnsel())
                .append(getCurrcode(),that.getCurrcode())
                .append(getDdind(),that.getDdind())
                .append(getXopt(),that.getXopt())
                .append(getAgentno(),that.getAgentno())
                .append(getRagtype(),that.getRagtype())
                .append(getDteapp(),that.getDteapp())
                .append(getDtetrm(),that.getDtetrm())
                .append(getExcagr(),that.getExcagr())
                .append(getMinsta(),that.getMinsta())
                .append(getOcmtab(),that.getOcmtab())
                .append(getOvcpc(),that.getOvcpc())
                .append(getPayflag(),that.getPayflag())
                .append(getPayfrq(),that.getPayfrq())
                .append(getPaymth(),that.getPaymth())
                .append(getPaysel(),that.getPaysel())
                .append(getRcmtab(),that.getRcmtab())
                .append(getRepsel(),that.getRepsel())
                .append(getScmtab(),that.getScmtab())
                .append(getTagd(),that.getTagd())
                .append(getTagsusind(),that.getTagsusind())
                .append(getTlaglicno(),that.getTlaglicno())
                .append(getTlicexpdt(),that.getTlicexpdt())
                .append(getTlicstrdt(),that.getTlicstrdt())
                .append(getTsalesunt(),that.getTsalesunt())
                .append(getZrorind(),that.getZrorind())
                .append(getEffdate(),that.getEffdate())
                .append(getZagntsts(),that.getZagntsts())
                .append(getStat_change_date(),that.getStat_change_date())
                .append(getBankacckey(),that.getBankacckey())
                .append(getBankkey(),that.getBankkey())
                .append(getIfsccode(),that.getIfsccode())
                .append(getPanno(),that.getPanno())
                .append(getContact(),that.getContact())
                .append(getAgccqind(),that.getAgccqind())
                .append(getBmaflg(),that.getBmaflg())
                .append(getCarln(),that.getCarln())
                .append(getComln(),that.getComln())
                .append(getFixprc(),that.getFixprc())
                .append(getHseln(),that.getFixprc())
                .append(getIntcrd(),that.getIntcrd())
                .append(getIrdno(),that.getIrdno())
                .append(getOffrent(),that.getOffrent())
                .append(getOthln(),that.getOthln())
                .append(getSprprc(),that.getSprprc())
                .append(getSprschm(),that.getSprschm())
                .append(getTaxalw(),that.getTaxalw())
                .append(getTaxcde(),that.getTaxcde())
                .append(getTaxmeth(),that.getTaxmeth())
                .append(getTcolmax(),that.getTcolmax())
                .append(getTcolprct(),that.getTcolprct())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getAction())
                .append(getAgntsel())
                .append(getAgcls())
                .append(getAgntbr())
                .append(getAgtype())
                .append(getAracde())
                .append(getBcmtab())
                .append(getBctind())
                .append(getClnsel())
                .append(getCurrcode())
                .append(getDdind())
                .append(getXopt())
                .append(getAgentno())
                .append(getRagtype())
                .append(getDteapp())
                .append(getDtetrm())
                .append(getExcagr())
                .append(getMinsta())
                .append(getOcmtab())
                .append(getOvcpc())
                .append(getPayflag())
                .append(getPayfrq())
                .append(getPaymth())
                .append(getPaysel())
                .append(getRcmtab())
                .append(getRepsel())
                .append(getScmtab())
                .append(getTagd())
                .append(getTagsusind())
                .append(getTlaglicno())
                .append(getTlicexpdt())
                .append(getTlicstrdt())
                .append(getTsalesunt())
                .append(getZrorind())
                .append(getEffdate())
                .append(getZagntsts())
                .append(getStat_change_date())
                .append(getBankacckey())
                .append(getBankkey())
                .append(getIfsccode())
                .append(getPanno())
                .append(getContact())
                .append(getAgccqind())
                .append(getBmaflg())
                .append(getCarln())
                .append(getComln())
                .append(getFixprc())
                .append(getHseln())
                .append(getIntcrd())
                .append(getIrdno())
                .append(getOffrent())
                .append(getOthln())
                .append(getSprprc())
                .append(getSprschm())
                .append(getTaxalw())
                .append(getTaxcde())
                .append(getTaxmeth())
                .append(getTcolmax())
                .append(getTcolprct())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "AgentCreateMessageBodyRequestDTO{" +
                "action='" + agn_action + '\'' +
                ", agntsel='" + agntsel + '\'' +
                ", agcls='" + agcls + '\'' +
                ", agntbr='" + agntbr + '\'' +
                ", agtype='" + agtype + '\'' +
                ", aracde='" + aracde + '\'' +
                ", bcmtab='" + bcmtab + '\'' +
                ", bctind='" + bctind + '\'' +
                ", clnsel='" + clnsel + '\'' +
                ", currcode='" + currcode + '\'' +
                ", ddind='" + ddind + '\'' +
                ", xopt='" + xopt + '\'' +
                ", agentno='" + agentno + '\'' +
                ", ragtype='" + ragtype + '\'' +
                ", dteapp='" + dteapp + '\'' +
                ", dtetrm='" + dtetrm + '\'' +
                ", excagr='" + excagr + '\'' +
                ", minsta='" + minsta + '\'' +
                ", ocmtab='" + ocmtab + '\'' +
                ", ovcpc='" + ovcpc + '\'' +
                ", payflag='" + payflag + '\'' +
                ", payfrq='" + payfrq + '\'' +
                ", paymth='" + paymth + '\'' +
                ", paysel='" + paysel + '\'' +
                ", rcmtab='" + rcmtab + '\'' +
                ", repsel='" + repsel + '\'' +
                ", scmtab='" + scmtab + '\'' +
                ", tagd='" + tagd + '\'' +
                ", tagsusind='" + tagsusind + '\'' +
                ", tlaglicno='" + tlaglicno + '\'' +
                ", tlicexpdt='" + tlicexpdt + '\'' +
                ", tlicstrdt='" + tlicstrdt + '\'' +
                ", tsalesunt='" + tsalesunt + '\'' +
                ", zrorind='" + zrorind + '\'' +
                ", effdate='" + effdate + '\'' +
                ", zagntsts='" + zagntsts + '\'' +
                ", stat_change_date='" + stat_change_date + '\'' +
                ", bankacckey='" + bankacckey + '\'' +
                ", bankkey='" + bankkey + '\'' +
                ", ifsccode='" + ifsccode + '\'' +
                ", panno='" + panno + '\'' +
                ", contact=" + contact +
                ", agccqind='" + agccqind + '\'' +
                ", bmaflg='" + bmaflg + '\'' +
                ", carln='" + carln + '\'' +
                ", comln='" + comln + '\'' +
                ", fixprc='" + fixprc + '\'' +
                ", hseln='" + hseln + '\'' +
                ", intcrd='" + intcrd + '\'' +
                ", irdno='" + irdno + '\'' +
                ", offrent='" + offrent + '\'' +
                ", othln='" + othln + '\'' +
                ", sprprc='" + sprprc + '\'' +
                ", sprschm='" + sprschm + '\'' +
                ", taxalw='" + taxalw + '\'' +
                ", taxcde='" + taxcde + '\'' +
                ", taxmeth='" + taxmeth + '\'' +
                ", tcolmax='" + tcolmax + '\'' +
                ", tcolprct='" + tcolprct + '\'' +
                '}';
    }

    public String toJson() {
        return "AgnCRTIMessageBodyRequest{" +
                "action='" + agn_action + '\'' +
                ", agntsel='" + agntsel + '\'' +
                ", agcls='" + agcls + '\'' +
                ", agntbr='" + agntbr + '\'' +
                ", agtype='" + agtype + '\'' +
                ", aracde='" + aracde + '\'' +
                ", bcmtab='" + bcmtab + '\'' +
                ", bctind='" + bctind + '\'' +
                ", clnsel='" + clnsel + '\'' +
                ", currcode='" + currcode + '\'' +
                ", ddind='" + ddind + '\'' +
                ", xopt='" + xopt + '\'' +
                ", agentno='" + agentno + '\'' +
                ", ragtype='" + ragtype + '\'' +
                ", dteapp='" + dteapp + '\'' +
                ", dtetrm='" + dtetrm + '\'' +
                ", excagr='" + excagr + '\'' +
                ", minsta='" + minsta + '\'' +
                ", ocmtab='" + ocmtab + '\'' +
                ", ovcpc='" + ovcpc + '\'' +
                ", payflag='" + payflag + '\'' +
                ", payfrq='" + payfrq + '\'' +
                ", paymth='" + paymth + '\'' +
                ", paysel='" + paysel + '\'' +
                ", rcmtab='" + rcmtab + '\'' +
                ", repsel='" + repsel + '\'' +
                ", scmtab='" + scmtab + '\'' +
                ", tagd='" + tagd + '\'' +
                ", tagsusind='" + tagsusind + '\'' +
                ", tlaglicno='" + tlaglicno + '\'' +
                ", tlicexpdt='" + tlicexpdt + '\'' +
                ", tlicstrdt='" + tlicstrdt + '\'' +
                ", tsalesunt='" + tsalesunt + '\'' +
                ", zrorind='" + zrorind + '\'' +
                ", effdate='" + effdate + '\'' +
                ", zagntsts='" + zagntsts + '\'' +
                ", stat_change_date_ccyy='" + stat_change_date + '\'' +
                ", bankacckey='" + bankacckey + '\'' +
                ", bankkey='" + bankkey + '\'' +
                ", ifsccode='" + ifsccode + '\'' +
                ", panno='" + panno + '\'' +
                ", contact='" + contact + '\'' +
                ", agccqind='" + agccqind + '\'' +
                ", bmaflg='" + bmaflg + '\'' +
                ", carln='" + carln + '\'' +
                ", comln='" + comln + '\'' +
                ", fixprc='" + fixprc + '\'' +
                ", hseln='" + hseln + '\'' +
                ", intcrd='" + intcrd + '\'' +
                ", irdno='" + irdno + '\'' +
                ", offrent='" + offrent + '\'' +
                ", othln='" + othln + '\'' +
                ", sprprc='" + sprprc + '\'' +
                ", sprschm='" + sprschm + '\'' +
                ", taxalw='" + taxalw + '\'' +
                ", taxcde='" + taxcde + '\'' +
                ", taxmeth='" + taxmeth + '\'' +
                ", tcolmax='" + tcolmax + '\'' +
                ", tcolprct='" + tcolprct + '\'' +
                '}';
    }

    public String dateformatter() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDateTime localDateTime = LocalDateTime.now();
        String date = dtf.format(localDateTime);
        return date;
    }
}
