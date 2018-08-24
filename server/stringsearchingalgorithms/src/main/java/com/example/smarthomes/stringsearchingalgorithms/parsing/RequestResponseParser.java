package com.example.smarthomes.stringsearchingalgorithms.parsing;

import com.example.smarthomes.stringsearchingalgorithms.request.NewsRequest;
import net.htmlparser.jericho.Source;
import org.json.JSONException;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestResponseParser {

    private NewsRequest newsRequest = new NewsRequest();

    /**
     * Extracts only from the URL's from the JSON Response received as result from the GET Request to the Google News API using Regular Expression
     * @param jsonResponse The response for which we want to extract the links
     * @return A list containing all the URL's from the JSON Response mentioned earlier
     */

    public List<String> extractNewsUrls(String jsonResponse) {

        List<String> containedURLs = new ArrayList<>();
        String urlRegex  = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(jsonResponse);

        while(matcher.find()) {
            containedURLs.add(jsonResponse.substring(matcher.start(0), matcher.end(0)));
        }

        return containedURLs;
    }

    /**
     * Parses the content from a URL in order to eliminate the possible remaining HTML tags
     * @param category The category for which the news will be parsed
     * @return The parsed content of the URL
     * @throws IOException
     * @throws JSONException
     */

    public String extractURLText(String category) throws IOException, JSONException {

        List<String> urlList = extractNewsUrls(newsRequest.getAPIResponse(category));
        String currentText = null;

        for (String it : urlList) {
            try {
                currentText = newsRequest.makeGenericRequest(it);
            }
            catch (Exception ignored) {
            }
        }

        Source source = new Source(currentText);

       /* System.out.println(source.getTextExtractor().toString().replaceAll("(<.*?>)|(&.*?;)|([ ]{2,})", ""));*/
        return source.getTextExtractor().toString().replaceAll("(<.*?>)|(&.*?;)|([ ]{2,})", "");
    }
}
