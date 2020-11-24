package com.beyond233.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.security.auth.message.callback.PrivateKeyCallback;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/query")
public class CustomerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/id")
    public Map<String, String> queryID() {
        String id = "233";
        return restTemplate.getForObject("http://localhost:8080/goods/id?id={id}", Map.class, id);
    }

    @GetMapping("/kind")
    public Map<String, String> queryKind() {
        String id = "233";
        String kind = "cola";
        return restTemplate.getForObject("http://localhost:8080/goods/kind?id={id}&kind={kind}", Map.class, id, kind);
    }

}
