package com.beyond233.customer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
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
    public Object queryID() {
        String id = "233";
        String resp = restTemplate.getForObject("http://localhost:8080/goods/id?id={id}", String.class, id);
        Map<String, String> map = JSON.parseObject(resp, new TypeReference<Map<String, String>>() {});
        String id1 = map.get("id");

        return map;
    }

    @GetMapping("/kind")
    public Map<String, Object> queryKind() {
        String id = "233";
        String kind = "cola";
        String respJson = restTemplate.getForObject("http://localhost:8080/goods/kind?id={id}&kind={kind}", String.class, id, kind);
        Map<String, Object> map = JSON.parseObject(respJson, new TypeReference<Map<String, Object>>() {
        });
        return map;
    }

}
