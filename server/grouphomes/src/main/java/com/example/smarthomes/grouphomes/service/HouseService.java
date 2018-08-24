package com.example.smarthomes.grouphomes.service;

import com.example.smarthomes.grouphomes.boundry.exceptions.NotFoundException;
import com.example.smarthomes.grouphomes.boundry.transferobject.HouseDTO;
import com.example.smarthomes.grouphomes.entity.model.House;
import org.json.JSONException;

public interface HouseService {

    String saveHouse(HouseDTO house) throws JSONException;

    Integer getHouse(String house_name);

    House getHouseById(Integer id);

    String deleteHouse(String house_name) throws JSONException;

    String updateHouse(HouseDTO house) throws NotFoundException, JSONException;

    String getAllHomes() throws JSONException;


    String getUsersPerHouse(String house_name) throws JSONException;

    String getHousesPerUser(String user_name) throws JSONException;
}
