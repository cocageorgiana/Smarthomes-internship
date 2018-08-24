package com.example.smarthomes.parallelprocessingsorting.interpretor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@PropertySource("classpath:scripts.properties")
public class PythonInterpretor {

    /*@Value("${script1}")*/
    private String pythonScriptPath1 = "C:\\Users\\victor.manoliu\\Desktop\\intern-master\\server\\parallelprocessingsorting\\src\\main\\resources\\scripts\\script1.py";

    @Value("${script2}")
    private String pythonScriptPath2 = "C:\\Users\\victor.manoliu\\Desktop\\intern-master\\server\\parallelprocessingsorting\\src\\main\\resources\\scripts\\script2.py";

    /*@Value("${pythonpath}")*/
    private String pythonExePath = "C:\\Program Files (x86)\\Python37-32\\python.exe";


    /**
     * Executes a python script by creating the command necessarily to compile a python script and build the output line by line
     * @return The actual output of the python script
     * @throws IOException
     * @throws ScriptException
     */

    @PostConstruct
    public int[] processScript1() throws IOException, ScriptException {

        String[] cmd = new String[2];
        cmd[0] = pythonExePath;
        cmd[1] = pythonScriptPath1;

        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(cmd);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";

        StringBuilder builder = null;
        builder = new StringBuilder();

        List<String> finalList = new ArrayList<>();

        while((line = bufferedReader.readLine()) != null) {
            /*System.out.println(line);*/
            builder.append(line);
            finalList.add(line);
        }

        String[] integerStrings = String.valueOf(finalList).replace("[","").replace("]", "").split(", ");

        int[] integers = new int[integerStrings.length];

        for(int i=0; i<integers.length; i++) {
            try {
                integers[i] = Integer.valueOf(integerStrings[i]);
            }catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        return integers;
    }

    @PostConstruct
    public int[] processScript2() throws IOException {

        String[] cmd = new String[2];
        cmd[0] = pythonExePath;
        cmd[1] = pythonScriptPath2;

        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(cmd);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";

        StringBuilder builder = null;
        builder = new StringBuilder();

        List<String> finalList = new ArrayList<>();

        while((line = bufferedReader.readLine()) != null) {
            /*System.out.println(line);*/
            builder.append(line);
            finalList.add(line);
        }


        String aux = String.valueOf(finalList);

        String[] integerStrings = aux.replaceAll("\\[","").replaceAll("\\]", "").split(" ");

        int[] integers = new int[integerStrings.length];

        for(int i=0; i<integers.length; i++) {
            try {
                integers[i] = Integer.valueOf(integerStrings[i]);
            }catch (NumberFormatException e) {
                System.out.println(e.getMessage() + " FAIL");
            }
        }
        return integers;
    }
}
