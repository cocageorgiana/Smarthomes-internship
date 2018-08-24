package com.example.smarthomes.grouphomes.service;

import com.example.smarthomes.grouphomes.boundry.exceptions.NotFoundException;
import com.example.smarthomes.grouphomes.boundry.transferobject.ItemDTO;
import com.example.smarthomes.grouphomes.entity.model.HouseHoldItem;
import com.example.smarthomes.grouphomes.entity.pojo.ItemPOJO;
import com.example.smarthomes.grouphomes.entity.repository.HouseHoldItemRepository;
import com.example.smarthomes.grouphomes.entity.repository.HouseRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseHoldItemServiceImpl implements HouseHoldItemService {

    private final HouseHoldItemRepository houseHoldItemRepository;
    private final HouseRepository houseRepository;

    @Autowired
    public HouseHoldItemServiceImpl(HouseHoldItemRepository houseHoldItemRepository, HouseRepository houseRepository) {
        this.houseHoldItemRepository = houseHoldItemRepository;
        this.houseRepository = houseRepository;
    }

    @Override
    public String saveItem(ItemDTO houseHoldItem) throws JSONException {

        JSONObject responseJson = new JSONObject();

        responseJson.put("Type", "Success")
                .put("Message", "Item saved with success")
                .put("status", 200);

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(String.valueOf(responseJson)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String prettyResponse = gson.toJson(jsonObject);

        Integer id_house = houseRepository.findHouseByHouseName(houseHoldItem.getHouseName());

        houseHoldItemRepository.actuallySaveItem(houseHoldItem.getName(), houseHoldItem.getDescription(), houseHoldItem.getQuantity(), id_house);

        return prettyResponse;
    }

    @Override
    public String deleteItem(String name) throws JSONException {

        JSONObject responseJson = new JSONObject();
        int responseCode = 0;

        if(houseHoldItemRepository.findHouseHoldItemByName(name) == null) {
            responseJson.put("Type", "Fail")
                    .put("Message", "Item not found in the database")
                    .put("status", 400);
            responseCode = 400;
        }
        else {
            responseCode = 200;
        }

        if(responseCode == 200) {
            houseHoldItemRepository.actuallyDeleteItem(houseHoldItemRepository.findHouseHoldItemByName(name));
            responseJson.put("Type", "Success")
                    .put("Message", "Item deleted with success")
                    .put("status", 200);
        }

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(String.valueOf(responseJson)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String prettyResponse = gson.toJson(jsonObject);

        return prettyResponse;
    }


    @Override
    public String updateItem(ItemDTO houseHoldItem) throws NotFoundException, JSONException {

        JSONObject responseJson = new JSONObject();
        int responseCode = 0;

        if(houseHoldItemRepository.findHouseHoldItemByName(houseHoldItem.getName()) == null) {
            responseJson.put("Type", "Fail")
                    .put("Message", "Item that you tried to update does not exist in the database")
                    .put("status", 400);
            responseCode = 400;

        }
        else {
            responseJson.put("Type", "Success")
                    .put("Message", "Item updated with success")
                    .put("status", 200);
            responseCode = 200;
        }

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(String.valueOf(responseJson)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String prettyResponse = gson.toJson(jsonObject);

        if(responseCode == 200) {
            houseHoldItemRepository.actuallyUpdateItem(houseHoldItem.getName(), houseHoldItem.getDescription(), houseHoldItem.getQuantity(),
                    houseRepository.findHouseByHouseName(houseHoldItem.getHouseName()), houseHoldItemRepository.findHouseHoldItemByName(houseHoldItem.getName()));
        }
        return prettyResponse;
    }

    @Override
    public String getItemDetailsByItemName(String name) throws JSONException {
        String itemDescription = houseHoldItemRepository.getItemDescriptionByItemName(name);
        Integer itemQuantity = houseHoldItemRepository.getItemQuantityByItemName(name);
        Integer houseId = houseHoldItemRepository.getItemHouseIdByItemName(name);
        String houseName = houseRepository.findHouseById_house(houseId);

        JSONObject responseJson = new JSONObject();

        if(itemDescription == null || itemQuantity == null || houseId == null) {
            responseJson.put("Type", "Fail")
                    .put("Message", "Item that you tried to get details does not exist in the database")
                    .put("status", 400);
        }
        else {
            responseJson.put("Type", "Success")
                    .put("Item Name", name)
                    .put("Item Description", itemDescription)
                    .put("Item Quantity", itemQuantity)
                    .put("House Name", houseName)
                    .put("status", 200);
        }

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(String.valueOf(responseJson)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String prettyResponse = gson.toJson(jsonObject);

        return prettyResponse;
    }

    @Override
    public Integer getItem(String name) {
        return houseHoldItemRepository.findHouseHoldItemByName(name);
    }

    @Override
    public HouseHoldItem getHouuseHoldItemById(Integer id) {
        String itemTempName = houseHoldItemRepository.findHouseHoldItemById(id);

        return houseHoldItemRepository.findById(houseHoldItemRepository.findHouseHoldItemByName(itemTempName)).get();
    }

    @Override
    public Integer findHouseHoldItemByName(String name) {
        return houseHoldItemRepository.findHouseHoldItemByName(name);
    }

    @Override
    public String getItemsFromHouse(String name) throws JSONException {
        Integer id_house = houseRepository.findHouseByHouseName(name);
        List<String> itemNameList = houseHoldItemRepository.getItemNameByHouseId(id_house);
        List<String> itemDescriptionList = houseHoldItemRepository.getItemDescriptionByHouseId(id_house);
        List<Integer> itemQuantityList = houseHoldItemRepository.getItemQuantityByHouseId(id_house);
        List<ItemPOJO> itemPOJOList = new ArrayList<>();

        JSONObject responseJson = new JSONObject();

        for(String it1 : itemNameList) {
            for(String it2 : itemDescriptionList) {
                for(Integer it3 : itemQuantityList) {
                    itemPOJOList.add(new ItemPOJO(it1, it2, it3));
                }
            }
        }

        responseJson.put("house_items", itemPOJOList);

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(String.valueOf(responseJson)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String prettyResponse = gson.toJson(jsonObject);

        return prettyResponse;
    }
}
