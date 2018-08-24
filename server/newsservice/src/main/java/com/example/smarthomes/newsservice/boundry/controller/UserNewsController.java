package com.example.smarthomes.newsservice.boundry.controller;

import com.example.smarthomes.newsservice.entity.model.UserProfile;
import com.example.smarthomes.newsservice.service.UserProfileService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin
public class UserNewsController {

    private final UserProfileService newsService;

    @Autowired
    public UserNewsController(UserProfileService newsService) {
        this.newsService = newsService;
    }


    /**
     * Sends a post request containing the choice of topic for which to make the GET Request
     * @param userProfile The choice of topic for which we want to get the news
     * @return A JSON containing the trending news or the news for a specific topic
     * @throws IOException
     * @throws JSONException
     */

    @PostMapping(value = "news")
    @CrossOrigin(origins = "*")
    public String getTrendingNews(@RequestBody UserProfile userProfile) throws IOException, JSONException {

        if (userProfile.getTopic().equals("trending")) {
            return newsService.getTrendingNews();
        }
        else {
            return newsService.getNews(userProfile.getTopic());
        }

    }
}
