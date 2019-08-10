package com.news.demo.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.news.demo.model.Commdity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author GEBILAOHU
 * @since 2019-07-07
 */
@Mapper
public interface CommdityMapper extends BaseMapper<Commdity> {

            /**
          * <p>
          * 查询 : 根据state状态查询列表，分页显示
          * </p>
          *
          * @param page
          *            翻页对象，可以作为 xml 参数直接使用，传递参数 Page 即自动分页
          * @param state
          *            状态
          * @return
          */
    @Select("SELECT b.*,u.user_name,u.avatar_Url FROM b_commdity b LEFT JOIN t_user u on b.user_id = " +
            "u.user_id WHERE b.state=#{state} and  b.date<STR_TO_DATE(#{date}, '%Y-%m-%d %H:%i:%s') order by b.date desc")
    List<Map<String,String>> selectCommdityPageNotic(Pagination page, String date,String state);

    @Select("SELECT b.*,u.user_name,u.avatar_Url FROM b_commdity b LEFT JOIN t_user u on b.user_id = " +
            "u.user_id WHERE b.date>=STR_TO_DATE(#{date}, '%Y-%m-%d %H:%i:%s')  and b.state = #{state} order by b.date desc")
    List<Map<String,String>> selectCommdityByNowDate(String date, String state);


}
