package com.example.smarthomes.weatherservice.service;

import com.example.smarthomes.weatherservice.boundry.exceptions.WeatherGenericException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class WeatherServiceImpl implements WeatherService {

    private static final String USER_AGENT = "Mozilla/5.0";

    private static final Logger logger = Logger.getLogger(WeatherServiceImpl.class);

    /**
     * Makes a GET Request to the AccuWeather API in order to get all the weather informations for todday
     * @return A JSON containing all the weather informations
     * @throws IOException
     * @throws JSONException
     */

    @Override
    public String getForecastPerDay() throws IOException, JSONException {

        URL url = new URL("http://dataservice.accuweather.com/forecasts/v1/daily/" + "1" + "day/287430?apikey=jfKn0RHyejIIk5PkPMsnKLrGTmm0CrD8");

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
                logger.error(new WeatherGenericException(String.format("GET Request to the Accu-Weather API failed with status code=%s", responseCode)));
                throw new WeatherGenericException(String.format("GET Request to the Accu-Weather API failed with status code=%s", responseCode));
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
     * Makes a GET Request to the AccuWeather API in order to get all the weather informations for a number of hours
     * @return A JSON containing all the weather informations
     * @throws IOException
     * @throws JSONException
     */

    @Override
    public String getForecastPerHour(Integer numberOfHours) throws JSONException, IOException {

        URL url = new URL("http://dataservice.accuweather.com/forecasts/v1/hourly/" + String.valueOf(numberOfHours) + "hour/287430?apikey=jfKn0RHyejIIk5PkPMsnKLrGTmm0CrD8");

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
                logger.error(new WeatherGenericException(String.format("GET Request to the AccuWeather API failed with status code=%s", responseCode)));
                throw new WeatherGenericException(String.format("GET Request to the Accu-Weather API failed with status code=%s", responseCode));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        String auxBuilder = StringUtils.chomp(builder.toString());
        auxBuilder = StringUtils.removeStart(auxBuilder, "[");

        JSONObject jsonObject = new JSONObject(auxBuilder);

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject1 = jsonParser.parse(String.valueOf(jsonObject)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(jsonObject1);

        System.out.println(prettyJson);

        return prettyJson;

    }
}
