package com.example.smarthomes.trafficservice.service;

import org.json.JSONException;

import java.io.IOException;

public interface TrafficService {

    /**
     * Makes a GET Request to the MAP API in order to get informations about traffic between the points , the actual road etc
     * @param home The start location
     * @param destination The destination location
     * @return A JSON containing the all the traffic informations that is sent to the client-side
     * @throws IOException
     * @throws JSONException
     */

    String getRoute(String home, String destination) throws IOException, JSONException;
}
