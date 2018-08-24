package com.example.smarthomes.trafficservice.boundry.controller;

import com.example.smarthomes.trafficservice.service.TrafficService;
import org.json.JSONException;
import org.junit.Assert;
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

import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestContext.class, WebAppContext.class})
@WebAppConfiguration
@WebMvcTest(TrafficController.class)
public class TrafficControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TrafficService trafficService;


    @Test
    public void getRouteTest_RequestSuccessful() throws Exception {

        String home = "Bacau";
        String destination = "Iasi";
        String API_KEY = "ttPFVWcSkTfAuq1R0Q815Nikoj8bvAVf";

        String homeFormatted = "\"" +  home +  "\"";
        String destinationFormatted = "\"" + destination + "\"";

        mockMvc.perform(get("traffic/{home}/{destination}", "home", "destination"))
                .andExpect(status().isNotFound());
        Assert.assertEquals("home and destination", home, destination);

    }
}