package com.news.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.news.demo.Utils.Result.ResultMap;
import com.news.demo.model.SpecificGoods;
import com.news.demo.module.BaseController;
import com.news.demo.service.impl.SpecificGoodsServiceImpl;
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
 * @since 2019-07-13
 */
@RestController
@RequestMapping("/specificGoods")
public class SpecificGoodsController extends BaseController {

    @Autowired
    private SpecificGoodsServiceImpl specificGoodsService;

    @CrossOrigin
    @RequestMapping(value = "/getSpecificGoodsById", method = RequestMethod.POST)
    public Map<String, Object> SpecificGoodsById(@RequestBody String id) throws Exception{
        String strid = getSingleJsonValue(id,"id");
        if(Objects.nonNull(strid)||!"".equals(strid)){
            SpecificGoods specificGoods = specificGoodsService.getSpecificGoodsById(strid);
            return ResultMap.objectToMap(specificGoods);
        }else{
            return null;
        }
    }
}

