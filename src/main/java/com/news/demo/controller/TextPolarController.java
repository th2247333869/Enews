package com.news.demo.controller;

import com.news.demo.Utils.HttpRequestUtils;
import com.news.demo.Utils.SpringContextHolder;
import com.news.demo.Utils.TencentAISignHolder;
import com.news.demo.model.BaseEntity.ResponseEntity;
import com.news.demo.model.TextPolar;
import com.news.demo.webconfig.TencentAiConfig;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
* @Description:    调用腾讯情感分析接口
* @Author:         GEBILAOHU
* @CreateDate:     2019/6/19 20:51
* @UpdateUser:     GEBILAOHU
* @UpdateDate:     2019/6/19 20:51
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@RestController
@RequestMapping(value="/api/v1")
public class TextPolarController {

    private static final TencentAiConfig CONFIG = SpringContextHolder.getBean(TencentAiConfig.class);


    @CrossOrigin
    @RequestMapping(value = "/getInforMation", method = RequestMethod.GET)
    public Map getInforMation() throws Exception{
        long start = System.currentTimeMillis();
        Map<String, Object> params = new HashMap<>();
        params.put("app_id", CONFIG.getAppID());
        params.put("time_stamp", new Date().getTime() / 1000);
        params.put("nonce_str", Math.random());
        params.put("text", "结婚了");
        params.put("sign", TencentAISignHolder.getSignature(params));
        ResponseEntity<TextPolar> entity = HttpRequestUtils.post(params, null);
        System.out.println(entity);
        long end = System.currentTimeMillis();
        System.out.println("请求时间：" + (end - start));
        return null;
    }

}
