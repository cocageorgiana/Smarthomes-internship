package com.example.smarthomes.grouphomes.boundry.transferobject;

public class GroupDTO {

    private String userNameCurrent;

    private String userNameToAdd;

    private String houseName;

    public String getUserNameCurrent() {
        return userNameCurrent;
    }

    public String getHouseName() {
        return houseName;
    }

    public String getUserNameToAdd() {
        return userNameToAdd;
    }

    public void setUserNameCurrent(String userNameCurrent) {
        this.userNameCurrent = userNameCurrent;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public void setUserNameToAdd(String userNameToAdd) {
        this.userNameToAdd = userNameToAdd;
    }
}
