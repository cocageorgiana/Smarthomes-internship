package com.example.smarthomes.newsservice.boundry.controller;

import com.sun.jersey.spi.container.servlet.WebConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mortbay.jetty.webapp.WebAppContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class, WebAppContext.class, WebConfig.class})
@WebAppConfiguration
@WebMvcTest(UserNewsController.class)
public class UserNewsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getNews() throws Exception {

        mockMvc.perform(post("/news", 12)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }

    @Test
    public void getTrendingNews() throws Exception {

        mockMvc.perform(post("/news", 12)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }
}