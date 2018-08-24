package com.example.smarthomes.grouphomes.entity.embeddable;


import javax.persistence.Embeddable;

@Embeddable
public class CurrentLoggedUser {

    private String userNameCurrent;

    private String userNameAdd;

    public String getUserNameAdd() {
        return userNameAdd;
    }

    public String getUserNameCurrent() {
        return userNameCurrent;
    }

    public void setUserNameAdd(String userNameAdd) {
        this.userNameAdd = userNameAdd;
    }

    public void setUserNameCurrent(String userNameCurrent) {
        this.userNameCurrent = userNameCurrent;
    }
}