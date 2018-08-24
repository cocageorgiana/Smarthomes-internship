package com.example.smarthomes.register.boundry.exceptions;

public class EmailAlreadyExists extends Exception {

    public EmailAlreadyExists(String message) {
        super(message);
    }

    public EmailAlreadyExists(String message, Throwable throwable) {
        super(message, throwable);
    }
}
