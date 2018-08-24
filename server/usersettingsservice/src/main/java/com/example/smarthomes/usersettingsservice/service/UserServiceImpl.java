package com.example.smarthomes.usersettingsservice.service;

import com.example.smarthomes.usersettingsservice.boundry.transferobject.UserInformationDTO;
import com.example.smarthomes.usersettingsservice.boundry.transferobject.UserPasswordDTO;
import com.example.smarthomes.usersettingsservice.entity.model.User;
import com.example.smarthomes.usersettingsservice.entity.repository.UserRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String updateUserInformations(UserInformationDTO userInformationDTO) throws JSONException {
        JSONObject responseJson = new JSONObject();
        int responseCode;

        Integer idUser = userRepository.getUserByUserName(userInformationDTO.getUserName());

        if(userRepository.getUserByUserName(userInformationDTO.getUserName()) == null) {
            responseJson.put("Type", "Fail")
                    .put("Message", "User does not exist in the database")
                    .put("status", 400);
            responseCode = 400;
        }
        else {
            responseJson.put("Type", "Success")
                    .put("Message", "User updated with success")
                    .put("status", 200);
            responseCode = 200;
        }
        if(responseCode == 200) {
            userRepository.actuallyUpdateUserInformation(userInformationDTO.getFirstName(), userInformationDTO.getLastName(), userInformationDTO.getEmail(), idUser);
        }
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(String.valueOf(responseJson)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String prettyResponse = gson.toJson(jsonObject);

        return prettyResponse;
    }

    @Override
    public String updateUserPassword(UserPasswordDTO userPasswordDTO) throws JSONException {
        JSONObject responseJson = new JSONObject();
        int responseCode;

        Integer idUser = userRepository.getUserByUserNameAndPassword(userPasswordDTO.getUserName(), userPasswordDTO.getOldPassword());

        if(idUser == null) {
            responseJson.put("Type", "Fail")
                    .put("Message", "User does not exist in the database")
                    .put("status", 400);
            responseCode = 400;
        }
        else if(!userPasswordDTO.getNewPassword().equals(userPasswordDTO.getReEnteredPassword())) {
            responseJson.put("Type", "Fail")
                    .put("Message", "You must re-enter the same password as the new password")
                    .put("status", 400);
            responseCode = 400;
        }
        else {
            responseJson.put("Type", "Success")
                    .put("Message", "User updated with success")
                    .put("status", 200);
            responseCode = 200;
        }

        if(responseCode == 200) {
            userRepository.actuallyUpdateUserPassword(userPasswordDTO.getNewPassword(), idUser);
        }

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(String.valueOf(responseJson)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String prettyResponse = gson.toJson(jsonObject);

        return prettyResponse;
    }
}
