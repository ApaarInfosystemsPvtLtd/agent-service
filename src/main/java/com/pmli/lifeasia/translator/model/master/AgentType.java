package com.pmli.lifeasia.translator.model.master;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AgentType")
public class AgentType {

    private String Title;
    private String Code;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof AgentType)) return false;

        AgentType agentType = (AgentType) o;

        return new EqualsBuilder()
                .append(getTitle(), agentType.getTitle())
                .append(getCode(), agentType.getCode())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getTitle())
                .append(getCode())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "AgentType{" +
                "Title='" + Title + '\'' +
                ", Code='" + Code + '\'' +
                '}';
    }
}
