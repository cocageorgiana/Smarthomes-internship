package com.example.smarthomes.trafficservice.boundry.exceptions;

public class TrafficGenericException extends Exception {

    public TrafficGenericException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public TrafficGenericException(String message) {
        super(message);
    }
}
