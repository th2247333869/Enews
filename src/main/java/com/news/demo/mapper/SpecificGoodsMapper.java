package com.news.demo.mapper;

import com.news.demo.model.SpecificGoods;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author GEBILAOHU
 * @since 2019-07-13
 */
@Mapper
public interface SpecificGoodsMapper extends BaseMapper<SpecificGoods> {

    @Select("SELECT b.* FROM b_specific_goods b  WHERE b.id = #{id}")
    SpecificGoods selectSpecificGoodsById(@Param("id")int id);

}
