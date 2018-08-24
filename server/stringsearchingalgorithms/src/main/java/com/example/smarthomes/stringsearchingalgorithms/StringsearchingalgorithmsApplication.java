package com.example.smarthomes.stringsearchingalgorithms;

import com.example.smarthomes.stringsearchingalgorithms.parsing.RequestResponseParser;
import com.example.smarthomes.stringsearchingalgorithms.request.NewsRequest;
import com.example.smarthomes.stringsearchingalgorithms.searching.BoyerMooreBadCharacter;
import com.example.smarthomes.stringsearchingalgorithms.searching.KMP;
import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class StringsearchingalgorithmsApplication {

    public static void main(String[] args) {

        String pattern = "Brexit";
        String text = "";
        RequestResponseParser requestResponseParser = new RequestResponseParser();

        BoyerMooreBadCharacter boyerMooreBadCharacter = new BoyerMooreBadCharacter(pattern);
        KMP kmp = new KMP(pattern);

        int indexFoundBoyer;
        int indexFoundKMP;

        Long timeOfStart = System.currentTimeMillis();
        try {
            text = requestResponseParser.extractURLText("business");
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        indexFoundBoyer = boyerMooreBadCharacter.search(text);
        /*indexFoundKMP = kmp.search(text);*/

        System.out.println("Found at index using Boyer-Moore: " + indexFoundBoyer);
       /* System.out.println("Found at index using KMP: " + indexFoundKMP);*/

        System.out.println("Time elapsed for searching and processing: " + String.valueOf(System.currentTimeMillis() - timeOfStart));

        SpringApplication.run(StringsearchingalgorithmsApplication.class, args);
    }
}
