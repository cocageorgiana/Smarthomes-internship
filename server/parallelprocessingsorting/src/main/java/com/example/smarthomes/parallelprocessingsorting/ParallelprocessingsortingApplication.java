package com.example.smarthomes.parallelprocessingsorting;

import com.example.smarthomes.parallelprocessingsorting.interpretor.PythonInterpretor;
import com.example.smarthomes.parallelprocessingsorting.sorting.SortingAlgorithms;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.Arrays;

@SpringBootApplication
public class ParallelprocessingsortingApplication {

    public static void main(String[] args) throws IOException, ScriptException {

        SpringApplication.run(ParallelprocessingsortingApplication.class, args);
    }
}
