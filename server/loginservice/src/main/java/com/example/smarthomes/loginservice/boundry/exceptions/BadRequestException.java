package com.example.smarthomes.loginservice.boundry.exceptions;


/**
 * Custom exception for a bad request
 */

public class BadRequestException extends LoginGenericException {

    public BadRequestException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public BadRequestException(String message) {
        super(message);
    }
}
