package com.news.demo.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.news.demo.Utils.commonUtils;
import com.news.demo.model.Commdity;
import com.news.demo.module.BaseController;
import com.news.demo.resultSet.Result;
import com.news.demo.resultSet.ResultCode;
import com.news.demo.service.impl.CommdityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author GEBILAOHU
 * @since 2019-07-07
 */
@RestController
@RequestMapping("/commdity")
public class CommdityController extends BaseController {

    @Autowired
    private CommdityServiceImpl commdityService;
    /**
    * @Description:    分页查询推荐
    * @UpdateUser:     GEBILAOHU
    * @UpdateDate:
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @CrossOrigin
    @RequestMapping(value = "/getCommdity", method = RequestMethod.POST)
    public List getCommdity(@RequestBody String currentDate){
        if(Objects.nonNull(currentDate)||!"".equals(currentDate)){
            currentDate = commonUtils.getStrNow();
        }
        Page page1 = new Page(1,4);
        List<Map<String,String>>  map= commdityService.getCommmdityPageNotic(page1);
        return map;
    }




}

