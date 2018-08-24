package com.example.smarthomes.grouphomes.service;

import com.example.smarthomes.grouphomes.boundry.exceptions.NotFoundException;
import com.example.smarthomes.grouphomes.boundry.transferobject.ItemDTO;
import com.example.smarthomes.grouphomes.entity.model.HouseHoldItem;
import org.json.JSONException;

public interface HouseHoldItemService {

    String saveItem(ItemDTO houseHoldItem) throws JSONException;

    String deleteItem(String name) throws JSONException;

    String updateItem(ItemDTO houseHoldItem) throws NotFoundException, JSONException;

    String getItemDetailsByItemName(String name) throws JSONException;

    Integer getItem(String name);

    HouseHoldItem getHouuseHoldItemById(Integer id);

    Integer findHouseHoldItemByName(String name);

    String getItemsFromHouse(String name) throws JSONException;

}
