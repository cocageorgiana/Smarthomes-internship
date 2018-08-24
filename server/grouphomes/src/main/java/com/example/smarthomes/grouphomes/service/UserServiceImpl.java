package com.example.smarthomes.grouphomes.service;

import com.example.smarthomes.grouphomes.entity.pojo.UserPOJO;
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
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String getAllUsers() throws JSONException {
        List<Integer> userIdList = userRepository.getAllUserIds();
        List<String> userNames = new ArrayList<>();

        List<UserPOJO> userPOJOS = new ArrayList<>();
        JSONObject responseJson = new JSONObject();

        for(Integer it : userIdList) {
            String currentUserName = userRepository.getAllUsersNames(it);
            String currentFirstName = userRepository.getAllFirstNames(it);
            String currentLastName = userRepository.getAllLastNames(it);
            userPOJOS.add(new UserPOJO(it, currentUserName, currentFirstName, currentLastName));
        }

        HashSet<UserPOJO> pojoHashSet = new HashSet<>(userPOJOS);

        responseJson.put("users", userPOJOS);

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(String.valueOf(responseJson)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String prettyResponse = gson.toJson(jsonObject);

        return prettyResponse;

    }
}
