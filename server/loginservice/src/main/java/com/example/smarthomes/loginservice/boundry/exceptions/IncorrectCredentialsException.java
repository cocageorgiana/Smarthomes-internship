package com.example.smarthomes.loginservice.boundry.exceptions;

/**
 * Custom exception in case the users enters the wrong credentials
 */

public class IncorrectCredentialsException extends LoginGenericException {


    public IncorrectCredentialsException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public IncorrectCredentialsException(String message) {
        super(message);
    }
}
