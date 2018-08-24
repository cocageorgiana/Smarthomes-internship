package com.example.smarthomes.grouphomes.service;

import com.example.smarthomes.grouphomes.boundry.transferobject.GroupDTO;
import com.example.smarthomes.grouphomes.entity.embeddable.CurrentLoggedUser;
import com.example.smarthomes.grouphomes.entity.model.Group;
import com.example.smarthomes.grouphomes.entity.repository.GroupRepository;
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

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final HouseRepository houseRepository;
    private final HousesAdminsRepository housesAdminsRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository, UserRepository userRepository, HouseRepository houseRepository, HousesAdminsRepository housesAdminsRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.houseRepository = houseRepository;
        this.housesAdminsRepository = housesAdminsRepository;
    }


    @Override
    public String saveGroup(GroupDTO group) throws JSONException {
        JSONObject responseJson = new JSONObject();
        int responseCode = 0;

        Integer idUserTempAdmin = userRepository.getUserByUser_name(group.getUserNameCurrent());
        Integer idHouseTemp = houseRepository.findHouseByHouseName(group.getHouseName());

        Integer idUserTempAdd = userRepository.getUserByUser_name(group.getUserNameToAdd());

        if(userRepository.getUserByUser_name(group.getUserNameToAdd()) == null) {
            responseJson.put("Type", "Fail")
                    .put("Message", "User does not exist in the database")
                    .put("status", 400);
            responseCode = 400;
        }
        else if(houseRepository.findHouseByHouseName(group.getHouseName()) == null) {
            responseJson.put("Type", "Fail")
                    .put("Message", "House does not exist in the database")
                    .put("status", 400);
            responseCode = 400;
        }
        else if(housesAdminsRepository.checkHouseAdmin(idHouseTemp) == idUserTempAdmin || housesAdminsRepository.checkHouseAdmin(idHouseTemp) == null) {
            responseJson.put("Type", "Success")
                    .put("Message", "Group added with success")
                    .put("status", 200);
            responseCode = 200;
        }
        else {
            responseJson.put("Type", "Fail")
                    .put("Message", "You are not an admin on that house")
                    .put("status", 400);
        }

        if (responseCode == 200) {
            housesAdminsRepository.actuallySaveAdmin(idUserTempAdmin, idHouseTemp);
            groupRepository.actuallySaveGroup(idUserTempAdmin, idHouseTemp);
            groupRepository.actuallySaveGroup(idUserTempAdd, idHouseTemp);
        }

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(String.valueOf(responseJson)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String prettyResponse = gson.toJson(jsonObject);

        return prettyResponse;
    }

    @Override
    public String deleteGroup(GroupDTO group) throws JSONException {
        JSONObject responseJson = new JSONObject();
        int responseCode = 0;

        Integer idUserTempAdmin = userRepository.getUserByUser_name(group.getUserNameCurrent());
        Integer idHouseTemp = houseRepository.findHouseByHouseName(group.getHouseName());

        Integer idUserTempAdd = userRepository.getUserByUser_name(group.getUserNameToAdd());

        if(userRepository.getUserByUser_name(group.getUserNameToAdd()) == null) {
            responseJson.put("Type", "Fail")
                    .put("Message", "User does not exist in the database")
                    .put("status", 400);
            responseCode = 400;
        }
        else if(houseRepository.findHouseByHouseName(group.getHouseName()) == null) {
            responseJson.put("Type", "Fail")
                    .put("Message", "House does not exist in the database")
                    .put("status", 400);
            responseCode = 400;
        }
        else if(housesAdminsRepository.checkHouseAdmin(idHouseTemp) == idUserTempAdmin || housesAdminsRepository.checkHouseAdmin(idHouseTemp) == null) {
            responseJson.put("Type", "Success")
                    .put("Message", "Person deleted with success")
                    .put("status", 200);
            responseCode = 200;
        }
        else {
            responseJson.put("Type", "Fail")
                    .put("Message", "You are not an admin on that house")
                    .put("status", 400);
        }

        if(responseCode == 200) {
            groupRepository.actuallyDeleteGroup(idUserTempAdd, idHouseTemp);
        }

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(String.valueOf(responseJson)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String prettyResponse = gson.toJson(jsonObject);

        return prettyResponse;

    }

    @Override
    public String getGroupForUser(CurrentLoggedUser currentLoggedUser) {
        return null;
    }
}
