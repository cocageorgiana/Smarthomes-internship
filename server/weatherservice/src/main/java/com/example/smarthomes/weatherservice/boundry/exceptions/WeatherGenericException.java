package com.example.smarthomes.weatherservice.boundry.exceptions;

public class WeatherGenericException extends Exception {

    public WeatherGenericException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public WeatherGenericException(String message) {
        super(message);
    }
}
