package com.example.smarthomes.grouphomes.boundry.transferobject;

public class HouseDTO {

    private String houseName;

    private String houseAddress;

    private String userName;

    public String getUserName() {
        return userName;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }
}
