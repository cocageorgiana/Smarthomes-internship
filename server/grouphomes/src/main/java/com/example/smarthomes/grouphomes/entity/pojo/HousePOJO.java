package com.example.smarthomes.grouphomes.entity.pojo;

public class HousePOJO {

    private String name;

    private String adress;

    public HousePOJO(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
