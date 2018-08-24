package com.example.smarthomes.grouphomes.boundry.controller;

import com.example.smarthomes.grouphomes.boundry.exceptions.BadRequestException;
import com.example.smarthomes.grouphomes.boundry.exceptions.NotFoundException;
import com.example.smarthomes.grouphomes.boundry.mapper.ObjectMapper;
import com.example.smarthomes.grouphomes.boundry.transferobject.GroupDTO;
import com.example.smarthomes.grouphomes.entity.model.Group;
import com.example.smarthomes.grouphomes.service.GroupService;
import com.example.smarthomes.grouphomes.service.HouseService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class GroupController {

    private final static Logger logger = Logger.getLogger(GroupController.class);

    @Autowired
    private final GroupService groupService;
    private final HouseService houseService;
    private JavaMailSender javaMailSender;


    public GroupController(GroupService groupService, HouseService houseService, JavaMailSender javaMailSender) {
        this.groupService = groupService;
        this.houseService = houseService;
        this.javaMailSender = javaMailSender;
    }

    @PostMapping(value = "save-group")
    public String saveGroup(@RequestBody GroupDTO group) throws JSONException {

        return groupService.saveGroup(group);
    }

    @PostMapping(value = "delete-group")
    public String deleteGroup(@RequestBody GroupDTO group) throws JSONException {

        return groupService.deleteGroup(group);
    }

}
