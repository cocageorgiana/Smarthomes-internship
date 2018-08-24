package com.example.smarthomes.trafficservice.entity.model;

/**
 * POJO that encapsulated the locations for which we want to find out information regarding traffic
 */

public class DistancePoints {

    private String home;

    private String destination;

    public String getDestination() {
        return destination;
    }

    public String getHome() {
        return home;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setHome(String home) {
        this.home = home;
    }
}
