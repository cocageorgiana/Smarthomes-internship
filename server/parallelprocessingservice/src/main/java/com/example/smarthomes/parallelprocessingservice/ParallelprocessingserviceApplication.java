package com.example.smarthomes.parallelprocessingservice;

import com.example.smarthomes.parallelprocessingservice.interpretor.PythonInterpretor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootApplication
@ComponentScan
public class ParallelprocessingserviceApplication {

    public static void main(String[] args) {

        SpringApplication.run(ParallelprocessingserviceApplication.class, args);
    }
}
