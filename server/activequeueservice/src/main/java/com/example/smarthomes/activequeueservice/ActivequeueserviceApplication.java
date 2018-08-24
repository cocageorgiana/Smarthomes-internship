package com.example.smarthomes.activequeueservice;

import com.example.smarthomes.activequeueservice.entity.pojo.Email;
import com.example.smarthomes.activequeueservice.interpretor.PythonInterpretor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import javax.script.ScriptException;
import java.io.IOException;

@SpringBootApplication
public class ActivequeueserviceApplication {

    public static void main(String[] args) throws IOException, ScriptException {


        ConfigurableApplicationContext context = SpringApplication.run(ActivequeueserviceApplication.class, args);

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        PythonInterpretor pythonInterpretor = new PythonInterpretor();

        jmsTemplate.convertAndSend("mailbox", pythonInterpretor.processScript1());
        jmsTemplate.convertAndSend("mailbox", pythonInterpretor.processScript2());
    }
}
