package com.globallogic.microservices.world.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("HELLO")
public interface HelloService {

    @GetMapping(value = "/hello/{name}")
    String getHello(@PathVariable("name") String name);
}
