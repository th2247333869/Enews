package com.news.demo.module.Schedule;

import com.news.demo.Utils.ApplicationContextUtil;
import com.news.demo.model.Commdity;
import com.news.demo.service.impl.CommdityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Component
@EnableScheduling   // 2.开启定时任务
public class StaticScheduleTask {
    //1	时尚穿搭	1	1	../../images/p1.jpeg	简单和干净舒服，舒服之间其实就差一些细节	14	24	2019-08-07 20:59:38	1
    private static Map map = new HashMap();

    private static List<Commdity> commdityList = new ArrayList<>();

    @Autowired
    CommdityServiceImpl commdityService ;

    //1.添加定时任务
    @Scheduled(cron = "0 0 2 * * ?")//凌晨两点执行
    //@Scheduled(cron = "0/10 * * * * ?")
    private void configureTasks() {
        try {
            //暂时默认赋值
            Commdity commdity = new Commdity();
            for(int i=0,length = 5;i<length;i++){
                commdity.setName("时尚穿搭");
                commdity.setCode("1");
                commdity.setType("1");
                commdity.setState("1");
                commdity.setImageUrl("../../images/p1.jpeg");
                commdity.setTitle("简单和干净舒服，舒服之间其实就差一些细节-第"+i+"条数据");
                commdity.setUserId(14);
                commdity.setCompliments(24);
                commdity.setDate(new Date());
                commdityList.add(commdity);
            }
            commdityService.saveCommmditysPageNotics(commdityList);
        }catch (Exception e){
            System.err.println("定时任务执行出错 " + LocalDateTime.now()+",执行静态定时任务方法：configureTasks");
            e.printStackTrace();
        }finally {
            System.err.println("执行静态定时任务时间: " + LocalDateTime.now()+",执行静态定时任务方法：configureTasks");
        }
    }
}
