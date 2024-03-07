package com.pmli.lifeasia.translator.model;

import java.util.HashMap;
import java.util.Map;

public class Validation {

    boolean valid = true;
    Map<String,String> errors = new HashMap<>();

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}
