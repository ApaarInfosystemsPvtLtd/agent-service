package com.pmli.lifeasia.translator.model.agent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AgentName
{
    @NotNull @NotEmpty
    private String salutation="        "; // Length=8
    @NotNull @NotEmpty
    private String firstName="";
    private String middleName="";
    @NotNull @NotEmpty
    private String lastName="";

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof AgentName)) return false;

        AgentName agentName = (AgentName) o;

        return new EqualsBuilder()
                .append(getSalutation(), agentName.getSalutation())
                .append(getFirstName(), agentName.getFirstName())
                .append(getMiddleName(), agentName.getMiddleName())
                .append(getLastName(), agentName.getLastName())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getSalutation())
                .append(getFirstName())
                .append(getMiddleName())
                .append(getLastName())
                .toHashCode();
    }

    public String toString() {
        return new StringBuilder()
                .append(getSalutation())
                .append(getFirstName())
                .append(getMiddleName())
                .append(getLastName())
                .toString();
    }

    public String toJson() {
        return "AgentName{" +
                "salutation='" + salutation + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
