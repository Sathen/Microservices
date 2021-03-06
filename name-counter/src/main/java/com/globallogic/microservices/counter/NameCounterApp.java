package com.globallogic.microservices.counter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
@EnableDiscoveryClient
public class NameCounterApp {

    public static void main(String[] args) {
        SpringApplication.run(NameCounterApp.class, args);
    }
}
