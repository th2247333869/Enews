package com.news.demo.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.news.demo.model.Commdity;
import com.news.demo.mapper.CommdityMapper;
import com.news.demo.service.CommdityService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GEBILAOHU
 * @since 2019-07-07
 */
@Service
public class CommdityServiceImpl extends ServiceImpl<CommdityMapper, Commdity> implements CommdityService {

    @Autowired
    private CommdityMapper commdityMapper;

    @Override
    public List<Map<String,String>>  getCommmdityPageNotic(Page page) {

        return commdityMapper.selectCommdityPageNotic(page,"1");
    }
}
