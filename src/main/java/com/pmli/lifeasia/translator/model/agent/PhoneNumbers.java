package com.pmli.lifeasia.translator.model.agent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class PhoneNumbers
{
    private Primary primary = new Primary();
    private Alternate alternate = new Alternate();

    public Primary getPrimary() {
        return primary;
    }

    public void setPrimary(Primary primary) {
        this.primary = primary;
    }

    public Alternate getAlternate() {
        return alternate;
    }

    public void setAlternate(Alternate alternate) {
        this.alternate = alternate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof PhoneNumbers)) return false;

        PhoneNumbers that = (PhoneNumbers) o;

        return new EqualsBuilder()
                .append(getPrimary(), that.getPrimary())
                .append(getAlternate(), that.getAlternate())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getPrimary())
                .append(getAlternate())
                .toHashCode();
    }


    public String toString() {
        return new StringBuilder()
                .append(getPrimary().toString())
                .append(getAlternate().toString())
                .toString();
    }


    public String toJson() {
        return "PhoneNumbers{" +
                "primary=" + primary.toJson() +
                ", alternate=" + alternate.toJson() +
                '}';
    }
}
