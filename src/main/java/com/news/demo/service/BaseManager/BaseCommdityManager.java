package com.news.demo.service.BaseManager;

import com.news.demo.model.MongoDbModel.CommdityDb;

import java.util.Map;

public class BaseCommdityManager {


    /**
     * 公用
     * @param map
     * @return
     */
    public static CommdityDb mapToCommdityDb(Map<String,String> map){

        CommdityDb commdityDb = new CommdityDb(
                map.get("name"),map.get("type"),map.get("state"),map.get("image_url"),
                map.get("title"),String.valueOf(map.get("user_id")),String.valueOf(map.get("compliments")),
                String.valueOf(map.get("date")).substring(0,10),map.get("code"),map.get("user_name"),map.get("avatar_Url")
        );

        return commdityDb;
    }

}
