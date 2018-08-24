package com.example.smarthomes.newsservice.boundry.exceptions;

public class NewsGenericException extends Exception {

    public NewsGenericException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public NewsGenericException(String message) {
        super(message);
    }
}
