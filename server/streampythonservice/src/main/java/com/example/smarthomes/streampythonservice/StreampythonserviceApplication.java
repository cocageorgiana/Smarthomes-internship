package com.example.smarthomes.streampythonservice;

import com.example.smarthomes.streampythonservice.reader.FileProcessor;
import com.example.smarthomes.streampythonservice.stream.StreamTraining;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.StreamTokenizer;

@SpringBootApplication
public class StreampythonserviceApplication {

    public static void main(String[] args) throws IOException {

        FileProcessor fileProcessor = new FileProcessor();
        fileProcessor.readFromFile();

        StreamTraining streamTraining = new StreamTraining();
        streamTraining.removeOddNumbers();
        System.out.println();
        streamTraining.removeEvenNumbers();
        System.out.println();
        streamTraining.findMax();
        System.out.println();
        streamTraining.findSum();
        System.out.println();
        streamTraining.generateList();
        System.out.println();
        streamTraining.findElement(10);
        System.out.println();
        streamTraining.sortList();
        System.out.println();
        streamTraining.findSumFunctional();
        System.out.println();
        streamTraining.findNumbersLessThan(30);
        System.out.println();
        streamTraining.convertToMap();
        System.out.println();
        streamTraining.findProduct();
        System.out.println();
        streamTraining.printNumbersWithLastDigit(9);
        System.out.println();
        streamTraining.countElements();

        SpringApplication.run(StreampythonserviceApplication.class, args);
    }
}
