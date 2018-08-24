package com.example.smarthomes.loginservice.boundry.controller;

import com.example.smarthomes.loginservice.boundry.exceptions.BadRequestException;
import com.example.smarthomes.loginservice.entity.model.User;
import com.example.smarthomes.loginservice.service.UserService;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;

@RestController
@CrossOrigin
public class LoginController {

    private final UserService userService;

    private static final Logger logger = Logger.getLogger(LoginController.class);


    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Make a post request with the user's credentials in order to be checked and returned a json containing the status code of the request
     * @param user Body necessarily for the request encapsulated in JSON form containing the credentials for the log-in
     * @return The json that contains the response code of the request, result of the request if it is a fail or a succes and the details of the user that will be passed to the client-side
     * @throws JSONException
     * @throws BadRequestException
     */

    @PostMapping(value = "/login")
    String loginUser(@RequestBody  User user) throws JSONException, BadRequestException {

        try {
            return userService.findUserByUserNameAndPassword(user.getUser_name(), user.getPassword());
        }
        catch (ConstraintViolationException ex) {

            logger.error(new BadRequestException(ex.getMessage() + "returned status = 500"));
            throw new BadRequestException(ex.getMessage());
        }
    }

}
