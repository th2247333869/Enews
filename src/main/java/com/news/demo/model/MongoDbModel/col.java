package com.news.demo.model.MongoDbModel;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "firstCollection")
public class col {

    private String _id;

    private String name;

    private String age;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
