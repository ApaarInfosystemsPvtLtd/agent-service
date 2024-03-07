package com.pmli.lifeasia.translator.model.client;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "ClientCRPRequest")
public class ClientCRPMessageBodyRequestDTO
{
    private String 	clnt_action=" ";
    private String 	cltdobx="        ";
    private String 	cltpcode="          ";
    private String 	clientphone="                ";
    private String 	confirm="Y"; //Default "Y".
    private String 	lgivname="                                                            ";
    private String 	lsurname="                                                            ";
    private String 	ortaxidnum="          ";
    private String 	clntfthr="                                                            ";
    private String 	addrtype=" ";
    private String 	birthp="                    ";
    private String 	cltaddr01="                              ";
    private String 	cltaddr02="                              ";
    private String 	cltaddr03="                              ";
    private String 	cltaddr04="                              ";
    private String 	cltaddr05="                              ";
    private String 	cltdobx1="        ";
    private String 	cltdodx="99999999";//Default "99999999".
    private String 	cltpcode1="          ";
    private String 	cltphone01="                ";
    private String 	cltphone02="                ";
    private String 	cltsex=" ";
    private String 	ctrycode="IN ";//Default "IN "
    private String 	dirmail=" ";
    private String 	docno="        ";
    private String 	language=" ";
    private String 	lgivname1="                                                            ";
    private String 	lsurname1="                                                            ";
    private String 	mailing=" ";
    private String 	marryd=" ";
    private String 	natlty="01 ";//Default "01 ".
    private String 	nmfmt=" ";
    private String 	occpcode="    ";//Default "SELF"
    private String 	salutl="        ";
    private String 	secuityno="                        ";
    private String 	soe="          ";
    private String 	statcode="  ";
    private String 	taxflag=" ";
    private String 	vip=" ";
    private String 	zdoctind="N";//Default "Y"
    private String 	zsstate="    ";
    private String 	sfatname="                                                            ";
    private String 	zfreetext="                                                  ";
    private String 	zckycitz="   ";
    private String 	addrprf="        ";
    private String 	clntrskind="1";//Default "1"
    private String 	idprf="        ";
    private String 	idprfdt="99999999";// Default "99999999"
    private String 	idprfnum="                    ";
    private String 	incprf="        ";
    private String 	issueauth="                              ";
    private String 	reasoncd="    ";
    private String 	salary="00000000000";//Default "00000000000"
    private String 	partnerdoc="        ";
    private String 	employee="        ";
    private String 	podoc="        ";
    private String 	pepflag=" ";
    private String 	pepdate="99999999";//Default "99999999"
    private String 	zkyidexdt="99999999";//Default "99999999"
    private String 	salutl1="        ";
    private String 	spofname="                                                  ";
    private String 	spolname="                                                  ";
    private String 	spomname="                                                  ";
    private String 	faxno="                ";
    private String 	oldidno="                        ";
    private String 	rdidtelno="                ";
    private String 	rinternet="                                                  ";
    private String 	rmblphone="                ";//Default "9999999999"
    private String 	rpager="                ";//Default "9999999999"
    private String 	rstaflag="  ";
    private String 	rtaxidnum="          ";
    private String 	zspecind="  ";
    private String 	zlndmark="                                   ";
    private String 	aadhar_number="              ";//1ST MISTAKE
    private String 	zekyadhen="              ";
    private String 	zekyformsx=" ";
    private String 	zekyadhrsp=" ";
    private String 	zckyfatca=" ";
    private String 	zckynadd_01="                                                       ";
    private String 	zckynadd_02="                                                       ";
    private String 	zckynadd_03="                                                       ";
    private String 	zckyncity="                                                  ";
    private String 	zckyncntry="   ";
    private String 	znrifretxt="                                                  ";
    private String 	zckynstate="                                                  ";
    private String 	zckynpin="      ";
    private String 	mdfname="                                                  ";
    private String 	mdlname="                                                  ";
    private String 	mdmname="                                                  ";
    private String 	mdsalut="      ";
    private String 	mofname="                                                  ";
    private String 	molname="                                                  ";
    private String 	momname="                                                  ";
    private String 	mosalut="      ";
    private String 	zckyacty="  ";
    private String 	zckyadd_01="                                                       ";
    private String 	zckyadd_02="                                                       ";
    private String 	zckyadd_03="                                                       ";
    private String 	zckycity="                                                  ";
    private String 	zckypin="      ";
    private String 	zckycntry="   ";
    private String 	zckyfax="            ";
    private String 	zckyfrtext="                                                  ";
    private String 	zckyno="              ";
    private String 	zckystate="                                                  ";
    private String 	zkycltmdn="                                                  ";
    private String 	zckyaddrty=" ";
    private String 	zckymarryd=" ";
    private String 	zckyoccpcd="    ";
    private String  requestId="";
    @JsonFormat
    private String  timeStamp= LocalDateTime.now().toString();
    private String  status="Received";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getAction() {
        return clnt_action;
    }

