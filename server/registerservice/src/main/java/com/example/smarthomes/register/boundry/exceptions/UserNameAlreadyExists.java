package com.example.smarthomes.register.boundry.exceptions;

public class UserNameAlreadyExists extends Exception {

    public UserNameAlreadyExists(String message, Throwable throwable) {
        super(message, throwable);
    }

    public UserNameAlreadyExists(String message) {
        super(message);
    }
}
