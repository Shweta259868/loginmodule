package com.example.demo.jms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.example.demo.controller.UserController;

@Component
public class Receiver {
	private static final Logger logger = LogManager.getLogger(UserController.class);
  
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        logger.debug("Received <" + message + ">");
       
    }
}