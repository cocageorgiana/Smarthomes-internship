package com.example.smarthomes.usersettingsservice.boundry.mapper;

import com.example.smarthomes.usersettingsservice.entity.model.User;

public class ObjectMapper {

    /**
     * Manual mapper in order to set the attributes in the database by mapping the Entity received as input and the Entity already existing in the database
     * @param user1 The entity that exists in the database
     * @param user2 The inputed entity
     */

    public static void map2User(User user1, User user2) {
       /* user1.setId_user(user2.getId_user());*/
        user1.setFirst_name(user2.getFirst_name());
        user1.setLast_name(user2.getLast_name());
        user1.setEmail(user2.getEmail());
        user1.setNewPassword(user2.getNewPassword());
    }
}
