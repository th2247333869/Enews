package com.news.demo.service.impl;

import com.news.demo.model.User;
import com.news.demo.mapper.UserMapper;
import com.news.demo.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
    public Integer createUser(User user) {
        Integer result = 0;
        try {
            result = userMapper.insert(user);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return result;
    }

    @Override
    public Integer createUserByOpenId(User user) {
        //1.查询是否已经创建了openid
        User u= userMapper.selectUserByOpenId(user.getDeviceId());
        //校验user
        if(!Objects.nonNull(u)){
            return this.createUser(user);
        }else{
            return 0;
        }
    }
}
