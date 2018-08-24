package com.example.smarthomes.usersettingsservice.service;

import com.example.smarthomes.usersettingsservice.boundry.transferobject.UserInformationDTO;
import com.example.smarthomes.usersettingsservice.boundry.transferobject.UserPasswordDTO;
import com.example.smarthomes.usersettingsservice.entity.model.User;
import org.json.JSONException;

public interface UserService {


    String updateUserInformations(UserInformationDTO userInformationDTO) throws JSONException;

    String updateUserPassword(UserPasswordDTO userPasswordDTO) throws JSONException;

}
