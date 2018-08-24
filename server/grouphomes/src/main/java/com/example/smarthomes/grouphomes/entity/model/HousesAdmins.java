package com.example.smarthomes.grouphomes.entity.model;

import com.example.smarthomes.grouphomes.entity.embeddable.CurrentLoggedUser;
import com.example.smarthomes.grouphomes.entity.embeddable.HouseEmbeddable;

import javax.persistence.*;

@Entity
@Table(name = "user_privilegies_admin")
public class HousesAdmins {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private CurrentLoggedUser currentLoggedUser;

    @Embedded
    private HouseEmbeddable houseEmbeddable;

    public HouseEmbeddable getHouseEmbeddable() {
        return houseEmbeddable;
    }

    public Integer getId() {
        return id;
    }

    public CurrentLoggedUser getCurrentLoggedUser() {
        return currentLoggedUser;
    }

    public void setHouseEmbeddable(HouseEmbeddable houseEmbeddable) {
        this.houseEmbeddable = houseEmbeddable;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCurrentLoggedUser(CurrentLoggedUser currentLoggedUser) {
        this.currentLoggedUser = currentLoggedUser;
    }
}
