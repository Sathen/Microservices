package com.globallogic.hello.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return prefix+" "+name+suffix;
    }
}
