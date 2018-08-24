package com.example.smarthomes.grouphomes.boundry.controller;

import com.example.smarthomes.grouphomes.service.GroupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mortbay.jetty.webapp.WebAppContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestContext.class, WebAppContext.class})
@WebAppConfiguration
@WebMvcTest(GroupController.class)
public class GroupControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    GroupService groupService;


    @Test
    public void getGroupTest_EntryNotFound() throws Exception {

        mockMvc.perform(get("/get-group/{id}", 100)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }


    @Test
    public void deleteGropTest_EntryNotFound() throws Exception {

        mockMvc.perform(delete("/delete-group/{id}", 100)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }


    @Test
    public void updateGroupTest_EntryNotFound() throws Exception {

        mockMvc.perform(put("/update-group/{id}", 100)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

}