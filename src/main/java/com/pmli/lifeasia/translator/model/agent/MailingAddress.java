package com.pmli.lifeasia.translator.model.agent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MailingAddress
{
    @NotNull @NotEmpty
    private String addressType="R";
    private String addressLine01="";
    private String addressLine02="";
    private String addressLine03="";
    private String city="";
    @NotNull @NotEmpty @Size(min = 5, max = 6)
    private String pinCode="";
    @NotNull @NotEmpty
    private String state="";
    private PhoneNumbers phoneNumbers = new PhoneNumbers();

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getAddressLine01() {
        return addressLine01;
    }

    public void setAddressLine01(String addressLine01) {
        this.addressLine01 = addressLine01;
    }

    public String getAddressLine02() {
        return addressLine02;
    }

    public void setAddressLine02(String addressLine02) {
        this.addressLine02 = addressLine02;
    }

    public String getAddressLine03() {
        return addressLine03;
    }

    public void setAddressLine03(String addressLine03) {
        this.addressLine03 = addressLine03;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public PhoneNumbers getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(PhoneNumbers phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof MailingAddress)) return false;

        MailingAddress that = (MailingAddress) o;

        return new EqualsBuilder()
                .append(getAddressType(), that.getAddressType())
                .append(getAddressLine01(), that.getAddressLine01())
                .append(getAddressLine02(), that.getAddressLine02())
                .append(getAddressLine03(), that.getAddressLine03())
                .append(getCity(), that.getCity())
                .append(getPinCode(), that.getPinCode())
                .append(getState(), that.getState())
                .append(getPhoneNumbers(), that.getPhoneNumbers())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getAddressType())
                .append(getAddressLine01())
                .append(getAddressLine02())
                .append(getAddressLine03())
                .append(getCity())
                .append(getPinCode())
                .append(getState())
                .append(getPhoneNumbers())
                .toHashCode();
    }

    public String toString() {
        return new StringBuilder()
                .append(getAddressType())
                .append(getAddressLine01())
                .append(getAddressLine02())
                .append(getAddressLine03())
                .append(getCity())
                .append(getPinCode())
                .append(getState())
                .append(getPhoneNumbers().toString())
                .toString();
    }

    public String toJson() {
        return "MailingAddress{" +
                "addressType='" + addressType + '\'' +
                ", addressLine01='" + addressLine01 + '\'' +
                ", addressLine02='" + addressLine02 + '\'' +
                ", addressLine03='" + addressLine03 + '\'' +
                ", city='" + city + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", state='" + state + '\'' +
                ", phoneNumbers=" + phoneNumbers.toJson() +
                '}';
    }
}
