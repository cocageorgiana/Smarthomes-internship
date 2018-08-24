package com.example.smarthomes.trafficservice.boundry.controller;

import com.example.smarthomes.trafficservice.entity.model.DistancePoints;
import com.example.smarthomes.trafficservice.service.TrafficService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class TrafficController {

    private final TrafficService trafficService;

    @Autowired
    public TrafficController(TrafficService trafficService) {
        this.trafficService = trafficService;
    }

    /**
     * Configures the endpoint to make a POST Request with the home location and destination
     * @param distancePoints The home and destination locations encapsulated as a JSON
     * @return The resulted JSON from the GET Request to the API which contains all the traffic information
     * @throws IOException
     * @throws JSONException
     */

    @PostMapping(value = "traffic")
    public String getRoute(@RequestBody DistancePoints distancePoints) throws IOException, JSONException {

        return trafficService.getRoute(distancePoints.getHome(), distancePoints.getDestination());
    }
}
