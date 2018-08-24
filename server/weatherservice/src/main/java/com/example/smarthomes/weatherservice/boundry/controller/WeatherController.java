package com.example.smarthomes.weatherservice.boundry.controller;

import com.example.smarthomes.weatherservice.service.WeatherService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    /**
     * Makes a POST Request in which we specify that we want the weather for today
     * @return The JSON containing all the weather informations from the GET Request to the AccuWeather API
     * @throws IOException
     * @throws JSONException
     */

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/weather/daily", method = RequestMethod.GET)
    public String getTodayForecastPerDay() throws IOException, JSONException {

        return weatherService.getForecastPerDay();
    }
    
}
