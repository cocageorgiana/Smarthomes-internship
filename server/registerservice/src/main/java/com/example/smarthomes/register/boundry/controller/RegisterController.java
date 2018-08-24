package com.example.smarthomes.register.boundry.controller;

import com.example.smarthomes.register.boundry.exceptions.BadRequestException;
import com.example.smarthomes.register.boundry.exceptions.EmailAlreadyExists;
import com.example.smarthomes.register.boundry.exceptions.UserNameAlreadyExists;
import com.example.smarthomes.register.entity.model.User;
import com.example.smarthomes.register.service.UserService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import org.apache.log4j.Logger;

@RestController
@CrossOrigin
public class RegisterController {

    private final UserService userService;

    private static final Logger logger = Logger.getLogger(RegisterController.class);

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "register", method = RequestMethod.POST,  produces = {MediaType.APPLICATION_JSON_VALUE})
    @PostMapping
    public String saveUser(@RequestBody User user) throws BadRequestException, EmailAlreadyExists, JSONException, UserNameAlreadyExists {
        String userReturned = null;

        if (userService.mailAlreadyExists(user.getEmail())) {
            logger.error(new Exception(String.format("Registration failed with response code = %s, email already exists", 403)));
            throw new EmailAlreadyExists("Email already exists");
        }

        if(userService.userNameAlreadyExists(user.getUser_name())) {
            logger.error(new Exception(String.format("Registration failed with response code = %s, user name already exists", 403)));
            throw new UserNameAlreadyExists("User name already exists");
        }

        try {
            userReturned = userService.saveUser(user);
        } catch (ConstraintViolationException ex) {
            logger.error(new Exception(String.format("Registration failed with response code = %s, constraint violated", 500)));
            throw new BadRequestException(ex.getMessage());
        }

        return userReturned;
    }


}
