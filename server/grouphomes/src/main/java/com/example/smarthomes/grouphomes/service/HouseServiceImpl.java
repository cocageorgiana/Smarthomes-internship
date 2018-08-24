package com.example.smarthomes.grouphomes.service;

import com.example.smarthomes.grouphomes.boundry.exceptions.NotFoundException;
import com.example.smarthomes.grouphomes.boundry.transferobject.HouseDTO;
import com.example.smarthomes.grouphomes.entity.model.House;
import com.example.smarthomes.grouphomes.entity.pojo.HousePOJO;
import com.example.smarthomes.grouphomes.entity.repository.HouseRepository;
import com.example.smarthomes.grouphomes.entity.repository.HousesAdminsRepository;
import com.example.smarthomes.grouphomes.entity.repository.UserRepository;
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
import java.util.stream.Collectors;

@Service
public class HouseServiceImpl implements HouseService {

    private final HouseRepository houseRepository;
    private final HousesAdminsRepository housesAdminsRepository;
    private final UserRepository userRepository;

    @Autowired
    public HouseServiceImpl(HouseRepository houseRepository, HousesAdminsRepository housesAdminsRepository, UserRepository userRepository) {
        this.houseRepository = houseRepository;
        this.housesAdminsRepository = housesAdminsRepository;
        this.userRepository = userRepository;
    }

    @Override
    public String saveHouse(HouseDTO house) throws JSONException {

        JSONObject responseJson = new JSONObject();

        responseJson.put("Type", "Success")
                .put("Message", "House saved with success")
                .put("status", 200);

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(String.valueOf(responseJson)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String prettyResponse = gson.toJson(jsonObject);

        String userName = house.getUserName();
        Integer userId = userRepository.getUserByUser_name(userName);

        houseRepository.actuallyInsertInHouse(house.getHouseName(), house.getHouseAddress());
        houseRepository.actuallyInsertInHousesUser(userId, houseRepository.findHouseByHouseName(house.getHouseName()));

        return prettyResponse;
    }


    @Override
    public String deleteHouse(String houseName) throws JSONException {

        JSONObject responseJson = new JSONObject();
        int responseCode;

        if (getHouseById(getHouse(houseName)) == null) {

            responseJson.put("Type", "Fail")
                    .put("Message", "House with that name does not exist in the database")
                    .put("status", 400);
            responseCode = 400;
        } else {
            responseJson.put("Type", "Success")
                    .put("Message", "House deleted with success")
                    .put("status", 200);
            responseCode = 200;
        }

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(String.valueOf(responseJson)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String prettyResponse = gson.toJson(jsonObject);

        if (responseCode == 200) {

            if (housesAdminsRepository.checkHouseAdmin(houseRepository.findHouseByHouseName(houseName)) != null) {
                houseRepository.deleteAdminsHouses(houseRepository.findHouseByHouseName(houseName));
            }
            houseRepository.deleteUserHouses(houseRepository.findHouseByHouseName(houseName));
            houseRepository.deleteItemsInHouse(houseRepository.findHouseByHouseName(houseName));
            houseRepository.delete(getHouseById(getHouse(houseName)));
        }
        return prettyResponse;
    }

    @Override
    public String updateHouse(HouseDTO house) throws NotFoundException, JSONException {

        JSONObject responseJson = new JSONObject();
        int responseCode;

        if (houseRepository.findHouseByHouseName(house.getHouseName()) == null) {
            responseJson.put("Type", "Fail")
                    .put("Message", "House does not exist in the database")
                    .put("status", 400);
            responseCode = 400;
        } else {
            responseJson.put("Type", "Success")
                    .put("Message", "House updated with success")
                    .put("status", 200);
            responseCode = 200;
        }

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(String.valueOf(responseJson)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String prettyResponse = gson.toJson(jsonObject);

        Integer idHouse = houseRepository.findHouseByHouseName(house.getHouseName());
        Integer idUser = userRepository.getUserByUser_name(house.getUserName());

        if (responseCode == 200) {
            houseRepository.actuallyUpdateHouse(house.getHouseName(), house.getHouseAddress(), idHouse);
            houseRepository.actuallyUpdateInUserHouses(idUser, idHouse);
        }

        return prettyResponse;
    }

    @Override
    public String getAllHomes() throws JSONException {
        List<String> namesHouseList = new ArrayList<>();
        List<String> adressHouseList = new ArrayList<>();

        namesHouseList = houseRepository.getAllHousesName();
        adressHouseList = houseRepository.getAllHousesAdress();

        JSONObject responseJson = new JSONObject();
        responseJson.put("Name", namesHouseList)
                .put("Adress", adressHouseList);

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(String.valueOf(responseJson)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String prettyResponse = gson.toJson(jsonObject);

        return prettyResponse;
    }


    @Override
    public String getUsersPerHouse(String house_name) throws JSONException {

        Integer house_id = houseRepository.findHouseByHouseName(house_name);

        List<Integer> userIds = houseRepository.getUsersOfHouse(house_id);

        List<String> userNameList = new ArrayList<>();
        List<String> userNameListFinal;

        for(Integer it : userIds) {
            String currentUser_Name = String.valueOf(houseRepository.getUserDetails(it));
            userNameList.add(currentUser_Name);
        }
        JSONObject responseJson = new JSONObject();

        userNameListFinal = userNameList.stream().distinct().collect(Collectors.toList());

        responseJson.put("Users", userNameListFinal);

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(String.valueOf(responseJson)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String prettyResponse = gson.toJson(jsonObject);

        return prettyResponse;
    }

    @Override
    public String getHousesPerUser(String user_name) throws JSONException {
        Integer user_id = userRepository.getUserByUser_name(user_name);

        List<Integer> housesIds = houseRepository.getHousesOfUser(user_id);

        List<HousePOJO> housePOJOList = new ArrayList<>();


        for(Integer it : housesIds) {
            String currentHouse_Name = String.valueOf(houseRepository.getHouseName(it));
            String currentHose_Adress = String.valueOf(houseRepository.getHouseAdress(it));
            housePOJOList.add(new HousePOJO(currentHouse_Name, currentHose_Adress));
        }

        housePOJOList.stream().distinct().collect(Collectors.toList());

        JSONObject responseJson = new JSONObject();


        responseJson.put("user_houses", housePOJOList);

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(String.valueOf(responseJson)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String prettyResponse = gson.toJson(jsonObject);

        return prettyResponse;

    }


    @Override
    public Integer getHouse(String houseName) {
        return houseRepository.findHouseByHouseName(houseName);
    }

    @Override
    public House getHouseById(Integer id) {
        String houseTempName = houseRepository.findHouseById_house(id);

        return houseRepository.findById(houseRepository.findHouseByHouseName(houseTempName)).get();
    }

}
