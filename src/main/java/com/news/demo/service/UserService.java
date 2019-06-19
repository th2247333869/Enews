package com.news.demo.service;

import com.news.demo.model.User;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author GEBILAOHU
 * @since 2019-06-09
 */

public interface UserService extends IService<User> {

    User login(String username,String pwd);

    Integer createUser(String deviceId);

    Integer createUserByOpenId(String openid);
}
