package com.beyond233.customer.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * 描述: 定时任务
 *
 * @author beyond233
 * @since 2020/11/26 20:32
 */
@Configuration
@EnableScheduling
@Slf4j
public class SaveGoodsTask {

    @Autowired
    private RestTemplate restTemplate;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void save() {
        String id = "233";
        String kind = "cola";
        String respJson = restTemplate.getForObject("http://localhost:8080/goods/kind?id={id}&kind={kind}", String.class, id, kind);
        Map<String, Object> map = JSON.parseObject(respJson, new TypeReference<Map<String, Object>>() {
        });

        log.info(map.toString());

    }



}
