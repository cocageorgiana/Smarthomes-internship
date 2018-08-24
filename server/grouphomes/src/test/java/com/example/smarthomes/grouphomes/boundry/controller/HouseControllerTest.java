package com.example.smarthomes.grouphomes.boundry.controller;

import com.example.smarthomes.grouphomes.service.HouseService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestContext.class, WebAppContext.class})
@WebAppConfiguration
@WebMvcTest(HouseController.class)
public class HouseControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    HouseService houseService;


    @Test
    public void getHouseTest_EntryNotFound() throws Exception {

        mockMvc.perform(get("/get-house/{id}", 100)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }


    @Test
    public void deleteHouseTest_EntryNotFound() throws Exception {

        mockMvc.perform(delete("/delete-house/{id}", 100)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }


    @Test
    public void updateHouseTest_EntryNotFound() throws Exception {

        mockMvc.perform(put("/update-house/{id}", 100)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}