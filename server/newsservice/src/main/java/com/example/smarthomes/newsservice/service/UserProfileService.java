package com.example.smarthomes.newsservice.service;

import org.json.JSONException;

import java.io.IOException;

public interface UserProfileService {

    /**
     * Makes a GET Request to the Google News API for a specific topic
     * @param category The category for which we want to find out the most recent news
     * @return A JSON containing the most recent articles of news for that topic
     * @throws IOException
     * @throws JSONException
     */

    String getNews(String category) throws IOException, JSONException;

    /**
     * Makes a GET Request to the Google News API for the trending news at that period
     * @return A JSON containing the most recent articles of trending news
     * @throws IOException
     * @throws JSONException
     */

    String getTrendingNews() throws IOException, JSONException;
}
