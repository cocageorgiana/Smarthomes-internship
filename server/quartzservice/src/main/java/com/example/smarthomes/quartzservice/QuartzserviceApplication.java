package com.example.smarthomes.quartzservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan
public class QuartzserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuartzserviceApplication.class, args);
    }
}
