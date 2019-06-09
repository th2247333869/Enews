package com.news.demo.module;

import com.alibaba.fastjson.JSONObject;
import com.news.demo.model.User;
import com.news.demo.resultSet.Result;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
* @Description:    父级控制器
* @Author:         GEBILAOHU
* @CreateDate:     2019/6/2 17:58
* @UpdateUser:     GEBILAOHU
* @UpdateDate:     2019/6/2 17:58
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class BaseController {

    private  static long TOKEN_EXP = 600000;//过期时间,测试使用60秒*60*3 过期时间为3小时


    public String ToJson(Result result){
        return JSONObject.toJSONString(result);
    }

    public Map ToMap(Result result){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("code",result.getResultCode());
        resultMap.put("message",result.getMessage());
        resultMap.put("data",result.getData());
        return resultMap;
    }

    /**
    * @Description:    模拟登录
    * @UpdateUser:     GEBILAOHU
    * @UpdateDate:      19.6.2
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public boolean isLogin(String un,String pwd){
        if(un.equals("admin")&& pwd.equals("admin")){
            return true;
        }else{
            return false;
        }
    }

    public boolean isLogin(User u){
        if(u!=null){
            return true;
        }else{
            return false;
        }
    }

    public String getTokenExp(){

        return String.valueOf(new Date().getTime()+TOKEN_EXP);

    }
}
