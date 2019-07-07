package com.news.demo.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.news.demo.model.Commdity;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author GEBILAOHU
 * @since 2019-07-07
 */
public interface CommdityService extends IService<Commdity> {

    public List<Map<String,String>>  getCommmdityPageNotic(Page page);
}
