package com.example.smarthomes.grouphomes.entity.model;

import com.example.smarthomes.grouphomes.entity.embeddable.UserHouseEmbeddable;

import javax.persistence.*;

@Entity
@Table(name = "houses")
public class House {

    @Id
    @Column(name = "id_house")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_house;

    @Column(name = "name")
    private String houseName;

    @Column(name = "adress")
    private String houseAdress;

    @Embedded
    private UserHouseEmbeddable userHouseEmbeddable;

    public Integer getId_house() {
        return id_house;
    }

    public String getHouseName() {
        return houseName;
    }

    public UserHouseEmbeddable getUserHouseEmbeddable() {
        return userHouseEmbeddable;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public void setId_house(Integer id_house) {
        this.id_house = id_house;
    }

    public String getHouseAdress() {
        return houseAdress;
    }

    public void setHouseAdress(String houseAdress) {
        this.houseAdress = houseAdress;
    }

    public void setUserHouseEmbeddable(UserHouseEmbeddable userHouseEmbeddable) {
        this.userHouseEmbeddable = userHouseEmbeddable;
    }
}
