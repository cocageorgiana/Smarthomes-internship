package com.example.smarthomes.grouphomes.service;

import com.example.smarthomes.grouphomes.boundry.transferobject.GroupDTO;
import com.example.smarthomes.grouphomes.entity.embeddable.CurrentLoggedUser;
import org.json.JSONException;

public interface GroupService {

    String saveGroup(GroupDTO group) throws JSONException;

    String deleteGroup(GroupDTO group) throws JSONException;

    String getGroupForUser(CurrentLoggedUser currentLoggedUser);
}
