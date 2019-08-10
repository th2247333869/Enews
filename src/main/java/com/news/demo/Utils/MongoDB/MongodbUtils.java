package com.news.demo.Utils.MongoDB;

import com.news.demo.Utils.commonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Component
public class MongodbUtils {

    /***
     *
     * PostConstruct 注释用于在依赖关系注入完成之后需要执行的方法上，以执行任何初始化。此方
     * 法必须在将类放入服务之前调用。支持依赖关系注入的所有类都必须支持此注释。即使类没有请求
     * 注入任何资源，用 PostConstruct 注释的方法也必须被调用。只有一个方法可以用此注释进行注
     * 释。应用 PostConstruct 注释的方法必须遵守以下所有标准：该方法不得有任何参数，除非是在
     * EJB 拦截器 (interceptor) 的情况下，根据 EJB 规范的定义，在这种情况下它将带有一个 Inv
     * ocationContext 对象 ；该方法的返回类型必须为 void；该方法不得抛出已检查异常；应用 Po
     * stConstruct 的方法可以是 public、protected、package private 或 private；除了应用
     * 程序客户端之外，该方法不能是 static；该方法可以是 final；
     * 如果该方法抛出未检查异常，那么不得将类放入服务中，除非是能够处理异常并可从中恢复的 EJB。
     */
    public static MongodbUtils mongodbUtils;

    @PostConstruct
    public void init() {
        mongodbUtils = this;
        mongodbUtils.mongoTemplate = this.mongoTemplate;
    }

    @Autowired
    private MongoTemplate mongoTemplate;


    public static List<? extends Object> find(Criteria[] criterias,Object object){

        Query query = new Query();
        for (int i=0;i<criterias.length;i++){
            query.addCriteria(criterias[i]);
        }
        List<? extends Object> resultList = mongodbUtils.mongoTemplate.find(query, object.getClass());
        return resultList;
    }
    /**
     * 保存数据对象，集合为数据对象中@Document 注解所配置的collection
     *
     * @param obj
     *  数据对象
     */
    public static void save(Object obj) {
        mongodbUtils.mongoTemplate.save(obj);
    }

    /**
     * 保存数据对象，集合为数据对象中@Document 注解所配置的collection
     *
     * @param objs
     *  数据对象
     */
    public static void saves(List<Object> objs) {
        for (Object o :objs){
            mongodbUtils.mongoTemplate.save(o);
        }
    }


    /**
     * 指定集合保存数据对象
     *
     * @param obj
     * 数据对象
     * @param collectionName
     *  集合名
     */
    public static void save(Object obj, String collectionName) {
        mongodbUtils.mongoTemplate.save(obj, collectionName);
    }

    /**
     * 根据数据对象中的id删除数据，集合为数据对象中@Document 注解所配置的collection
     *
     * @param obj
     *            数据对象
     */
    public static void remove(Object obj) {
        mongodbUtils.mongoTemplate.remove(obj);
    }

    /**
     * 指定集合 根据数据对象中的id删除数据
     *
     * @param obj
     *            数据对象
     * @param collectionName
     *            集合名
     */
    public static void remove(Object obj, String collectionName) {

        mongodbUtils.mongoTemplate.remove(obj, collectionName);
    }

    /**
     * 根据key，value到指定集合删除数据
     *
     * @param key
     *            键
     * @param value
     *            值
     * @param collectionName
     *            集合名
     */
    public static void removeById(String key, Object value, String collectionName) {

        Criteria criteria = Criteria.where(key).is(value);
        criteria.and(key).is(value);
        Query query = Query.query(criteria);
        mongodbUtils.mongoTemplate.remove(query, collectionName);
    }

    /**
     * 指定集合 修改数据，且仅修改找到的第一条数据
     *
     * @param accordingKey
     *            修改条件 key
     * @param accordingValue
     *            修改条件 value
     * @param updateKeys
     *            修改内容 key数组
     * @param updateValues
     *            修改内容 value数组
     * @param collectionName
     *            集合名
     */
    public static void updateFirst(String accordingKey, Object accordingValue, String[] updateKeys, Object[] updateValues,
                                   String collectionName) {

        Criteria criteria = Criteria.where(accordingKey).is(accordingValue);
        Query query = Query.query(criteria);
        Update update = new Update();
        for (int i = 0; i < updateKeys.length; i++) {
            update.set(updateKeys[i], updateValues[i]);
        }
        mongodbUtils.mongoTemplate.updateFirst(query, update, collectionName);
    }

    /**
     * 指定集合 修改数据，且修改所找到的所有数据
     *
     * @param accordingKey
     *            修改条件 key
     * @param accordingValue
     *            修改条件 value
     * @param updateKeys
     *            修改内容 key数组
     * @param updateValues
     *            修改内容 value数组
     * @param collectionName
     *            集合名
     */
    public static void updateMulti(String accordingKey, Object accordingValue, String[] updateKeys, Object[] updateValues,
                                   String collectionName) {

        Criteria criteria = Criteria.where(accordingKey).is(accordingValue);
        Query query = Query.query(criteria);
        Update update = new Update();
        for (int i = 0; i < updateKeys.length; i++) {
            update.set(updateKeys[i], updateValues[i]);
        }
        mongodbUtils.mongoTemplate.updateMulti(query, update, collectionName);
    }

