package com.example.smarthomes.usersettingsservice.boundry.controller;

import com.example.smarthomes.usersettingsservice.boundry.mapper.ObjectMapper;
import com.example.smarthomes.usersettingsservice.boundry.transferobject.UserInformationDTO;
import com.example.smarthomes.usersettingsservice.boundry.transferobject.UserPasswordDTO;
import com.example.smarthomes.usersettingsservice.entity.model.User;
import com.example.smarthomes.usersettingsservice.service.UserService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserSettingsController {

    private final UserService userService;

    @Autowired
    public UserSettingsController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Configured the endpoint to make the PUT Request and update a user's informations
     * @param user The requested user informations encapsulated as a JSON
     * @return A JSON containing the response code of the request
     * @throws JSONException
     */

    @PutMapping(value = "update-user-information")
    @CrossOrigin(origins = "*")
    public String updateUserSettings(@RequestBody UserInformationDTO user) throws JSONException {
        return userService.updateUserInformations(user);
    }

    @PutMapping(value = "update-user-password")
    @CrossOrigin(origins = "*")
    public String updateUserSettingsPassword(@RequestBody UserPasswordDTO userPasswordDTO) throws JSONException {
        return userService.updateUserPassword(userPasswordDTO);
    }
}
