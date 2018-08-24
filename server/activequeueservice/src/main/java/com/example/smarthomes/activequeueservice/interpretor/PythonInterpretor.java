package com.example.smarthomes.activequeueservice.interpretor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
@PropertySource("classpath:mypython.properties")
public class PythonInterpretor {

    @Value("${script1}")
    String pythonScriptPath1;

    @Value("${script2}")
    String pythonScriptPath2;

    @Value("${pythonpath}")
    String pythonExePath;

    /**
     * Executes a python script by creating the command necessarily to compile a python script and build the output line by line
     * @return The actual output of the python script
     * @throws IOException
     * @throws ScriptException
     */

    @PostConstruct
    public String processScript1() throws IOException, ScriptException {

        System.out.println(pythonExePath + " " + pythonScriptPath1);

        String[] cmd = new String[2];
        cmd[0] = pythonExePath;
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

    /**
     * Executes a python script by creating the command necessarily to compile a python script and build the output line by line. The output will be send to the active queue
     * @return The actual output of the python script
     * @throws IOException
     * @throws ScriptException
     */

    @PostConstruct
    public String processScript2() throws IOException {

        String[] cmd = new String[2];
        cmd[0] = pythonExePath;
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
