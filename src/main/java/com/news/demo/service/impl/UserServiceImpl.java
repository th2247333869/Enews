package com.news.demo.service.impl;

import com.news.demo.model.User;
import com.news.demo.mapper.UserMapper;
import com.news.demo.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author GEBILAOHU
 * @since 2019-06-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username,String pwd) {

        return userMapper.selectUserByNameAndPwd(username,pwd);

    }

    @Override
    public Integer createUser(String deviceId) {
        User user = new User();
        Integer result = 0;
        try {
            //初始默认用户名为用户设备ID 密码为0000
            user.setUserName(deviceId);
            user.setDeviceId(deviceId);
            user.setUserPwd("0000");
            result = userMapper.insert(user);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return result;
    }
}
