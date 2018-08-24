package com.example.smarthomes.loginservice.service;

import org.json.JSONException;

public interface UserService {

    /**
     * Method to check if user credentials exists in the database
     * @param userName Username of the password that tries to log in received from the client-side
     * @param password Password of the password that tries to log in received from the client-side
     * @return A json that contains : type : if the request was successful or not, message, status code of the request, response code of the request that is sent to the client-side
     * @throws JSONException
     */

    String findUserByUserNameAndPassword(String userName, String password) throws JSONException;
}
