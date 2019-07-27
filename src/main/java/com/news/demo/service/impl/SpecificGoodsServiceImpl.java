package com.news.demo.service.impl;

import com.news.demo.model.SpecificGoods;
import com.news.demo.mapper.SpecificGoodsMapper;
import com.news.demo.service.SpecificGoodsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GEBILAOHU
 * @since 2019-07-13
 */
@Service
public class SpecificGoodsServiceImpl extends ServiceImpl<SpecificGoodsMapper, SpecificGoods> implements SpecificGoodsService {

    @Autowired
    private SpecificGoodsMapper specificGoodsMapper;

    @Override
    public SpecificGoods getSpecificGoodsById(String id) {
        return specificGoodsMapper.selectSpecificGoodsById(Integer.valueOf(id));
    }
}
