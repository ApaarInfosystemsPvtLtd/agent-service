package com.pmli.lifeasia.translator.Exception.runtime;

public class CustomException extends RuntimeException
{
    public CustomException(String errorMessage) {
        super(errorMessage);
    }
}