    public void setAction(String clnt_action) {
        this.clnt_action = clnt_action;
    }

    public String getCltdobx() {
        return cltdobx;
    }

    public void setCltdobx(String cltdobx) {
        this.cltdobx = cltdobx;
        this.cltdobx1 = cltdobx;
    }

    public String getCltpcode() {
        return cltpcode;
    }

    public void setCltpcode(String cltpcode) {
        this.cltpcode = cltpcode;
        this.cltpcode1 =cltpcode;
    }

    public String getClientphone() {
        return clientphone;
    }

    public void setClientphone(String clientphone) {
        this.clientphone = clientphone;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getLgivname() {
        return lgivname;
    }

    public void setLgivname(String lgivname) {
        this.lgivname = lgivname;
        this.lgivname1=lgivname;
    }

    public String getLsurname() {
        return lsurname;
    }

    public void setLsurname(String lsurname) {
        this.lsurname = lsurname;
        this.lgivname1= lsurname;
    }

    public String getOrtaxidnum() {
        return ortaxidnum;
    }

    public void setOrtaxidnum(String ortaxidnum) {
        this.ortaxidnum = ortaxidnum;
    }

    public String getClntfthr() {
        return clntfthr;
    }

    public void setClntfthr(String clntfthr) {
        this.clntfthr = clntfthr;
    }

    public String getAddrtype() {
        return addrtype;
    }

    public void setAddrtype(String addrtype) {
        this.addrtype = addrtype;
    }

    public String getBirthp() {
        return birthp;
    }

    public void setBirthp(String birthp) {
        this.birthp = birthp;
    }

    public String getCltaddr01() {
        return cltaddr01;
    }

    public void setCltaddr01(String cltaddr01) {
        this.cltaddr01 = cltaddr01;
    }

    public String getCltaddr02() {
        return cltaddr02;
    }

    public void setCltaddr02(String cltaddr02) {
        this.cltaddr02 = cltaddr02;
    }

    public String getCltaddr03() {
        return cltaddr03;
    }

    public void setCltaddr03(String cltaddr03) {
        this.cltaddr03 = cltaddr03;
    }

    public String getCltaddr04() {
        return cltaddr04;
    }

    public void setCltaddr04(String cltaddr04) {
        this.cltaddr04 = cltaddr04;
    }

    public String getCltaddr05() {
        return cltaddr05;
    }

    public void setCltaddr05(String cltaddr05) {
        this.cltaddr05 = cltaddr05;
    }

    public String getCltdobx1() {
        return cltdobx1;
    }

    public void setCltdobx1() {
    }

    public String getCltdodx() {
        return cltdodx;
    }

    public void setCltdodx(String cltdodx) {
        this.cltdodx = cltdodx;
    }

    public String getCltpcode1() {
        return cltpcode1;
    }

    public void setCltpcode1() {
    }

    public String getCltphone01() {
        return cltphone01;
    }

    public void setCltphone01(String cltphone01) {
        this.cltphone01 = cltphone01;
    }

    public String getCltphone02() {
        return cltphone02;
    }

    public void setCltphone02(String cltphone02) {
        this.cltphone02 = cltphone02;
    }

    public String getCltsex() {
        return cltsex;
    }

    public void setCltsex(String cltsex) {
        this.cltsex = cltsex;
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

    public String getLgivname1() {
        return lgivname1;
    }

    public void setLgivname1() {
    }

    public String getLsurname1() {
        return lsurname1;
    }

    public void setLsurname1() {
    }

    public String getMailing() {
        return mailing;
    }

    public void setMailing(String mailing) {
        this.mailing = mailing;
    }

    public String getMarryd() {
        return marryd;
    }

    public void setMarryd(String marryd) {
        this.marryd = marryd;
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
        return salutl;
    }

    public void setSalutl(String salutl) {
        this.salutl = salutl;
    }

    public String getSecuityno() {
        return secuityno;
    }

    public void setSecuityno(String secuityno) {
        this.secuityno = secuityno;
    }

    public String getSoe() {
        return soe;
    }

    public void setSoe(String soe) {
        this.soe = soe;
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
        return zsstate;
    }

    public void setZsstate(String zsstate) {
        this.zsstate = zsstate;
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

    public String getAddrprf() {
        return addrprf;
    }

    public void setAddrprf(String addrprf) {
        this.addrprf = addrprf;
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

    public void setIdprfnum(String idprfnum) {
        this.idprfnum = idprfnum;
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

    public void setspolname(String spolname) {
        this.spolname = spolname;
    }

    public String getSpomname() {
        return spomname;
    }

    public void setSpomname(String spomname) {
        this.spomname = spomname;
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
        this.rinternet = rinternet;
    }

    public String getRmblphone() {
        return rmblphone;
    }

    public void setRmblphone(String rmblphone) {
        this.rmblphone = rmblphone;
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
        this.aadhar_number = aadhar_number;
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

        ClientCRPMessageBodyRequestDTO that = (ClientCRPMessageBodyRequestDTO) o;

        return new EqualsBuilder()
                .append(getAction(),that.getAction())
                .append(getCltdobx(),that.getCltdobx())
                .append(getCltpcode(),that.getCltpcode())
                .append(getClientphone(),that.getClientphone())
                .append(getConfirm(),that.getConfirm())
                .append(getLgivname(),that.getLgivname())
                .append(getLsurname(),that.getLsurname())
                .append(getOrtaxidnum(),that.getOrtaxidnum())
                .append(getClntfthr(),that.getClntfthr())
                .append(getAddrtype(),that.getAddrtype())
                .append(getBirthp(),that.getBirthp())
                .append(getCltaddr01(),that.getCltaddr01())
                .append(getCltaddr02(),that.getCltaddr02())
                .append(getCltaddr03(),that.getCltaddr03())
                .append(getCltaddr04(),that.getCltaddr04())
                .append(getCltaddr05(),that.getCltaddr05())
                .append(getCltdobx1(),that.getCltdobx1())
                .append(getCltdodx(),that.getCltdodx())
                .append(getCltpcode1(),that.getCltpcode1())
                .append(getCltphone01(),that.getCltphone01())
                .append(getCltphone02(),that.getCltphone02())
                .append(getCltsex(),that.getCltsex())
                .append(getCtrycode(),that.getCtrycode())
                .append(getDirmail(),that.getDirmail())
                .append(getDocno(),that.getDocno())
                .append(getLanguage(),that.getLanguage())
                .append(getLgivname1(),that.getLgivname1())
                .append(getLsurname1(),that.getLsurname1())
                .append(getMailing(),that.getMailing())
                .append(getMarryd(),that.getMarryd())
                .append(getNatlty(),that.getNatlty())
                .append(getNmfmt(),that.getNmfmt())
                .append(getOccpcode(),that.getOccpcode())
                .append(getSalutl(),that.getSalutl())
                .append(getSecuityno(),that.getSecuityno())
                .append(getSoe(),that.getSoe())
                .append(getStatcode(),that.getStatcode())
                .append(getTaxflag(),that.getTaxflag())
                .append(getVip(),that.getVip())
                .append(getZdoctind(),that.getZdoctind())
                .append(getZsstate(),that.getZsstate())
                .append(getSfatname(),that.getSfatname())
                .append(getZfreetext(),that.getZfreetext())
                .append(getZckycitz(),that.getZckycitz())
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
                .append(getPepflag(),that.getPepflag())
                .append(getPepdate(),that.getPepdate())
                .append(getZkyidexdt(),that.getZkyidexdt())
                .append(getSalutl1(),that.getSalutl1())
                .append(getSpofname(),that.getSpofname())
                .append(getSpolname(),that.getSpolname())
                .append(getSpomname(),that.getSpomname())
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
                .append(getZckynadd_01(),that.getZckynadd_01())
                .append(getZckynadd_02(),that.getZckynadd_02())
                .append(getZckynadd_03(),that.getZckynadd_03())
                .append(getZckyncity(),that.getZckyncity())
                .append(getZckyncntry(),that.getZckyncntry())
                .append(getZnrifretxt(),that.getZnrifretxt())
                .append(getZckystate(),that.getZckystate())
                .append(getZckypin(),that.getZckypin())
                .append(getMdfname(),that.getMdfname())
                .append(getMdlname(),that.getMdlname())
                .append(getMdmname(),that.getMdmname())
                .append(getMdsalut(),that.getMdsalut())
                .append(getMofname(),that.getMofname())
                .append(getMolname(),that.getMolname())
                .append(getMomname(),that.getMomname())
                .append(getMosalut(),that.getMosalut())
                .append(getZckyacty(),that.getZckyacty())
                .append(getZckyadd_01(),that.getZckyadd_01())
                .append(getZckyadd_02(),that.getZckyadd_02())
                .append(getZckyadd_03(),that.getZckyadd_03())
                .append(getZckycity(),that.getZckycity())
                .append(getZckypin(),that.getZckypin())
                .append(getZckycntry(),that.getZckycntry())
                .append(getZckyfax(),that.getZckyfax())
                .append(getZckyfrtext(),that.getZckyfrtext())
                .append(getZckyno(),that.getZckyno())
                .append(getZckystate(),that.getZckystate())
                .append(getZkycltmdn(),that.getZkycltmdn())
                .append(getZckyaddrty(),that.getZckyaddrty())
                .append(getZckymarryd(),that.getZckymarryd())
                .append(getZckyoccpcd(),that.getZckyoccpcd())
                .append(getRequestId(),that.getRequestId())
                .append(getTimeStamp(),that.getTimeStamp())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getAction())
                .append(getCltdobx())
                .append(getCltpcode())
                .append(getClientphone())
                .append(getConfirm())
                .append(getLgivname())
                .append(getLsurname())
                .append(getOrtaxidnum())
                .append(getClntfthr())
                .append(getAddrtype())
                .append(getBirthp())
                .append(getCltaddr01())
                .append(getCltaddr02())
                .append(getCltaddr03())
                .append(getCltaddr04())
                .append(getCltaddr05())
                .append(getCltdobx1())
                .append(getCltdodx())
                .append(getCltpcode1())
                .append(getCltphone01())
                .append(getCltphone02())
                .append(getCltsex())
                .append(getCtrycode())
                .append(getDirmail())
                .append(getDocno())
                .append(getLanguage())
                .append(getLgivname1())
                .append(getLsurname1())
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
                .append(getPepflag())
                .append(getPepdate())
                .append(getZkyidexdt())
                .append(getSalutl1())
                .append(getSpofname())
                .append(getSpolname())
                .append(getSpomname())
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
                .append(getZckystate())
                .append(getZckypin())
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
                .append(getZckycity())
                .append(getZckypin())
                .append(getZckycntry())
                .append(getZckyfax())
                .append(getZckyfrtext())//2nd mistake
                .append(getZckyno())
                .append(getZckystate())
                .append(getZkycltmdn())
                .append(getZckyaddrty())
                .append(getZckymarryd())
                .append(getZckyoccpcd())
                .append(getRequestId())
                .append(getTimeStamp())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(getAction())
                .append(getCltdobx())
                .append(getCltpcode())
                .append(getClientphone())
                .append(getConfirm())
                .append(getLgivname())
                .append(getLsurname())
                .append(getOrtaxidnum())
                .append(getClntfthr())
                .append(getAddrtype())
                .append(getBirthp())
                .append(getCltaddr01())
                .append(getCltaddr02())
                .append(getCltaddr03())
                .append(getCltaddr04())
                .append(getCltaddr05())
                .append(getCltdobx1())
                .append(getCltdodx())
                .append(getCltpcode1())
                .append(getCltphone01())
                .append(getCltphone02())
                .append(getCltsex())
                .append(getCtrycode())
                .append(getDirmail())
                .append(getDocno())
                .append(getLanguage())
                .append(getLgivname1())
                .append(getLsurname1())
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
                .append(getPepflag())
                .append(getPepdate())
                .append(getZkyidexdt())
                .append(getSalutl1())
                .append(getSpofname())
                .append(getSpolname())
                .append(getSpomname())
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
                .append(getZckystate())
                .append(getZckypin())
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
                .append(getRequestId())
                .append(getTimeStamp())
                .toString();
    }

    public String toJson() {
        return "ClientCRPMessageBodyRequest{" +
                "action='" + clnt_action + '\'' +
                ", cltdobx='" + cltdobx + '\'' +
                ", cltpcode='" + cltpcode + '\'' +
                ", clientphone='" + clientphone + '\'' +
                ", confirm='" + confirm + '\'' +
                ", lgivname='" + lgivname + '\'' +
                ", lsurname='" + lsurname + '\'' +
                ", ortaxidnum='" + ortaxidnum + '\'' +
                ", clntfthr='" + clntfthr + '\'' +
                ", addrtype='" + addrtype + '\'' +
                ", birthp='" + birthp + '\'' +
                ", cltaddr01='" + cltaddr01 + '\'' +
                ", cltaddr02='" + cltaddr02 + '\'' +
                ", cltaddr03='" + cltaddr03 + '\'' +
                ", cltaddr04='" + cltaddr04 + '\'' +
                ", cltaddr05='" + cltaddr05 + '\'' +
                ", cltdobx1='" + cltdobx1 + '\'' +
                ", cltdodx='" + cltdodx + '\'' +
                ", cltpcode1='" + cltpcode1 + '\'' +
                ", cltphone01='" + cltphone01 + '\'' +
                ", cltphone02='" + cltphone02 + '\'' +
                ", cltsex='" + cltsex + '\'' +
                ", ctrycode='" + ctrycode + '\'' +
                ", dirmail='" + dirmail + '\'' +
                ", docno='" + docno + '\'' +
                ", language='" + language + '\'' +
                ", lgivname1='" + lgivname1 + '\'' +
                ", lsurname1='" + lsurname1 + '\'' +
                ", mailing='" + mailing + '\'' +
                ", marryd='" + marryd + '\'' +
                ", natlty='" + natlty + '\'' +
                ", nmfmt='" + nmfmt + '\'' +
                ", occpcode='" + occpcode + '\'' +
                ", salutl='" + salutl + '\'' +
                ", secuityno='" + secuityno + '\'' +
                ", soe='" + soe + '\'' +
                ", statcode='" + statcode + '\'' +
                ", taxflag='" + taxflag + '\'' +
                ", vip='" + vip + '\'' +
                ", zdoctind='" + zdoctind + '\'' +
                ", zsstate='" + zsstate + '\'' +
                ", sfatname='" + sfatname + '\'' +
                ", zfreetext='" + zfreetext + '\'' +
                ", zckycitz='" + zckycitz + '\'' +
                ", addrprf='" + addrprf + '\'' +
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
                ", pepflag='" + pepflag + '\'' +
                ", pepdate='" + pepdate + '\'' +
                ", zkyidexdt='" + zkyidexdt + '\'' +
                ", salutl1='" + salutl1 + '\'' +
                ", spofname='" + spofname + '\'' +
                ", spolname='" + spolname + '\'' +
                ", spomname='" + spomname + '\'' +
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
                ", requestId='" + requestId + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
