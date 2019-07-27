package com.news.demo.service;

import com.news.demo.model.SpecificGoods;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author GEBILAOHU
 * @since 2019-07-13
 */
public interface SpecificGoodsService extends IService<SpecificGoods> {

    SpecificGoods getSpecificGoodsById(String id);

}
