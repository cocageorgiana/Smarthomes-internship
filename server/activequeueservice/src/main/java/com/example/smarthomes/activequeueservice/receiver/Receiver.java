package com.example.smarthomes.activequeueservice.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Receiver {

    /**
     * Basic receiver that prints all the messages that came in the active queue
     * @param result The messages that are in queue
     */

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(String result) {

        System.out.println("Received: " + result);

    }
}
