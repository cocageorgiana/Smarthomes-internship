package com.example.smarthomes.grouphomes.boundry.transferobject;

public class ItemDTO {

    private String name;

    private String description;

    private Integer quantity;

    private String houseName;

    public String getHouseName() {
        return houseName;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
