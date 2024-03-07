package com.pmli.lifeasia.translator.model.agent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;


public class CreateRequestDTO {
    private String agentCode = "          ";// Length=10
    private String reportingManager = "          ";         // Length=10
    private String branchCode = "10";                     // Length=2
    private AgentName agentName = new AgentName();
    private String maritalStatus = " ";                      // Length=1
    private MailingAddress mailingAddress = new MailingAddress();
    private String dateOfAppointment = "        ";         // Length=10 (eg:-"2019-12-01")
    private String licenseIssuanceDate = "        ";       // Length=10 (eg:-"2019-12-01")
    private String expiryDate = "        ";                // Length=10 (eg:-"2049-12-01")
    private String dateOfBirth = "        ";                 // Length=8 (eg:-"1994-01-21")
    private String evidence = "PAN";                  // Length=10
    private String agentType = "  ";                         // Length=2
    private String addressProof = "";
    private String gender = "";
    private String unitCode = "";
    private String accountPayee = "          ";        //length=10
    private String certificateNumber = "               ";
    private String bankEmployeeCode = "                        ";
    private String minimumCommissionAmount = "00000000000000000";
    private String allowCommissionPayment = " ";
    private String taxCode = "  ";
    private FatherName fatherName = new FatherName();
    private String aadharNumber = "              ";
    private String emailAddress = "                                                  ";
    private String taxProofNumber = "          ";

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getReportingManager() {
        return reportingManager;
    }

    public void setReportingManager(String reportingManager) {
        this.reportingManager = reportingManager;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public AgentName getAgentName() {
        return agentName;
    }

    public void setAgentName(AgentName agentName) {
        this.agentName = agentName;
    }

    public MailingAddress getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(MailingAddress mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(String dateOfAppointment) {
        this.dateOfAppointment = FormatString(dateOfAppointment);
    }

    public String getLicenseIssuanceDate() {
        return licenseIssuanceDate;
    }

    public void setLicenseIssuanceDate(String licenseIssuanceDate) {
        this.licenseIssuanceDate = FormatString(licenseIssuanceDate);
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = FormatString(expiryDate);
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = FormatString(dateOfBirth);
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public String getAgentType() {
        return agentType;
    }

    public void setAgentType(String agentType) {
        this.agentType = agentType;
    }

    public String getAddressProof() {
        return addressProof;
    }

    public void setAddressProof(String addressProof) {
        this.addressProof = addressProof;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAccountPayee() {
        return accountPayee;
    }

    public void setAccountPayee(String accountPayee) {
        this.accountPayee = accountPayee;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getBankEmployeeCode() {
        return bankEmployeeCode;
    }

    public void setBankEmployeeCode(String bankEmployeeCode) {
        this.bankEmployeeCode = bankEmployeeCode;
    }

    public String getMinimumCommissionAmount() {
        return minimumCommissionAmount;
    }

    public void setMinimumCommissionAmount(String minimumCommissionAmount) {
        this.minimumCommissionAmount = minimumCommissionAmount;
    }

    public String getAllowCommissionPayment() {
        return allowCommissionPayment;
    }

    public void setAllowCommissionPayment(String allowCommissionPayment) {
        this.allowCommissionPayment = allowCommissionPayment;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public FatherName getFatherName() {
        return fatherName;
    }

    public void setFatherName(FatherName fatherName) {
        this.fatherName = fatherName;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTaxProofNumber() {
        return taxProofNumber;
    }

    public void setTaxProofNumber(String taxProofNumber) {
        this.taxProofNumber = taxProofNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CreateRequestDTO that = (CreateRequestDTO) o;

        return new EqualsBuilder()
                .append(agentCode, that.agentCode)
                .append(reportingManager, that.reportingManager)
                .append(branchCode, that.branchCode)
                .append(agentName, that.agentName)
                .append(maritalStatus, that.maritalStatus)
                .append(mailingAddress, that.mailingAddress)
                .append(dateOfAppointment, that.dateOfAppointment)
                .append(licenseIssuanceDate, that.licenseIssuanceDate)
                .append(expiryDate, that.expiryDate)
                .append(dateOfBirth, that.dateOfBirth)
                .append(evidence, that.evidence)
                .append(agentType, that.agentType)
                .append(addressProof, that.addressProof)
                .append(gender, that.gender)
                .append(unitCode, that.unitCode)
                .append(accountPayee, that.accountPayee)
                .append(certificateNumber, that.certificateNumber)
                .append(bankEmployeeCode, that.bankEmployeeCode)
                .append(minimumCommissionAmount, that.minimumCommissionAmount)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(agentCode)
                .append(reportingManager)
                .append(branchCode)
                .append(agentName)
                .append(maritalStatus)
                .append(mailingAddress)
                .append(dateOfAppointment)
                .append(licenseIssuanceDate)
                .append(expiryDate)
                .append(dateOfBirth)
                .append(evidence)
                .append(agentType)
                .append(addressProof)
                .append(gender)
                .append(unitCode)
                .append(accountPayee)
                .append(certificateNumber)
                .append(bankEmployeeCode)
                .append(minimumCommissionAmount)
                .toHashCode();
    }


    public String toString() {
        return new StringBuilder()
                .append(getAgentCode())
                .append(getReportingManager())
                .append(getBranchCode())
                .append(getAgentName().toString())
                .append(getMailingAddress().toString())
                .append(getMaritalStatus())
                .append(getDateOfAppointment())
                .append(getLicenseIssuanceDate())
                .append(getExpiryDate())
                .append(getDateOfBirth())
                .append(getEvidence())
                .append(getAgentType())
                .append(getAddressProof())
                .append(getGender())
                .append(getUnitCode())
                .append(getAccountPayee())
                .append(getCertificateNumber())
                .append(getBankEmployeeCode())
                .append(getMinimumCommissionAmount())
                .toString();
    }


    public String toJson() {
        return "CreateRequestDTO{" +
                "agentCode='" + agentCode + '\'' +
                ", reportingManager='" + reportingManager + '\'' +
                ", branchCode='" + branchCode + '\'' +
                ", agentName=" + agentName +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", mailingAddress=" + mailingAddress +
                ", dateOfAppointment='" + dateOfAppointment + '\'' +
                ", licenseIssuanceDate='" + licenseIssuanceDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", evidence='" + evidence + '\'' +
                ", agentType='" + agentType + '\'' +
                ", addressProof='" + addressProof + '\'' +
                ", gender='" + gender + '\'' +
                ", unitCode='" + unitCode + '\'' +
                ", accountPayee='" + accountPayee + '\'' +
                ", certificateNumber='" + certificateNumber + '\'' +
                ", bankEmployeeCode='" + bankEmployeeCode + '\'' +
                ", minimumCommissionAmount='" + minimumCommissionAmount + '\'' +
                '}';
    }

    private String FormatString(String message) {
        return message.replace("-", "");
    }
}
