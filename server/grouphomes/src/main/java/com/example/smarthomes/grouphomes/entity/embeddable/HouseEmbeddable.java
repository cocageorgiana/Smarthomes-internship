package com.example.smarthomes.grouphomes.entity.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class HouseEmbeddable {

    private String houseName;

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }
}
