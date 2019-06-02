package com.news.demo.ResultSet;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
* @Description:    返回接口规范
* @Author:         GEBILAOHU
* @CreateDate:     2019/6/2 13:56
* @UpdateUser:     GEBILAOHU
* @UpdateDate:     2019/6/2 13:56
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class Result {

    private String resultCode;

    private String message;

    private Object data;

    public Result(String resultCode, String message, Object data) {
        this.resultCode = resultCode;
        this.message = message;
        this.data = data;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