    /**
     * 根据条件查询出所有结果集 集合为数据对象中@Document 注解所配置的collection
     *
     * @param obj
     *            数据对象
     * @param findKeys
     *            查询条件 key
     * @param findValues
     *            查询条件 value
     * @return
     */
    public static List<? extends Object> find(Object obj, String[] findKeys, Object[] findValues) {

        Criteria criteria = null;
        for (int i = 0; i < findKeys.length; i++) {
            if (i == 0) {
                criteria = Criteria.where(findKeys[i]).is(findValues[i]);
            } else {
                criteria.and(findKeys[i]).is(findValues[i]);
            }
        }
        Query query = Query.query(criteria);
        List<? extends Object> resultList = mongodbUtils.mongoTemplate.find(query, obj.getClass());
        return resultList;
    }

    /**
     * 指定集合 根据条件查询出所有结果集
     *
     * @param obj
     *            数据对象
     * @param findKeys
     *            查询条件 key
     * @param findValues
     *            查询条件 value
     * @param collectionName
     *            集合名
     * @return
     */
    public static List<? extends Object> find(Object obj, String[] findKeys, Object[] findValues, String collectionName) {

        Criteria criteria = null;
        for (int i = 0; i < findKeys.length; i++) {
            if (i == 0) {
                criteria = Criteria.where(findKeys[i]).is(findValues[i]);
            } else {
                criteria.and(findKeys[i]).is(findValues[i]);
            }
        }
        Query query = Query.query(criteria);
        List<? extends Object> resultList = mongodbUtils.mongoTemplate.find(query, obj.getClass(), collectionName);
        return resultList;
    }

    /**
     * 指定集合 根据条件查询出所有结果集 并排倒序
     *
     * @param obj
     *            数据对象
     * @param findKeys
     *            查询条件 key
     * @param findValues
     *            查询条件 value
     * @param collectionName
     *            集合名
     * @param sort
     *            排序字段
     * @return
     */
    public static List<? extends Object> find(Object obj, String[] findKeys, Object[] findValues, String collectionName ,String sort) {

        Criteria criteria = null;
        for (int i = 0; i < findKeys.length; i++) {
            if (i == 0) {
                criteria = Criteria.where(findKeys[i]).is(findValues[i]);
            } else {
                criteria.and(findKeys[i]).is(findValues[i]);
            }
        }
        Query query = Query.query(criteria);
        query.with(new Sort(Sort.Direction.DESC, sort));
        List<? extends Object> resultList = mongodbUtils.mongoTemplate.find(query, obj.getClass(), collectionName);
        return resultList;
    }

    /**
     * 根据条件查询出符合的第一条数据 集合为数据对象中 @Document 注解所配置的collection
     *
     * @param obj
     *            数据对象
     * @param findKeys
     *            查询条件 key
     * @param findValues
     *            查询条件 value
     * @return
     */
    public static Object findOne(Object obj, String[] findKeys, Object[] findValues) {

        Criteria criteria = new Criteria();
        for (int i = 0,length = findKeys.length; i < length; i++) {
            if (i == 0) {
                criteria = Criteria.where(findKeys[i]).is(findValues[i]);
            } else {
                criteria.and(findKeys[i]).is(findValues[i]);
            }
        }
        Query query = Query.query(criteria);
        Object resultObj = mongodbUtils.mongoTemplate.findOne(query, obj.getClass());
        return resultObj;
    }

    /**
     * 指定集合 根据条件查询出符合的第一条数据
     *
     * @param obj
     *            数据对象
     * @param findKeys
     *            查询条件 key
     * @param findValues
     *            查询条件 value
     * @param collectionName
     *            集合名
     * @return
     */
    public static Object findOne(Object obj, String[] findKeys, Object[] findValues, String collectionName) {

        Criteria criteria = new Criteria();
        for (int i = 0 ,length = findKeys.length;i < length; i++) {
            if (i == 0) {
                criteria = Criteria.where(findKeys[i]).is(findValues[i]);
            } else {
                criteria.and(findKeys[i]).is(findValues[i]);
            }
        }
        Query query = Query.query(criteria);
        Object resultObj = mongodbUtils.mongoTemplate.findOne(query, obj.getClass(), collectionName);
        return resultObj;
    }

    /**
     * 查询出所有结果集 集合为数据对象中 @Document 注解所配置的collection
     *
     * @param obj
     *            数据对象
     * @return
     */
    public static List<? extends Object> findAll(Object obj) {

        List<? extends Object> resultList = mongodbUtils.mongoTemplate.findAll(obj.getClass());
        return resultList;
    }

    /**
     * 指定集合 查询出所有结果集
     *
     * @param obj
     *            数据对象
     * @param collectionName
     *            集合名
     * @return
     */
    public static List<? extends Object> findAll(Object obj, String collectionName) {

        List<? extends Object> resultList = mongodbUtils.mongoTemplate.findAll(obj.getClass(), collectionName);
        return resultList;
    }


}
