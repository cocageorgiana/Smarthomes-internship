package com.example.smarthomes.grouphomes.entity.model;

import com.example.smarthomes.grouphomes.entity.embeddable.CurrentLoggedUser;
import com.example.smarthomes.grouphomes.entity.embeddable.HouseEmbeddable;

import javax.persistence.*;

@Entity
@Table(name = "user_houses")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private CurrentLoggedUser currentLoggedUser;

    @Embedded
    private HouseEmbeddable houseEmbeddable;

    public CurrentLoggedUser getCurrentLoggedUser() {
        return currentLoggedUser;
    }

    public Integer getId() {
        return id;
    }


    public void setCurrentLoggedUser(CurrentLoggedUser currentLoggedUser) {
        this.currentLoggedUser = currentLoggedUser;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HouseEmbeddable getHouseEmbeddable() {
        return houseEmbeddable;
    }

    public void setHouseEmbeddable(HouseEmbeddable houseEmbeddable) {
        this.houseEmbeddable = houseEmbeddable;
    }

}
