package com.globallogic.microservices.world.controller;

import com.globallogic.microservices.world.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.QueryParam;

@RestController
public class HelloWorldController {

    private final RestTemplate restTemplate;
    private final HelloService helloService;

    public HelloWorldController(RestTemplate restTemplate, HelloService helloService) {
        this.restTemplate = restTemplate;
        this.helloService = helloService;
    }

    @GetMapping("/hello-world")
    @HystrixCommand(fallbackMethod = "helloWorldFallback" )
    public String helloWorld(@QueryParam("rt") Boolean rt){
        String result;
        if(rt){
            result = helloService.getHello("World") + " Hello Service";
        }else {
            result = restTemplate.getForObject("http://localhost:8080/hello/World", String.class) + " RestTemplate";
        }
        return result;
    }

    public String helloWorldFallback(Boolean rt){
        return "This is fallback!!!";
    }

}
