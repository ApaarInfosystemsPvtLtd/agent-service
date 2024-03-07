package com.pmli.lifeasia.translator.model.agent;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Document(collection = "UserAgentModifyRequest")
public class AgentModifyRequestDTO
{
    private	String	agn_action=" ";
    private	String	agentCode="          ";
    private	String	agcls="0002";//As discussed Default Value.('0002')
    private	String	agentBranch="  ";
    private	String	agentType="  ";
    private	String	areaCode="   ";
    private	String	bcmtab="    ";
    private	String	bctind=" ";
    private	String	currcode="INR";//As discussed Default value.('INR')
    private	String	ddind=" ";
    private	String	dateOfAppointment="        ";
    private	String	imTransfer="N";//As discussed Default value.('N')
    private	String	agentno="        ";
    private	String	ragtype="  ";
    private	String	dtetrm="99999999";//As discussed Default value.(4 '9's)
    private	String	excagr="Y";//As discussed Default value.('N')
    private	String	minsta="00000000000000000";//As discussed Default value.(17 '0's)
    private	String	ocmtab="     ";//As discussed Default value.('BA01 ')
    private	String	ovcpc="00000";
    private	String	payflag=" ";
    private	String	payfrq="12";//As discussed Default value.('12')
    private	String	paymth="CQ";//As discussed Default value.('CQ')
    private	String	paysel="          ";
    private	String	rcmtab="    ";
    private	String	reportingManager="          ";
    private	String	scmtab="    ";
    private	String	tagd=" ";
    private	String	tagsusind=" ";
    private	String	licenceNumber="               ";
    private	String	licenceExpiryDate="20991231";
    private	String	licenceStartDate="        ";
    private	String	tsalesunt="     ";
    private	String	zrorind=" ";
    private	String	effdate=dateformatter();
    private	String	zagntsts="LICE";//As discussed Default value.('LICE')
    private	String	stat_change_date=dateformatter();
    private	String	bankacckey="                    ";
    private	String	bankkey="          ";
    private	String	ifsccode="           ";
    private	String	panno="          ";
    private String  contact="                                                                        ";
    private	String	agccqind=" ";
    private	String	bmaflg=" ";
    private	String	carln=" ";
    private	String	comln=" ";
    private	String	fixprc="0000";//As discussed Default value.(4 '0's)
    private	String	hseln=" ";
    private	String	intcrd="0000";//As discussed Default value.(4 '0's)
    private	String	irdno="          ";
    private	String	offrent=" ";
    private	String	othln=" ";
    private	String	sprprc="0000";//As discussed Default value.(4 '0's)
    private	String	sprschm="          ";
    private	String	taxalw="                  ";//18 character.
    private	String	taxcde="  ";
    private	String	taxmeth="ST";
    private	String	tcolmax="               ";//15 character.
    private	String	tcolprct="00000";//As discussed Default value.(5 '0's)
    private String 	clnt_action=" ";
    private String 	clientCode="        ";
    private String 	secuityno1="                        ";
    private String 	addressType=" ";
    private String 	birthp="                    ";
    private String 	addressLine01="                              ";
    private String 	addressLine02="                              ";
    private String 	addressLine03="                              ";
    private String 	city="                              ";
    private String 	cltaddr05="                              ";
    private String 	dateOfBirth="        ";
    private String 	cltdodx="99999999";//As Discussed Default value.(8,'9's)
    private String 	pinCode="          ";
    private String 	phoneNumber01="                ";
    private String 	phoneNumber02="                ";
    private	String 	gender=" ";
    private String 	ctrycode="IN ";//As Discussed Default value.('IN ')
    private String 	dirmail=" ";
    private String 	docno="        ";
    private String 	language=" ";
    private String 	firstName="                                                            ";
    private String 	lastName="                                                            ";
    private String 	mailing=" ";
    private String 	maritalStatus=" ";
    private String 	natlty="IND";//As Discussed Default value.('IND')
    private String 	nmfmt=" ";
    private String 	occpcode="    ";//As Discussed Default value.('SELF')
    private String 	salutation="        ";
    private String 	secuityno="                        ";
    private String 	sourceOfEvidence="          ";
    private String 	statcode="  ";
    private String 	taxflag=" ";
    private String 	vip=" ";
    private String 	zdoctind="N";//As Discussed Default value.('Y')
    private String 	state="    ";
    private String 	sfatname="                                                            ";
    private String 	zfreetext="                                                  ";
    private String 	zckycitz="   ";
    private String 	faxno="                ";
    private String 	oldidno="                        ";
    private String 	rdidtelno="                ";
    private String 	rinternet="                                                  ";
    private	String 	rmblphone="9999999999      ";//As Discussed Default value.(10,'9's)
    private	String 	rpager="                ";
    private	String 	rstaflag="  ";
    private	String 	rtaxidnum="          ";
    private	String 	zspecind="  ";
    private	String 	zlndmark="                                   ";
    private	String 	aadhar_number="              ";
    private	String 	zekyadhen="              ";
    private	String 	zekyformsx=" ";
    private	String 	zekyadhrsp=" ";
    private	String 	zckyfatca=" ";
    private	String 	zckynadd_01="                                                       ";
    private String 	zckynadd_02="                                                       ";
    private String 	zckynadd_03="                                                       ";
    private String 	zckyncity="                                                  ";
    private String 	zckyncntry="   ";
    private String 	znrifretxt="                                                  ";
    private String 	zckynstate="                                                  ";
    private String 	zckynpin="      ";
    private String 	addressProof="        ";//
    private String 	clntrskind="1";//AS discussed default value.('1')
    private String 	idprf="        ";
    private String 	idprfdt="99999999";//AS discussed default value.('1')
    private String 	idprfnum="                    ";
    private String 	incprf="        ";
    private String 	issueauth="                              ";
    private String 	reasoncd="    ";
    private String 	salary="00000000000";//AS discussed default value.('1')
    private String 	partnerdoc="        ";
    private String 	employee="        ";
    private	String 	podoc="        ";
    private	String 	zkyidexdt="99999999";//AS discussed default value.(8,'9's)
    private	String 	salutl1="        ";
    private	String 	spofname="                                                  ";
    private	String 	spolname="                                                  ";
    private	String 	spomname="                                                  ";
    private	String 	mdfname="                                                  ";
    private	String 	mdlname="                                                  ";
    private	String 	mdmname="                                                  ";
    private	String 	mdsalut="      ";
    private	String 	mofname="                                                  ";
    private	String 	molname="                                                  ";
    private	String 	momname="                                                  ";
    private	String 	mosalut="      ";
    private	String 	zckyacty="  ";
    private	String 	zckyadd_01="                                                       ";
    private	String 	zckyadd_02="                                                       ";
    private	String 	zckyadd_03="                                                       ";
    private	String 	zckyadhen="              ";
    private	String 	zckycity="                                                  ";
    private	String 	zckypin="      ";
    private	String 	zckycntry="   ";
    private	String 	zckyfax="            ";
    private	String 	zckyfrtext="                                                  ";
    private	String 	zckyno="              ";
    private	String 	zckystate="                                                  ";
    private	String 	zkycltmdn="                                                  ";
    private	String 	zckyaddrty=" ";
    private	String 	zckymarryd=" ";
    private	String 	zckyoccpcd="    ";

