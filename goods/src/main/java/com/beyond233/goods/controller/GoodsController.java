package com.beyond233.goods.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @GetMapping("/id")
    public Map<String, String> name(@RequestParam("id") String id) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", id);
        return map;
    }

    @GetMapping("/kind")
    public Map<String, String> info(@RequestParam("id") String id,@RequestParam("kind") String kind) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("kind", kind);
        return map;
    }
}
