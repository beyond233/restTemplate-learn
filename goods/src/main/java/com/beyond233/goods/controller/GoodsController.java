package com.beyond233.goods.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @GetMapping("/id")
    public void  name(@RequestParam("id") String id, HttpServletResponse response) throws IOException {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", id);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(JSON.toJSONString(map));
    }

    @GetMapping("/kind")
    public void info(@RequestParam("id") String id,@RequestParam("kind") String kind,HttpServletResponse response) throws IOException {
        HashMap<String, String> map = new HashMap<>(2);
        map.put("id", id);
        map.put("kind", kind);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(JSON.toJSONString(map));
    }
}
