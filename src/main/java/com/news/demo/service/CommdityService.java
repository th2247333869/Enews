package com.news.demo.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.news.demo.model.Commdity;
import com.baomidou.mybatisplus.service.IService;
import com.news.demo.model.MongoDbModel.CommdityDb;
import com.news.demo.model.MongoDbModel.col;

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

    public List<CommdityDb>  getCommmdityPageNoticV2() throws Exception;

    public Integer saveCommmditysPageNotics(List<Commdity> commdities) throws Exception;
}
