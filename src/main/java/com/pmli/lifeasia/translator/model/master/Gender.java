package com.pmli.lifeasia.translator.model.master;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Gender")
public class Gender
{
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
}
