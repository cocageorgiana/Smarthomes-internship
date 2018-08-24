package com.example.smarthomes.grouphomes.entity.model;


import com.example.smarthomes.grouphomes.entity.embeddable.HouseEmbeddable;

import javax.persistence.*;

@Entity
@Table(name = "household_items")
public class HouseHoldItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private Integer quantity;

    @Embedded
    private HouseEmbeddable houseEmbeddable;

    public HouseEmbeddable getHouseEmbeddable() {
        return houseEmbeddable;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Integer getQuantity() { return quantity; }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setHouseEmbeddable(HouseEmbeddable houseEmbeddable) {
        this.houseEmbeddable = houseEmbeddable;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
