package com.example.smarthomes.grouphomes.entity.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class UserHouseEmbeddable {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
