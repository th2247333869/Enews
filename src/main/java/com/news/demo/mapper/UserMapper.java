package com.news.demo.mapper;

import com.news.demo.model.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author GEBILAOHU
 * @since 2019-06-09
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {


    @Select("select * from t_user where user_name = #{name} and user_pwd = #{pwd}")
    /**
     * 对于多个参数来说，每个参数之前都要加上@Param注解，
     * 要不然会找不到对应的参数进而报错
     */
    public User login(@Param("name")String name, @Param("pwd")String pwd);
}
