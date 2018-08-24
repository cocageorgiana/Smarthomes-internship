package com.example.smarthomes.grouphomes.entity.pojo;

public class ItemPOJO {

    private String name;

    private String description;

    private Integer quantity;

    public ItemPOJO(String name, String description, Integer quantity) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }


    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }
}
