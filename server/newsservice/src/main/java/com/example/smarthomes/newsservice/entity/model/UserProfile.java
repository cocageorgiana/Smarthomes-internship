package com.example.smarthomes.newsservice.entity.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;


/**
 * POJO to encapsulate the the topic for which we will obtain the news
 */

public class UserProfile {

    private String topic;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
