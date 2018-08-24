package com.example.smarthomes.register.service;

import com.example.smarthomes.register.entity.model.User;
import com.example.smarthomes.register.entity.repository.UserRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String saveUser(User user) throws JSONException {

        userRepository.save(user);

        JSONObject responseJson = new JSONObject();

        responseJson.put("Type", "Success")
                    .put("Message", "User registered with success")
                    .put("status", 200);


        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(String.valueOf(responseJson)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String prettyResponse = gson.toJson(jsonObject);

        return prettyResponse;

    }

    @Override
    public boolean mailAlreadyExists(String email) {
        return userRepository.findByEmail(email) != null;
    }

    @Override
    public boolean userNameAlreadyExists(String userName) {
        return userRepository.findByUser_name(userName) != null;
    }


}
