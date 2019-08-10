package com.news.demo.module.Schedule;

import com.news.demo.Utils.ApplicationContextUtil;
import com.news.demo.Utils.MongoDB.MongodbUtils;
import com.news.demo.Utils.commonUtils;
import com.news.demo.mapper.CommdityMapper;
import com.news.demo.model.Commdity;
import com.news.demo.model.MongoDbModel.CommdityDb;
import com.news.demo.service.BaseManager.BaseCommdityManager;
import com.news.demo.service.impl.CommdityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.query.Criteria;
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
    @Autowired
    private CommdityMapper commdityMapper;

    //1.添加定时任务
    @Scheduled(cron = "0 0 2 * * ?")//凌晨两点执行
    //@Scheduled(cron = "0/10 * * * * ?")
    private void configureTasks1() {
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
            System.err.println("定时任务执行出错 " + LocalDateTime.now()+",执行静态定时任务方法：configureTasks1");
            e.printStackTrace();
        }finally {
            System.err.println("执行静态定时任务时间: " + LocalDateTime.now()+",执行静态定时任务方法：configureTasks1");
        }
    }

    //1.添加定时任务
    //@Scheduled(cron = "0 0 3 * * ?")//凌晨三点执行
    @Scheduled(cron = "0/15 * * * * ?")
    private void configureTasks2() {
        try {
            /**
             *
             * 查询缓存数据库是否加载了当前最新缓存数据
             */
            Criteria criteria1 = Criteria.where("date").gte(commonUtils.getStrNow());
            Criteria criteria2 = Criteria.where("state").is("1");
            Criteria[] criterias = new Criteria[]{criteria1,criteria2};
            List<CommdityDb> colList = (List<CommdityDb>) MongodbUtils.find(criterias,new CommdityDb());
            //如果没有当天数据则插入当天数据 -- 批量插入
            Object c = new CommdityDb();
            if(commonUtils.ofEmpty(colList)){//如果当天缓存数据没有存在 则将插入数据存入缓存数据库
                //批量插入查询分页数据
                List<Map<String,String>> commdityMap = commdityMapper.selectCommdityByNowDate(commonUtils.getStrNow()+"00:00:00","1");
                if(commonUtils.ofEmptyAble(commdityMap)){
                    for (Map<String,String> map : commdityMap){
                        MongodbUtils.save(BaseCommdityManager.mapToCommdityDb(map));
                    }
                }
            }
        }catch (Exception e){
            System.err.println("定时任务执行出错 " + LocalDateTime.now()+",执行静态定时任务方法：configureTasks2");
            e.printStackTrace();
        }finally {
            System.err.println("执行静态定时任务时间: " + LocalDateTime.now()+",执行静态定时任务方法：configureTasks2");
        }
    }
}
