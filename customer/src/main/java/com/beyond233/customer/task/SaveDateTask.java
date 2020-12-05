package com.beyond233.customer.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 描述:
 *
 * @author beyond233
 * @since 2020/12/5 18:11
 */
@Configuration
@EnableScheduling
public class SaveDateTask implements SchedulingConfigurer {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
                this::task,
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    String cron = "0 0/" + 1 + " * * * ?";

                    if (StringUtils.isEmpty(cron)) {
                        // Omitted Code ..
                        cron = "0 0/" + 1 + " * * * ?";
                    }
                    //2.3 返回执行周期(Date)
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );

    }

    public void task() {
        System.out.println("执行动态定时任务: " + LocalDateTime.now().toLocalTime());
        String id = "233";
        String kind = "cola";
        String respJson = restTemplate.getForObject("http://localhost:8080/goods/kind?id={id}&kind={kind}", String.class, id, kind);
        Map<String, Object> map = JSON.parseObject(respJson, new TypeReference<Map<String, Object>>() {
        });
        System.out.println(map);
    }

}
