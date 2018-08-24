package com.example.smarthomes.stringsearchingalgorithms.request;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NewsRequest {

    private static final String USER_AGENT = "Mozilla/5.0";


    /**
     * Uses Jsoup in order to make a Request to an URL and get all the content text from that URL
     * @param urlLink The link for which we want to make the request
     * @return The actual content in text format of the link
     * @throws JSONException
     * @throws IOException
     */

    public String makeGenericRequest(String urlLink) throws JSONException, IOException {

        Document document = Jsoup.connect(urlLink)
                                 .header("Accept-Encoding",  "gzip, deflate")
                                 .userAgent(USER_AGENT)
                                 .maxBodySize(0)
                                 .timeout(600000)
                                 .get();

        System.out.println(document.text());
        return document.text();

    }


    /**
     * Makes a GET Request to the Google News API in order to get the trending news for a specific category
     * @param category The category for which we want to receive the trending news
     * @return A json containing a list of multiple objects, each one being a news for a specific category
     * @throws IOException
     * @throws JSONException
     */

    public String getAPIResponse(String category) throws IOException, JSONException {


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
}
