package com.example.smarthomes.parallelprocessingservice.interpretor;

import org.omg.SendingContext.RunTime;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.script.*;
import java.io.*;

@Component
public class PythonInterpretor {

    /**
     * Executes a python script by creating the command necessarily to compile a python script and build the output line by line
     * @return The actual output of the python script
     * @throws IOException
     * @throws ScriptException
     */

    @PostConstruct
    public String processScript1() throws IOException, ScriptException {

        String pythonScriptPath1 = "C:\\Users\\victor.manoliu\\Desktop\\intern\\server\\parallelprocessingservice\\src\\main\\resources\\scripts\\hello1.py";

        String[] cmd = new String[2];
        cmd[0] = "C:\\Program Files (x86)\\Python37-32\\python.exe";
        cmd[1] = pythonScriptPath1;

        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(cmd);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";

        StringBuilder builder = null;
        builder = new StringBuilder();

        while((line = bufferedReader.readLine()) != null) {
            builder.append(line);
            System.out.println("TEST " + line);
        }
        return builder.toString();
    }

    @PostConstruct
    public String processScript2() throws IOException {

        String pythonScriptPath2 = "C:\\Users\\victor.manoliu\\Desktop\\intern\\server\\parallelprocessingservice\\src\\main\\resources\\scripts\\hello2.py";

        String[] cmd = new String[2];
        cmd[0] = "C:\\Program Files (x86)\\Python37-32\\python.exe";
        cmd[1] = pythonScriptPath2;

        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(cmd);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";

        StringBuilder builder = new StringBuilder();

        while((line = bufferedReader.readLine()) != null) {
            builder.append(line);
            System.out.println("TEST " + line);
        }
        return builder.toString();
    }

}
