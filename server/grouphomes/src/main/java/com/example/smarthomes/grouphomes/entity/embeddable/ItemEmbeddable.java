package com.example.smarthomes.grouphomes.entity.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class ItemEmbeddable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
