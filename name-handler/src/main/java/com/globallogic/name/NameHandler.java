package com.globallogic.name;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding(Processor.class)
public class NameHandler {

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public String handler(String name){
        return name.trim().toUpperCase();
    }

    public static void main(String[] args) {
        SpringApplication.run(NameHandler.class, args);
    }
}
