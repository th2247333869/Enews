package com.news.demo.model.MongoDbModel;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "CommdityDb")
public class CommdityDb {

    private String name;
    private String type;
    private String state;
    private String image_url;
    private String title;
    private String userid;
    private String compliments;
    private String date;
    private String code;
    private String user_name;
    private String avatar_Url;

    public CommdityDb(){
        super();
    }

    public CommdityDb(String name, String type, String state, String image_url, String title, String userid, String compliments, String date, String code, String user_name, String avatar_Url) {
        this.name = name;
        this.type = type;
        this.state = state;
        this.image_url = image_url;
        this.title = title;
        this.userid = userid;
        this.compliments = compliments;
        this.date = date;
        this.code = code;
        this.user_name = user_name;
        this.avatar_Url = avatar_Url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCompliments() {
        return compliments;
    }

    public void setCompliments(String compliments) {
        this.compliments = compliments;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getAvatar_Url() {
        return avatar_Url;
    }

    public void setAvatar_Url(String avatar_Url) {
        this.avatar_Url = avatar_Url;
    }
}
