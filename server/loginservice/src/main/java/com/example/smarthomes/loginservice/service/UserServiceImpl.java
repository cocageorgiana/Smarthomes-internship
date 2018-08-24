package com.example.smarthomes.loginservice.service;

import com.example.smarthomes.loginservice.boundry.exceptions.IncorrectCredentialsException;
import com.example.smarthomes.loginservice.boundry.exceptions.UserNotFoundException;
import com.example.smarthomes.loginservice.entity.repository.UserRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Method to check if user credentials exists in the database and a json containing type, message and response code will be sent to the client-side
     * @param userName Username of the password that tries to log in received from the client-side
     * @param password Password of the password that tries to log in received from the client-side
     * @return A json that contains : type : if the request was successful or not, message, status code of the request, response code of the request that is sent to the client-side
     * @throws JSONException
     */

    @Override
    public String findUserByUserNameAndPassword(String userName, String password) throws JSONException {

        JSONObject responseJson = new JSONObject();
        String userDetails = userRepository.returnUserLogin(userName);

        if (userRepository.findUserByUser_nameAndPassword(userName, password) == null) {

            if(userRepository.findUserByUser_name(userName) == null) {

                logger.error(new UserNotFoundException("User does not exist in the database, response status = 404"));
                responseJson.put("Type", "Fail")
                            .put("Message", "User does not exist in the database")
                            .put("status", 400);

            }
            else {

                logger.error(new IncorrectCredentialsException("Entered credentials are not correct"));
                responseJson.put("Type", "Fail")
                        .put("Message", "Incorrect credentials")
                        .put("status", 400);
            }

        }
        else {

            String userEmail = userRepository.returnUserEmailLogin(userName);
            String userFirstName = userRepository.returnUserFirstNameLogin(userName);
            String userLastName = userRepository.returnLastNameLogin(userName);
            String userUserName = userRepository.returmUserNameLogin(userName);

            responseJson.put("Type", "Success")
                         .put("Message", "User logged with success")
                         .put("status", 200)
                         .put("email", userEmail)
                         .put("first_name", userFirstName)
                         .put("last_name", userLastName)
                         .put("user_name", userUserName);
        }

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(String.valueOf(responseJson)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String prettyResponse = gson.toJson(jsonObject);

        return prettyResponse;

    }
}
