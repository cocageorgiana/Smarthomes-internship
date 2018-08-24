package com.example.smarthomes.soapservice.repository;

import com.example.smarthomes.soapservice.article.Article;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class ArticleRepository  {

    private static final Map<String, Article> articles = new HashMap<>();

    /**
     * Creates a map with hard-codded data in order to test the basic SOAP Request
     */

    @PostConstruct
    public void initData() {

        Article myArticle = new Article();
        myArticle.setId(1);
        myArticle.setTitle("intern");
        myArticle.setAuthor("Ceausescu");
        myArticle.setText("Ceva");
        myArticle.setYear(1990);

        articles.put(myArticle.getTitle(), myArticle);
    }

    public Article findArticle(String title) {
        Assert.notNull(title, "The com.example.smarthomes.soapservice.com.example.smarthomes.soapservice.article's title cannot be null");
        return articles.get(title);
    }
}
