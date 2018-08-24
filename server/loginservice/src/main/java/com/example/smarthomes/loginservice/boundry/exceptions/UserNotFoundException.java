package com.example.smarthomes.loginservice.boundry.exceptions;


/**
 * Custom exception for the case does not exist at all in the database
 */

public class UserNotFoundException extends LoginGenericException {

    public UserNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
