package com.example.smarthomes.newsservice.service;

import com.example.smarthomes.newsservice.boundry.exceptions.NewsGenericException;
import com.google.gson.*;
import com.google.gson.JsonParser;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


@Service
public class UserProfileServiceImpl implements UserProfileService {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final Logger logger = Logger.getLogger(UserProfileServiceImpl.class);

    /**
     * Makes a GET Request to the Google News API for a specific topic
     * @param category The category for which we want to find out the most recent news
     * @return A JSON containing the most recent articles of news for that topic
     * @throws IOException
     * @throws JSONException
     */


    @Override
    public String getNews(String category) throws IOException, JSONException {

        URL url = new URL("https://newsapi.org/v2/top-headlines?category=" + category + "&country=us&sortBy=popularity&apiKey=fb9269ad31cc4a86be0f06b2e8c23723");

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = urlConnection.getResponseCode();

        StringBuilder builder = null;
        if (responseCode == HttpURLConnection.HTTP_OK) {

            String line;
            builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

        } else {

            try {
                logger.error(new NewsGenericException(String.format("GET Request to the Google News API failed with status code=%s", responseCode)));
                throw new Exception("GET REQUEST NOT WORKED");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        JSONObject jsonObject = new JSONObject(builder.toString());

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject1 = jsonParser.parse(String.valueOf(jsonObject)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(jsonObject1);

        return prettyJson;
    }


    /**
     * Makes a GET Request to the Google News API for the trending news at that period
     * @return A JSON containing the most recent articles of trending news
     * @throws IOException
     * @throws JSONException
     */

    @Override
    public String getTrendingNews() throws IOException, JSONException {

        URL url = null;
        try {
            url = new URL("https://newsapi.org/v2/top-headlines?sources=cnn&apiKey=fb9269ad31cc4a86be0f06b2e8c23723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = urlConnection.getResponseCode();

        StringBuilder builder = null;
        if (responseCode == HttpURLConnection.HTTP_OK) {

            String line;
            builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

        } else {

            try {
                logger.error(new NewsGenericException(String.format("GET Request to the Google News API failed with status code=%s", responseCode)));
                throw new NewsGenericException("GET REQUEST NOT WORKED");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        JSONObject jsonObject = new JSONObject(builder.toString());

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject1 = jsonParser.parse(String.valueOf(jsonObject)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(jsonObject1);

        return prettyJson;
    }
}
