package com.example.smarthomes.grouphomes.boundry.controller;

import com.example.smarthomes.grouphomes.service.UserService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "get-all-users")
    @CrossOrigin(origins = "*")
    public String getAllUsers() throws JSONException {
        return userService.getAllUsers();
    }
}
