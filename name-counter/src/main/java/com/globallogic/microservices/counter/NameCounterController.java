package com.globallogic.microservices.counter;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class NameCounterController {
    private Map<String, Integer> nameAmount = new HashMap<>();

    @StreamListener(Sink.INPUT)
    public void nameCount(String name) {
        Integer amount = nameAmount.getOrDefault(name, 0);
        nameAmount.put(name, ++amount);
    }

    @GetMapping("/{name}/amount")
    public String getNameAmount(@PathVariable String name){
        return nameAmount.getOrDefault(name,0).toString();
    }
}
