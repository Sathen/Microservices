package com.globallogic.hello.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {

    @Value("${hello.prefix}")
    private String prefix;
    @Value("${hello.suffix}")
    private String suffix;

    private MessageChannel output;

    public HelloController(MessageChannel output) {
        this.output = output;
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        output.send(MessageBuilder.withPayload(name).build());
        return prefix+" "+name+suffix;
    }
}