    public String getAgn_action() {
        return agn_action;
    }

    public void setAgn_action(String agn_action) {
        this.agn_action = agn_action;
    }

    public String getAgntsel() {
        return agentCode;
    }

    public void setagentCode(String agentCode) {
        this.agentCode = formatStringLength(agentCode,10);
        this.licenceNumber = formatStringLength(agentCode,15);
    }

    public String getAgcls() {
        return agcls;
    }

    public void setAgcls(String agcls) {
        this.agcls = agcls;
    }

    public String getAgntbr() {
        return agentBranch;
    }

    public void setagentBranch(String agentBranch) {
        this.agentBranch = agentBranch;
    }

    public String getAgtype() {
        return agentType;
    }

    public void setagentType(String agentType) {
        this.agentType = agentType;
    }

    public String getAracde() {
        return areaCode;
    }

    public void setareaCode(String areaCode) {
        this.areaCode = areaCode;
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

    public String getDteapp() {
        return dateOfAppointment;
    }

    public void setdateOfAppointment(String dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
        this.licenceStartDate = dateOfAppointment;
    }

    public String getXopt() {
        return imTransfer;
    }

    public void setimTransfer(String imTransfer) {
        this.imTransfer = imTransfer;
    }

    public String getAgentno() {
        return agentno;
    }

    public void setAgentno(String agentno) {
        this.agentno = agentno;
    }

    public String getRagtype() {
        return ragtype;
    }

    public void setRagtype(String ragtype) {
        this.ragtype = ragtype;
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
        this.minsta = formatStringLengthPadLeft(minsta,17);
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
        this.paysel = formatStringLength(paysel,10);
    }

    public String getRcmtab() {
        return rcmtab;
    }

    public void setRcmtab(String rcmtab) {
        this.rcmtab = rcmtab;
    }

    public String getRepsel() {
        return reportingManager;
    }

    public void setreportingManager(String reportingManager) {
        this.reportingManager = formatStringLength(reportingManager,10);;
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
        return licenceNumber;
    }

    public void setlicenceNumber(String licenceNumber) {
        this.licenceNumber = formatStringLength(licenceNumber,15);
    }

    public String getTlicexpdt() {
        return licenceExpiryDate;
    }

    public void setlicenceExpiryDate(String licenceExpiryDate) {
        this.licenceExpiryDate = licenceExpiryDate;
    }

    public String getTlicstrdt() {
        return licenceStartDate;
    }

    public void setlicenceStartDate(String licenceStartDate) {
        this.licenceStartDate = licenceStartDate;
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
        this.bankacckey = formatStringLength(bankacckey,20);
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

    public void setContact(String contact) {
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

    public String getClnt_action() {
        return clnt_action;
    }

    public void setClnt_action(String clnt_action) {
        this.clnt_action = clnt_action;
    }

    public String getClttwo() {
        return clientCode;
    }

    public void setclientCode(String clientCode) {
        this.clientCode = formatStringLength(clientCode,8);;
    }

    public String getSecuityno1() {
        return secuityno1;
    }

    public void setSecuityno1(String secuityno1) {
        this.secuityno1 = secuityno1;
    }

    public String getAddrtype() {
        return addressType;
    }

    public void setaddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getBirthp() {
        return birthp;
    }

    public void setBirthp(String birthp) {
        this.birthp = birthp;
    }

    public String getCltaddr01() {
        return addressLine01;
    }

    public void setaddressLine01(String addressLine01) {
        this.addressLine01 = formatStringLength(addressLine01,30);;
    }

    public String getCltaddr02() {
        return addressLine02;
    }

    public void setaddressLine02(String addressLine02) {
        this.addressLine02 = formatStringLength(addressLine02,30);;
    }

    public String getCltaddr03() {
        return addressLine03;
    }

    public void setaddressLine03(String addressLine03) {
        this.addressLine03 = formatStringLength(addressLine03,30);;
    }

    public String getCltaddr04() {
        return city;
    }

    public void setcity(String city) {
        this.city = formatStringLength(city,30);;
    }

    public String getCltaddr05() {
        return cltaddr05;
    }

    public void setCltaddr05(String cltaddr05) {
        this.cltaddr05 = formatStringLength(cltaddr05,30);;
    }

    public String getCltdobx() {
        return dateOfBirth;
    }

    public void setdateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCltdodx() {
        return cltdodx;
    }

    public void setCltdodx(String cltdodx) {
        this.cltdodx = cltdodx;
    }

    public String getCltpcode() {
        return pinCode;
    }

    public void setpinCode(String pinCode) {
        this.pinCode = formatStringLength(pinCode,10);
    }

    public String getCltphone01() {
        return phoneNumber01;
    }

    public void setphoneNumber01(String phoneNumber01) {
        this.phoneNumber01 = formatStringLength(phoneNumber01,16);;
    }

    public String getCltphone02() {
        return phoneNumber02;
    }

    public void setphoneNumber02(String phoneNumber02) {
        this.phoneNumber02 = formatStringLength(phoneNumber02,16);
    }

    public String getCltsex() {
        return gender;
    }

    public void setgender(String gender) {
        this.gender = gender;
    }

    public String getCtrycode() {
        return ctrycode;
    }

    public void setCtrycode(String ctrycode) {
        this.ctrycode = ctrycode;
    }

    public String getDirmail() {
        return dirmail;
    }

    public void setDirmail(String dirmail) {
        this.dirmail = dirmail;
    }

    public String getDocno() {
        return docno;
    }

    public void setDocno(String docno) {
        this.docno = docno;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLgivname() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = formatStringLength(firstName,60) ;;
    }

    public String getLsurname() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = formatStringLength(lastName,60) ;
    }

    public String getMailing() {
        return mailing;
    }

    public void setMailing(String mailing) {
        this.mailing = mailing;
    }

    public String getMarryd() {
        return maritalStatus;
    }

    public void setmaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getNatlty() {
        return natlty;
    }

    public void setNatlty(String natlty) {
        this.natlty = natlty;
    }

    public String getNmfmt() {
        return nmfmt;
    }

    public void setNmfmt(String nmfmt) {
        this.nmfmt = nmfmt;
    }

    public String getOccpcode() {
        return occpcode;
    }

    public void setOccpcode(String occpcode) {
        this.occpcode = occpcode;
    }

    public String getSalutl() {
        return salutation;
    }

    public void setsalutation(String salutation) {
        this.salutation = formatStringLength(salutation,8);;
    }

    public String getSecuityno() {
        return secuityno;
    }

    public void setSecuityno(String secuityno) {
        this.secuityno =  formatStringLength(secuityno,24);
    }

    public String getSoe() {
        return sourceOfEvidence;
    }

    public void setsourceOfEvidence(String sourceOfEvidence) {
        this.sourceOfEvidence = formatStringLength(sourceOfEvidence,10);;
    }

    public String getStatcode() {
        return statcode;
    }

    public void setStatcode(String statcode) {
        this.statcode = statcode;
    }

    public String getTaxflag() {
        return taxflag;
    }

    public void setTaxflag(String taxflag) {
        this.taxflag = taxflag;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public String getZdoctind() {
        return zdoctind;
    }

    public void setZdoctind(String zdoctind) {
        this.zdoctind = zdoctind;
    }

    public String getZsstate() {
        return state;
    }

    public void setstate(String state) {
        this.state = formatStringLength(state,4);;
    }

    public String getSfatname() {
        return sfatname;
    }

    public void setSfatname(String sfatname) {
        this.sfatname = sfatname;
    }

    public String getZfreetext() {
        return zfreetext;
    }

    public void setZfreetext(String zfreetext) {
        this.zfreetext = zfreetext;
    }

    public String getZckycitz() {
        return zckycitz;
    }

    public void setZckycitz(String zckycitz) {
        this.zckycitz = zckycitz;
    }

    public String getFaxno() {
        return faxno;
    }

    public void setFaxno(String faxno) {
        this.faxno = faxno;
    }

    public String getOldidno() {
        return oldidno;
    }

    public void setOldidno(String oldidno) {
        this.oldidno = oldidno;
    }

    public String getRdidtelno() {
        return rdidtelno;
    }

    public void setRdidtelno(String rdidtelno) {
        this.rdidtelno = rdidtelno;
    }

    public String getRinternet() {
        return rinternet;
    }

    public void setRinternet(String rinternet) {
        this.rinternet = formatStringLength(rinternet,50);
    }

    public String getRmblphone() {
        return rmblphone;
    }

    public void setRmblphone(String rmblphone) {
        this.rmblphone = formatStringLength(rmblphone,16);
    }

    public String getRpager() {
        return rpager;
    }

    public void setRpager(String rpager) {
        this.rpager = rpager;
    }

    public String getRstaflag() {
        return rstaflag;
    }

    public void setRstaflag(String rstaflag) {
        this.rstaflag = rstaflag;
    }

    public String getRtaxidnum() {
        return rtaxidnum;
    }

    public void setRtaxidnum(String rtaxidnum) {
        this.rtaxidnum = rtaxidnum;
    }

    public String getZspecind() {
        return zspecind;
    }

    public void setZspecind(String zspecind) {
        this.zspecind = zspecind;
    }

    public String getZlndmark() {
        return zlndmark;
    }

    public void setZlndmark(String zlndmark) {
        this.zlndmark = zlndmark;
    }

    public String getAadhar_number() {
        return aadhar_number;
    }

    public void setAadhar_number(String aadhar_number) {
        this.aadhar_number = formatStringLength(aadhar_number,14);
    }

    public String getZekyadhen() {
        return zekyadhen;
    }

    public void setZekyadhen(String zekyadhen) {
        this.zekyadhen = zekyadhen;
    }

    public String getZekyformsx() {
        return zekyformsx;
    }

    public void setZekyformsx(String zekyformsx) {
        this.zekyformsx = zekyformsx;
    }

    public String getZekyadhrsp() {
        return zekyadhrsp;
    }

    public void setZekyadhrsp(String zekyadhrsp) {
        this.zekyadhrsp = zekyadhrsp;
    }

    public String getZckyfatca() {
        return zckyfatca;
    }

    public void setZckyfatca(String zckyfatca) {
        this.zckyfatca = zckyfatca;
    }

    public String getZckynadd_01() {
        return zckynadd_01;
    }

    public void setZckynadd_01(String zckynadd_01) {
        this.zckynadd_01 = zckynadd_01;
    }

    public String getZckynadd_02() {
        return zckynadd_02;
    }

    public void setZckynadd_02(String zckynadd_02) {
        this.zckynadd_02 = zckynadd_02;
    }

    public String getZckynadd_03() {
        return zckynadd_03;
    }

    public void setZckynadd_03(String zckynadd_03) {
        this.zckynadd_03 = zckynadd_03;
    }

    public String getZckyncity() {
        return zckyncity;
    }

    public void setZckyncity(String zckyncity) {
        this.zckyncity = zckyncity;
    }

    public String getZckyncntry() {
        return zckyncntry;
    }

    public void setZckyncntry(String zckyncntry) {
        this.zckyncntry = zckyncntry;
    }

    public String getZnrifretxt() {
        return znrifretxt;
    }

    public void setZnrifretxt(String znrifretxt) {
        this.znrifretxt = znrifretxt;
    }

    public String getZckynstate() {
        return zckynstate;
    }

    public void setZckynstate(String zckynstate) {
        this.zckynstate = zckynstate;
    }

    public String getZckynpin() {
        return zckynpin;
    }

    public void setZckynpin(String zckynpin) {
        this.zckynpin = zckynpin;
    }

    public String getAddrprf() {
        return addressProof;
    }

    public void setaddressProof(String addressProof) {
        this.addressProof = formatStringLength(addressProof,8);;
    }

    public String getClntrskind() {
        return clntrskind;
    }

    public void setClntrskind(String clntrskind) {
        this.clntrskind = clntrskind;
    }

    public String getIdprf() {
        return idprf;
    }

    public void setIdprf(String idprf) {
        this.idprf = idprf;
    }

    public String getIdprfdt() {
        return idprfdt;
    }

    public void setIdprfdt(String idprfdt) {
        this.idprfdt = idprfdt;
    }

    public String getIdprfnum() {
        return idprfnum;
    }

    public void setBankEmployeeCode(String bankEmployeeCode) {
        this.idprfnum = formatStringLength(bankEmployeeCode,20);
    }

    public String getIncprf() {
        return incprf;
    }

    public void setIncprf(String incprf) {
        this.incprf = incprf;
    }

    public String getIssueauth() {
        return issueauth;
    }

    public void setIssueauth(String issueauth) {
        this.issueauth = issueauth;
    }

    public String getReasoncd() {
        return reasoncd;
    }

    public void setReasoncd(String reasoncd) {
        this.reasoncd = reasoncd;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPartnerdoc() {
        return partnerdoc;
    }

    public void setPartnerdoc(String partnerdoc) {
        this.partnerdoc = partnerdoc;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getPodoc() {
        return podoc;
    }

    public void setPodoc(String podoc) {
        this.podoc = podoc;
    }

    public String getZkyidexdt() {
        return zkyidexdt;
    }

    public void setZkyidexdt(String zkyidexdt) {
        this.zkyidexdt = zkyidexdt;
    }

    public String getSalutl1() {
        return salutl1;
    }

    public void setSalutl1(String salutl1) {
        this.salutl1 = salutl1;
    }

    public String getSpofname() {
        return spofname;
    }

    public void setSpofname(String spofname) {
        this.spofname = spofname;
    }

    public String getSpolname() {
        return spolname;
    }

    public void setSpolname(String spolname) {
        this.spolname = spolname;
    }

    public String getSpomname() {
        return spomname;
    }

    public void setSpomname(String spomname) {
        this.spomname = spomname;
    }

    public String getMdfname() {
        return mdfname;
    }

    public void setMdfname(String mdfname) {
        this.mdfname = mdfname;
    }

    public String getMdlname() {
        return mdlname;
    }

    public void setMdlname(String mdlname) {
        this.mdlname = mdlname;
    }

    public String getMdmname() {
        return mdmname;
    }

    public void setMdmname(String mdmname) {
        this.mdmname = mdmname;
    }

    public String getMdsalut() {
        return mdsalut;
    }

    public void setMdsalut(String mdsalut) {
        this.mdsalut = mdsalut;
    }

    public String getMofname() {
        return mofname;
    }

    public void setMofname(String mofname) {
        this.mofname = mofname;
    }

    public String getMolname() {
        return molname;
    }

    public void setMolname(String molname) {
        this.molname = molname;
    }

    public String getMomname() {
        return momname;
    }

    public void setMomname(String momname) {
        this.momname = momname;
    }

    public String getMosalut() {
        return mosalut;
    }

    public void setMosalut(String mosalut) {
        this.mosalut = mosalut;
    }

    public String getZckyacty() {
        return zckyacty;
    }

    public void setZckyacty(String zckyacty) {
        this.zckyacty = zckyacty;
    }

    public String getZckyadd_01() {
        return zckyadd_01;
    }

    public void setZckyadd_01(String zckyadd_01) {
        this.zckyadd_01 = zckyadd_01;
    }

    public String getZckyadd_02() {
        return zckyadd_02;
    }

    public void setZckyadd_02(String zckyadd_02) {
        this.zckyadd_02 = zckyadd_02;
    }

    public String getZckyadd_03() {
        return zckyadd_03;
    }

    public void setZckyadd_03(String zckyadd_03) {
        this.zckyadd_03 = zckyadd_03;
    }

    public String getZckyadhen() {
        return zckyadhen;
    }

    public void setZckyadhen(String zckyadhen) {
        this.zckyadhen = zckyadhen;
    }

    public String getZckycity() {
        return zckycity;
    }

    public void setZckycity(String zckycity) {
        this.zckycity = zckycity;
    }

    public String getZckypin() {
        return zckypin;
    }

    public void setZckypin(String zckypin) {
        this.zckypin = zckypin;
    }

    public String getZckycntry() {
        return zckycntry;
    }

    public void setZckycntry(String zckycntry) {
        this.zckycntry = zckycntry;
    }

    public String getZckyfax() {
        return zckyfax;
    }

    public void setZckyfax(String zckyfax) {
        this.zckyfax = zckyfax;
    }

    public String getZckyfrtext() {
        return zckyfrtext;
    }

    public void setZckyfrtext(String zckyfrtext) {
        this.zckyfrtext = zckyfrtext;
    }

    public String getZckyno() {
        return zckyno;
    }

    public void setZckyno(String zckyno) {
        this.zckyno = zckyno;
    }

    public String getZckystate() {
        return zckystate;
    }

    public void setZckystate(String zckystate) {
        this.zckystate = zckystate;
    }

    public String getZkycltmdn() {
        return zkycltmdn;
    }

    public void setZkycltmdn(String zkycltmdn) {
        this.zkycltmdn = zkycltmdn;
    }

    public String getZckyaddrty() {
        return zckyaddrty;
    }

    public void setZckyaddrty(String zckyaddrty) {
        this.zckyaddrty = zckyaddrty;
    }

    public String getZckymarryd() {
        return zckymarryd;
    }

    public void setZckymarryd(String zckymarryd) {
        this.zckymarryd = zckymarryd;
    }

    public String getZckyoccpcd() {
        return zckyoccpcd;
    }

    public void setZckyoccpcd(String zckyoccpcd) {
        this.zckyoccpcd = zckyoccpcd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AgentModifyRequestDTO that = (AgentModifyRequestDTO) o;

        return new EqualsBuilder()
                .append(getAgn_action(),that.getAgn_action())
                .append(getAgntsel(),that.getAgntsel())
                .append(getAgcls(),that.getAgcls())
                .append(getAgntbr(),that.getAgntbr())
                .append(getAgtype(),that.getAgtype())
                .append(getAracde(),that.getAracde())
                .append(getBcmtab(),that.getBcmtab())
                .append(getBctind(),that.getBctind())
                .append(getCurrcode(),that.getCurrcode())
                .append(getDdind(),that.getDdind())
                .append(getDteapp(),that.getDteapp())
                .append(getXopt(),that.getXopt())
                .append(getAgentno(),that.getAgentno())
                .append(getRagtype(),that.getRagtype())
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
                .append(getHseln(),that.getHseln())
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
                .append(getClnt_action(),that.getClnt_action())
                .append(getClttwo(),that.getClttwo())
                .append(getSecuityno1(),that.getSecuityno1())
                .append(getAddrtype(),that.getAddrtype())
                .append(getBirthp(),that.getBirthp())
                .append(getCltaddr01(),that.getCltaddr01())
                .append(getCltaddr02(),that.getCltaddr02())
                .append(getCltaddr03(),that.getCltaddr03())
                .append(getCltaddr04(),that.getCltaddr04())
                .append(getCltaddr05(),that.getCltaddr05())
                .append(getCltdobx(),that.getCltdobx())
                .append(getCltdodx(),that.getCltdodx())
                .append(getCltpcode(),that.getCltpcode())
                .append(getCltphone01(),that.getCltphone01())
                .append(getCltphone02(),that.getCltphone02())
                .append(getCltsex(),that.getCltsex())
                .append(getCtrycode(),that.getCtrycode())
                .append(getDirmail(),that.getDirmail())
                .append(getDocno(),that.getDocno())
                .append(getLanguage(),that.getLanguage())
                .append(getLgivname(),that.getLgivname())
                .append(getLsurname(),that.getLsurname())
                .append(getMailing(),that.getMailing())
                .append(getMarryd(),that.getMarryd())
                .append(getNatlty(),that.getNatlty())
                .append(getNmfmt(),that.getNmfmt())
                .append(getOccpcode(),that.getOccpcode())
                .append(getSalutl(),that.getSalutl())
                .append(getSecuityno(),that.getSecuityno())
                .append(getSfatname(),that.getSfatname())
                .append(getSoe(),that.getSoe())
                .append(getStatcode(),that.getStatcode())
                .append(getTaxflag(),that.getTaxflag())
                .append(getVip(),that.getVip())
                .append(getZdoctind(),that.getZdoctind())
                .append(getZsstate(),that.getZsstate())
                .append(getSfatname(),that.getSfatname())
                .append(getZfreetext(),that.getZfreetext())
                .append(getZckycitz(),that.getZckycitz())
                .append(getFaxno(),that.getFaxno())
                .append(getOldidno(),that.getOldidno())
                .append(getRdidtelno(),that.getRdidtelno())
                .append(getRinternet(),that.getRinternet())
                .append(getRmblphone(),that.getRmblphone())
                .append(getRpager(),that.getRpager())
                .append(getRstaflag(),that.getRstaflag())
                .append(getRtaxidnum(),that.getRtaxidnum())
                .append(getZspecind(),that.getZspecind())
                .append(getZlndmark(),that.getZlndmark())
                .append(getAadhar_number(),that.getAadhar_number())
                .append(getZekyadhen(),that.getZekyadhen())
                .append(getZekyformsx(),that.getZekyformsx())
                .append(getZekyadhrsp(),that.getZekyadhrsp())
                .append(getZckyfatca(),that.getZckyfatca())
                .append(getZckyadd_01(),that.getZckyadd_01())
                .append(getZckyadd_02(),that.getZckyadd_02())
                .append(getZckyadd_03(),that.getZckyadd_03())
                .append(getZckyncity(),that.getZckyncity())
                .append(getZckypin(),that.getZckypin())
                .append(getAddrprf(),that.getAddrprf())
                .append(getClntrskind(),that.getClntrskind())
                .append(getIdprf(),that.getIdprf())
                .append(getIdprfdt(),that.getIdprfdt())
                .append(getIdprfnum(),that.getIdprfnum())
                .append(getIncprf(),that.getIncprf())
                .append(getIssueauth(),that.getIssueauth())
                .append(getReasoncd(),that.getReasoncd())
                .append(getSalary(),that.getSalary())
                .append(getPartnerdoc(),that.getPartnerdoc())
                .append(getEmployee(),that.getEmployee())
                .append(getPodoc(),that.getPodoc())
                .append(getZkyidexdt(),that.getZkyidexdt())
                .append(getSalutl(),that.getSalutl())
                .append(getSpofname(),that.getSpofname())
                .append(getSpolname(),that.getSpolname())
                .append(getSpomname(),that.getSpomname())
                .append(getMdfname(),that.getMdfname())
                .append(getMdlname(),that.getMdlname())
                .append(getMdlname(),that.getMdlname())
                .append(getMdsalut(),that.getMdsalut())
                .append(getMofname(),that.getMofname())
                .append(getMolname(),that.getMolname())
                .append(getMomname(),that.getMomname())
                .append(getMosalut(),that.getMosalut())
                .append(getZckyacty(),that.getZckyacty())
                .append(getZckyadd_01(),that.getZckyadd_01())
                .append(getZckyadd_02(),that.getZckyadd_02())
                .append(getZckyadd_03(),that.getZckyadd_03())
                .append(getZckyadhen(),that.getZckyadhen())
                .append(getZckycity(),that.getZckycity())
                .append(getZckypin(),that.getZckypin())
                .append(getZckyncntry(),that.getZckyncntry())
                .append(getZckyfax(),that.getZckyfax())
                .append(getZckyno(),that.getZckyno())
                .append(getZckystate(),that.getZckystate())
                .append(getZkycltmdn(),that.getZkycltmdn())
                .append(getZckyaddrty(),that.getZckyaddrty())
                .append(getZckymarryd(),that.getZckymarryd())
                .append(getZckyoccpcd(),that.getZckyoccpcd())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getAgn_action())
                .append(getAgntsel())
                .append(getAgcls())
                .append(getAgntbr())
                .append(getAgtype())
                .append(getAracde())
                .append(getBcmtab())
                .append(getBctind())
                .append(getCurrcode())
                .append(getDdind())
                .append(getDteapp())
                .append(getXopt())
                .append(getAgentno())
                .append(getRagtype())
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
                .append(getClnt_action())
                .append(getClttwo())
                .append(getSecuityno1())
                .append(getAddrtype())
                .append(getBirthp())
                .append(getCltaddr01())
                .append(getCltaddr02())
                .append(getCltaddr03())
                .append(getCltaddr04())
                .append(getCltaddr05())
                .append(getCltdobx())
                .append(getCltdodx())
                .append(getCltpcode())
                .append(getCltphone01())
                .append(getCltphone02())
                .append(getCltsex())
                .append(getCtrycode())
                .append(getDirmail())
                .append(getDocno())
                .append(getLanguage())
                .append(getLgivname())
                .append(getLsurname())
                .append(getMailing())
                .append(getMarryd())
                .append(getNatlty())
                .append(getNmfmt())
                .append(getOccpcode())
                .append(getSalutl())
                .append(getSecuityno())
                .append(getSoe())
                .append(getStatcode())
                .append(getTaxflag())
                .append(getVip())
                .append(getZdoctind())
                .append(getZsstate())
                .append(getSfatname())
                .append(getZfreetext())
                .append(getZckycitz())
                .append(getFaxno())
                .append(getOldidno())
                .append(getRdidtelno())
                .append(getRinternet())
                .append(getRmblphone())
                .append(getRpager())
                .append(getRstaflag())
                .append(getRtaxidnum())
                .append(getZspecind())
                .append(getZlndmark())
                .append(getAadhar_number())
                .append(getZekyadhen())
                .append(getZekyformsx())
                .append(getZekyadhrsp())
                .append(getZckyfatca())
                .append(getZckynadd_01())
                .append(getZckynadd_02())
                .append(getZckynadd_03())
                .append(getZckyncity())
                .append(getZckyncntry())
                .append(getZnrifretxt())
                .append(getZckynstate())
                .append(getZckynpin())
                .append(getAddrprf())
                .append(getClntrskind())
                .append(getIdprf())
                .append(getIdprfdt())
                .append(getIdprfnum())
                .append(getIncprf())
                .append(getIssueauth())
                .append(getReasoncd())
                .append(getSalary())
                .append(getPartnerdoc())
                .append(getEmployee())
                .append(getPodoc())
                .append(getZkyidexdt())
                .append(getSalutl1())
                .append(getSpofname())
                .append(getSpolname())
                .append(getSpomname())
                .append(getMdfname())
                .append(getMdlname())
                .append(getMdmname())
                .append(getMdsalut())
                .append(getMofname())
                .append(getMolname())
                .append(getMomname())
                .append(getMosalut())
                .append(getZckyacty())
                .append(getZckyadd_01())
                .append(getZckyadd_02())
                .append(getZckyadd_03())
                .append(getZckyadhen())
                .append(getZckycity())
                .append(getZckypin())
                .append(getZckycntry())
                .append(getZckyfax())
                .append(getZckyfrtext())
                .append(getZckyno())
                .append(getZckystate())
                .append(getZkycltmdn())
                .append(getZckyaddrty())
                .append(getZckymarryd())
                .append(getZckyoccpcd())
                .toHashCode();
    }

    public String toString() {
        return new StringBuilder()
                .append(getAgn_action())
                .append(getAgntsel())
                .append(getAgcls())
                .append(getAgntbr())
                .append(getAgtype())
                .append(getAracde())
                .append(getBcmtab())
                .append(getBctind())
                .append(getCurrcode())
                .append(getDdind())
                .append(getDteapp())
                .append(getXopt())
                .append(getAgentno())
                .append(getRagtype())
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
                .append(getClnt_action())
                .append(getClttwo())
                .append(getSecuityno1())
                .append(getAddrtype())
                .append(getBirthp())
                .append(getCltaddr01())
                .append(getCltaddr02())
                .append(getCltaddr03())
                .append(getCltaddr04())
                .append(getCltaddr05())
                .append(getCltdobx())
                .append(getCltdodx())
                .append(getCltpcode())
                .append(getCltphone01())
                .append(getCltphone02())
                .append(getCltsex())
                .append(getCtrycode())
                .append(getDirmail())
                .append(getDocno())
                .append(getLanguage())
                .append(getLgivname())
                .append(getLsurname())
                .append(getMailing())
                .append(getMarryd())
                .append(getNatlty())
                .append(getNmfmt())
                .append(getOccpcode())
                .append(getSalutl())
                .append(getSecuityno())
                .append(getSoe())
                .append(getStatcode())
                .append(getTaxflag())
                .append(getVip())
                .append(getZdoctind())
                .append(getZsstate())
                .append(getSfatname())
                .append(getZfreetext())
                .append(getZckycitz())
                .append(getFaxno())
                .append(getOldidno())
                .append(getRdidtelno())
                .append(getRinternet())
                .append(getRmblphone())
                .append(getRpager())
                .append(getRstaflag())
                .append(getRtaxidnum())
                .append(getZspecind())
                .append(getZlndmark())
                .append(getAadhar_number())
                .append(getZekyadhen())
                .append(getZekyformsx())
                .append(getZekyadhrsp())
                .append(getZckyfatca())
                .append(getZckynadd_01())
                .append(getZckynadd_02())
                .append(getZckynadd_03())
                .append(getZckyncity())
                .append(getZckyncntry())
                .append(getZnrifretxt())
                .append(getZckynstate())
                .append(getZckynpin())
                .append(getAddrprf())
                .append(getClntrskind())
                .append(getIdprf())
                .append(getIdprfdt())
                .append(getIdprfnum())
                .append(getIncprf())
                .append(getIssueauth())
                .append(getReasoncd())
                .append(getSalary())
                .append(getPartnerdoc())
                .append(getEmployee())
                .append(getPodoc())
                .append(getZkyidexdt())
                .append(getSalutl1())
                .append(getSpofname())
                .append(getSpolname())
                .append(getSpomname())
                .append(getMdfname())
                .append(getMdlname())
                .append(getMdmname())
                .append(getMdsalut())
                .append(getMofname())
                .append(getMolname())
                .append(getMomname())
                .append(getMosalut())
                .append(getZckyacty())
                .append(getZckyadd_01())
                .append(getZckyadd_02())
                .append(getZckyadd_03())
                .append(getZckyadhen())
                .append(getZckycity())
                .append(getZckypin())
                .append(getZckycntry())
                .append(getZckyfax())
                .append(getZckyfrtext())
                .append(getZckyno())
                .append(getZckystate())
                .append(getZkycltmdn())
                .append(getZckyaddrty())
                .append(getZckymarryd())
                .append(getZckyoccpcd())
                .toString();
    }

    public String toJson() {
        return "AgentModifyRequestDTO{" +
                "Agent_action='" + agn_action + '\'' +
                ", agntsel='" + agentCode + '\'' +
                ", agcls='" + agcls + '\'' +
                ", agntbr='" + agentBranch + '\'' +
                ", agtype='" + agentType + '\'' +
                ", aracde='" + areaCode + '\'' +
                ", bcmtab='" + bcmtab + '\'' +
                ", bctind='" + bctind + '\'' +
                ", currcode='" + currcode + '\'' +
                ", ddind='" + ddind + '\'' +
                ", dteapp='" + dateOfAppointment + '\'' +
                ", xopt='" + imTransfer + '\'' +
                ", agentno='" + agentno + '\'' +
                ", ragtype='" + ragtype + '\'' +
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
                ", repsel='" + reportingManager + '\'' +
                ", scmtab='" + scmtab + '\'' +
                ", tagd='" + tagd + '\'' +
                ", tagsusind='" + tagsusind + '\'' +
                ", tlaglicno='" + licenceNumber + '\'' +
                ", tlicexpdt='" + licenceExpiryDate + '\'' +
                ", tlicstrdt='" + licenceStartDate + '\'' +
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
                "Client_action='" + clnt_action + '\'' +
                ", cltiwo='" + clientCode + '\'' +
                ", secuityno1='" + secuityno1 + '\'' +
                ", addrtype='" + addressType + '\'' +
                ", birthp='" + birthp + '\'' +
                ", cltaddr01='" + addressLine01 + '\'' +
                ", cltaddr02='" + addressLine02 + '\'' +
                ", cltaddr03='" + addressLine03 + '\'' +
                ", cltaddr04='" + city + '\'' +
                ", cltaddr05='" + cltaddr05 + '\'' +
                ", cltdobx='" + dateOfBirth + '\'' +
                ", cltdodx='" + cltdodx + '\'' +
                ", cltpcode='" + pinCode + '\'' +
                ", cltphone01='" + phoneNumber01 + '\'' +
                ", cltphone02='" + phoneNumber02 + '\'' +
                ", cltsex='" + gender + '\'' +
                ", ctrycode='" + ctrycode + '\'' +
                ", dirmail='" + dirmail + '\'' +
                ", docno='" + docno + '\'' +
                ", language='" + language + '\'' +
                ", lgivname='" + firstName + '\'' +
                ", lsurname='" + lastName + '\'' +
                ", mailing='" + mailing + '\'' +
                ", marryd='" + maritalStatus + '\'' +
                ", natlty='" + natlty + '\'' +
                ", nmfmt='" + nmfmt + '\'' +
                ", occpcode='" + occpcode + '\'' +
                ", salutl='" + salutation + '\'' +
                ", secuityno='" + secuityno + '\'' +
                ", soe='" + sourceOfEvidence + '\'' +
                ", statcode='" + statcode + '\'' +
                ", taxflag='" + taxflag + '\'' +
                ", vip='" + vip + '\'' +
                ", zdoctind='" + zdoctind + '\'' +
                ", zsstate='" + state + '\'' +
                ", sfatname='" + sfatname + '\'' +
                ", zfreetext='" + zfreetext + '\'' +
                ", zckycitz='" + zckycitz + '\'' +
                ", faxno='" + faxno + '\'' +
                ", oldidno='" + oldidno + '\'' +
                ", rdidtelno='" + rdidtelno + '\'' +
                ", rinternet='" + rinternet + '\'' +
                ", rmblphone='" + rmblphone + '\'' +
                ", rpager='" + rpager + '\'' +
                ", rstaflag='" + rstaflag + '\'' +
                ", rtaxidnum='" + rtaxidnum + '\'' +
                ", zspecind='" + zspecind + '\'' +
                ", zlndmark='" + zlndmark + '\'' +
                ", aadhar_number='" + aadhar_number + '\'' +
                ", zekyadhen='" + zekyadhen + '\'' +
                ", zekyformsx='" + zekyformsx + '\'' +
                ", zekyadhrsp='" + zekyadhrsp + '\'' +
                ", zckyfatca='" + zckyfatca + '\'' +
                ", zckynadd_01='" + zckynadd_01 + '\'' +
                ", zckynadd_02='" + zckynadd_02 + '\'' +
                ", zckynadd_03='" + zckynadd_03 + '\'' +
                ", zckyncity='" + zckyncity + '\'' +
                ", zckyncntry='" + zckyncntry + '\'' +
                ", znrifretxt='" + znrifretxt + '\'' +
                ", zckynstate='" + zckynstate + '\'' +
                ", zckynpin='" + zckynpin + '\'' +
                ", addrprf='" + addressProof + '\'' +
                ", clntrskind='" + clntrskind + '\'' +
                ", idprf='" + idprf + '\'' +
                ", idprfdt='" + idprfdt + '\'' +
                ", idprfnum='" + idprfnum + '\'' +
                ", incprf='" + incprf + '\'' +
                ", issueauth='" + issueauth + '\'' +
                ", reasoncd='" + reasoncd + '\'' +
                ", salary='" + salary + '\'' +
                ", partnerdoc='" + partnerdoc + '\'' +
                ", employee='" + employee + '\'' +
                ", podoc='" + podoc + '\'' +
                ", zkyidexdt='" + zkyidexdt + '\'' +
                ", salutl1='" + salutl1 + '\'' +
                ", spofname='" + spofname + '\'' +
                ", spolname='" + spolname + '\'' +
                ", spomname='" + spomname + '\'' +
                ", mdfname='" + mdfname + '\'' +
                ", mdlname='" + mdlname + '\'' +
                ", mdmname='" + mdmname + '\'' +
                ", mdsalut='" + mdsalut + '\'' +
                ", mofname='" + mofname + '\'' +
                ", molname='" + molname + '\'' +
                ", momname='" + momname + '\'' +
                ", mosalut='" + mosalut + '\'' +
                ", zckyacty='" + zckyacty + '\'' +
                ", zckyadd_01='" + zckyadd_01 + '\'' +
                ", zckyadd_02='" + zckyadd_02 + '\'' +
                ", zckyadd_03='" + zckyadd_03 + '\'' +
                ", zckyadhen='" + zckyadhen + '\'' +
                ", zckycity='" + zckycity + '\'' +
                ", zckypin='" + zckypin + '\'' +
                ", zckycntry='" + zckycntry + '\'' +
                ", zckyfax='" + zckyfax + '\'' +
                ", zckyfrtext='" + zckyfrtext + '\'' +
                ", zckyno='" + zckyno + '\'' +
                ", zckystate='" + zckystate + '\'' +
                ", zkycltmdn='" + zkycltmdn + '\'' +
                ", zckyaddrty='" + zckyaddrty + '\'' +
                ", zckymarryd='" + zckymarryd + '\'' +
                ", zckyoccpcd='" + zckyoccpcd + '\'' +
                '}';
    }

    public String dateformatter() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDateTime localDateTime = LocalDateTime.now();//.minusDays(4l);
        String date = dtf.format(localDateTime);
        return date;
    }

    private String formatStringLength(String string, int length) {
        return StringUtils.rightPad(string,length);
    }

    private String formatStringLengthPadLeft(String string, int length) {
        return StringUtils.leftPad(string,length,'0');
    }
}
