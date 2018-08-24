package com.example.smarthomes.streampythonservice.reader;

import com.example.smarthomes.streampythonservice.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Component
@PropertySource("application.properties")
public class FileProcessor {

    String filePath = "C:\\Users\\victor.manoliu\\Desktop\\intern-master\\server\\streampythonservice\\src\\main\\resources\\scripts\\numbers.txt";

    @Autowired
    private final AppConfig appConfig = null;

    public List<Integer> readFromFile() throws IOException {

        List<Integer> numbersList = Files.lines(Paths.get(filePath)).map(Integer::parseInt).collect(Collectors.toList());
        return numbersList;
    }
}
