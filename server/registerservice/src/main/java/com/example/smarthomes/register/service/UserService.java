package com.example.smarthomes.register.service;

import com.example.smarthomes.register.entity.model.User;
import org.json.JSONException;

public interface UserService {

    String saveUser(User user) throws JSONException;

    boolean mailAlreadyExists(String email);

    boolean userNameAlreadyExists(String userName);
}
