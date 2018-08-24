package com.example.smarthomes.loginservice.boundry.exceptions;

/**
 * Custom generic exception for this microservice, from which all the custom other exceptions will be inherited
 */

public class LoginGenericException extends Exception {

    public LoginGenericException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public LoginGenericException(String message) {
        super(message);
    }
}
