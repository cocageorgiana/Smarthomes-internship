package com.example.smarthomes.trafficservice.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
public class TrafficServiceImpl implements TrafficService {

    private final String API_KEY = "ttPFVWcSkTfAuq1R0Q815Nikoj8bvAVf";
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final Logger logger = Logger.getLogger(TrafficServiceImpl.class);

    /**
     * Makes a GET Request to the MAP API in order to get informations about traffic between the points , the actual road etc
     * @param home The start location
     * @param destination The destination location
     * @return A JSON containing the all the traffic informations that is sent to the client-side
     * @throws IOException
     * @throws JSONException
     */

    @Override
    public String getRoute(String home, String destination) throws IOException, JSONException {

        String homeFormatted = "\"" +  home +  "\"";
        String destinationFormatted = "\"" + destination + "\"";

        URL url = new URL("http://www.mapquestapi.com/directions/v2/optimizedroute?key=" + API_KEY + "&json={\"locations\":[" + homeFormatted + "" + "," + "" + destinationFormatted + "" + "]}" );


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
                logger.error(new Exception(String.format("GET Request to the Map Quest API failled with the response code=%s", responseCode)));
                throw new Exception(String.format("GET Request to the Map Quest API failled with the response code=%s", responseCode));
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
