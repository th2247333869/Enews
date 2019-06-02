package com.news.demo.Module.Pages;

import com.news.demo.Module.BaseController;
import com.news.demo.Module.Enews.Enews;
import com.news.demo.Module.Enews.EnewsAiSystem;
import com.news.demo.ResultSet.Result;
import com.news.demo.ResultSet.ResultCode;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
* @Description:    查询新闻相关类
* @Author:         GEBILAOHU
* @CreateDate:     2019/6/2 20:39
* @UpdateUser:     GEBILAOHU
* @UpdateDate:     2019/6/2 20:39
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@RestController
@RequestMapping(value = "/pages")
public class EnewsPagesController extends BaseController {

    /**
     * @Description:    测试
     * @UpdateUser:     GEBILAOHU
     * @UpdateDate:     19.6.2
     * @UpdateRemark:   无
     * @Version:        1.0
     */
    @CrossOrigin
    @RequestMapping(value = "/getPages", method = RequestMethod.POST)
    public Map test(){

        EnewsAiSystem enewsAiSystem = new EnewsAiSystem();

        return enewsAiSystem.create();
    }

}
