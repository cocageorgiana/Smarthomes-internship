package com.example.smarthomes.weatherservice.service;

import org.json.JSONException;

import java.io.IOException;
import java.net.MalformedURLException;

public interface WeatherService {

    /**
     * Makes a GET Request to the AccuWeather API in order to get all the weather informations for todday
     * @return A JSON containing all the weather informations
     * @throws IOException
     * @throws JSONException
     */

    String getForecastPerDay() throws IOException, JSONException;

    /**
     * Makes a GET Request to the AccuWeather API in order to get all the weather informations for a number of hours
     * @return A JSON containing all the weather informations
     * @throws IOException
     * @throws JSONException
     */

    String getForecastPerHour(Integer numberOfHours) throws JSONException, IOException;
}
