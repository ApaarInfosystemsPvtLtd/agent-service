package com.pmli.lifeasia.translator.model.agent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Alternate
{
    private String phoneNumber="";
    private String CountryCode="";

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Primary)) return false;

        Primary primary = (Primary) o;

        return new EqualsBuilder()
                .append(getPhoneNumber(), primary.getPhoneNumber())
                .append(getCountryCode(), primary.getCountryCode())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getPhoneNumber())
                .append(getCountryCode())
                .toHashCode();
    }

    public String toString() {
        return new StringBuilder()
                .append(getPhoneNumber())
                .append(getCountryCode())
                .toString();
    }

    public String toJson() {
        return "Primary{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", CountryCode='" + CountryCode + '\'' +
                '}';
    }
}
