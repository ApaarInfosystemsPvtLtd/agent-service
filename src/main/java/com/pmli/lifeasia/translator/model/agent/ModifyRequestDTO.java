package com.pmli.lifeasia.translator.model.agent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class ModifyRequestDTO
{
    private String clientCode="          ";
    private String agentCode ="          ";// Length=10
    private String reportingManager="          ";         // Length=10
    private String branchCode ="10";                     // Length=2
    private AgentName agentName = new AgentName();
    private MailingAddress mailingAddress = new MailingAddress();
    private String maritalStatus=" ";                      // Length=1
    private String dateOfAppointment="        ";         // Length=8 (eg:-"2019-12-01")
    private String dateOfTermination ="99999999";             // Length=8.
    private String certificateNumber ="               ";         // Length=15.
    private String licenseIssuanceDate="        ";       // Length=10 (eg:-"2019-12-01")
    private String expiryDate="        ";                // Length=10 (eg:-"2049-12-01")
    private String dateOfBirth="        ";                 // Length=8 (eg:-"94-01-21")
    private String evidence="PAN";                  // Length=10
    private String agentStatus="LICE";              // Length=4
    private String agentType="  ";                         // Length=2
    private String addressProof="";
    private String gender="";
    private String unitCode="";
    private String accountPayee="          ";        //length=10
    private String bankEmployeeCode="                        ";
    private String minimumCommissionAmount="00000000000000000";
    private String allowCommissionPayment=" ";
    private String taxCode="  ";
    //private FatherName fatherName = new FatherName();
    private String aadharNumber="              ";
    private String 	emailAddress="                                                  ";
    private String 	taxProofNumber="          ";

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

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

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String licenceNumber) {
        this.certificateNumber = licenceNumber;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getDateOfTermination() {
        return dateOfTermination;
    }

    public void setDateOfTermination(String dateOfTermination) {
        this.dateOfTermination = FormatString(dateOfTermination);
    }

    public String getAgentStatus() {
        return agentStatus;
    }

    public void setAgentStatus(String agentStatus) {
        this.agentStatus = agentStatus;
    }

    public String getAccountPayee() {
        return accountPayee;
    }

    public void setAccountPayee(String accountPayee) {
        this.accountPayee = accountPayee;
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

    /*public FatherName getFatherName() {
        return fatherName;
    }

    public void setFatherName(FatherName fatherName) {
        this.fatherName = fatherName;
    }*/

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

        if (!(o instanceof ModifyRequestDTO)) return false;

        ModifyRequestDTO that = (ModifyRequestDTO) o;

        return new EqualsBuilder()
                .append(getClientCode(), that.getClientCode())
                .append(getAgentCode(), that.getAgentCode())
                .append(getReportingManager(), that.getReportingManager())
                .append(getBranchCode(), that.getBranchCode())
                .append(getAgentName(), that.getAgentName())
                .append(getMailingAddress(), that.getMailingAddress())
                .append(getMaritalStatus(), that.getMaritalStatus())
                .append(getDateOfAppointment(), that.getDateOfAppointment())
                .append(getDateOfTermination(), that.getDateOfTermination())
                .append(getCertificateNumber(),that.getCertificateNumber())
                .append(getLicenseIssuanceDate(), that.getLicenseIssuanceDate())
                .append(getExpiryDate(), that.getExpiryDate())
                .append(getDateOfBirth(), that.getDateOfBirth())
                .append(getEvidence(), that.getEvidence())
                .append(getAgentStatus(), that.getAgentStatus())
                .append(getAgentType(), that.getAgentType())
                .append(getAddressProof(), that.getAddressProof())
                .append(getGender(), that.getGender())
                .append(getUnitCode(), that.getUnitCode())
                .append(getAccountPayee(), that.getAccountPayee())
                .append(getBankEmployeeCode(), that.getBankEmployeeCode())
                .append(getMinimumCommissionAmount(), that.getMinimumCommissionAmount())
                .append(getAllowCommissionPayment(), that.getAllowCommissionPayment())
                .append(getTaxCode(), that.getTaxCode())
                .append(getAadharNumber(), that.getAadharNumber())
                .append(getEmailAddress(), that.getEmailAddress())
                .append(getTaxProofNumber(), that.getTaxProofNumber())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getClientCode())
                .append(getAgentCode())
                .append(getReportingManager())
                .append(getBranchCode())
                .append(getAgentName())
                .append(getMailingAddress())
                .append(getMaritalStatus())
                .append(getDateOfAppointment())
                .append(getDateOfTermination())
                .append(getCertificateNumber())
                .append(getLicenseIssuanceDate())
                .append(getExpiryDate())
                .append(getDateOfBirth())
                .append(getEvidence())
                .append(getAgentStatus())
                .append(getAgentType())
                .append(getAddressProof())
                .append(getGender())
                .append(getUnitCode())
                .append(getAccountPayee())
                .append(getBankEmployeeCode())
                .append(getMinimumCommissionAmount())
                .append(getAllowCommissionPayment())
                .append(getTaxCode())
                .append(getAadharNumber())
                .append(getEmailAddress())
                .append(getTaxProofNumber())
                .toHashCode();
    }

    public String toString() {
        return new StringBuilder()
                .append(getClientCode())
                .append(getAgentCode())
                .append(getReportingManager())
                .append(getBranchCode())
                .append(getAgentName())
                .append(getMailingAddress())
                .append(getMaritalStatus())
                .append(getDateOfAppointment())
                .append(getDateOfTermination())
                .append(getCertificateNumber())
                .append(getLicenseIssuanceDate())
                .append(getExpiryDate())
                .append(getDateOfBirth())
                .append(getEvidence())
                .append(getAgentStatus())
                .append(getAgentType())
                .append(getAddressProof())
                .append(getGender())
                .append(getUnitCode())
                .append(getAccountPayee())
                .append(getBankEmployeeCode())
                .append(getMinimumCommissionAmount())
                .append(getAllowCommissionPayment())
                .append(getTaxCode())
                .append(getAadharNumber())
                .append(getEmailAddress())
                .append(getTaxProofNumber())
                .toString();
    }

    public String toJson() {
        return "ModifyRequestDTO{" +
                "clientCode='" + clientCode + '\'' +
                ", agentCode='" + agentCode + '\'' +
                ", reportingManager='" + reportingManager + '\'' +
                ", branchCode='" + branchCode + '\'' +
                ", agentName=" + agentName +
                ", mailingAddress=" + mailingAddress +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", dateOfAppointment='" + dateOfAppointment + '\'' +
                ", dateOfTermination='" + dateOfTermination + '\'' +
                ", licenseNumber='" + certificateNumber + '\'' +
                ", licenseIssuanceDate='" + licenseIssuanceDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", evidence='" + evidence + '\'' +
                ", agentStatus='" + agentStatus + '\'' +
                ", agentType='" + agentType + '\'' +
                ", addressProof='" + addressProof + '\'' +
                ", gender='" + gender + '\'' +
                ", unitCode='" + unitCode + '\'' +
                ", accountPayee='" + accountPayee + '\'' +
                ", bankEmployeeCode='" + bankEmployeeCode + '\'' +
                ", minimumCommissionAmount='" + minimumCommissionAmount + '\'' +
                ", allowCommissionPayment='" + allowCommissionPayment + '\'' +
                ", taxCode='" + taxCode + '\'' +
                ", aadharNumber='" + aadharNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", taxProofNumber='" + taxProofNumber + '\'' +
                '}';
    }

    private String FormatString(String message){
        return message.replace("-","");
    }
}
