package com.news.demo.module.Login;

import com.news.demo.Utils.OrderCodeFactoryUtils;
import com.news.demo.model.User;
import com.news.demo.module.BaseController;
import com.news.demo.resultSet.Result;
import com.news.demo.resultSet.ResultCode;
import com.news.demo.Utils.JwtUtils;
import com.news.demo.service.impl.UserServiceImpl;
import com.nimbusds.jose.JOSEException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
* @Description:    登录控制器
* @Author:         GEBILAOHU
* @CreateDate:     2019/6/2 14:01
* @UpdateUser:     GEBILAOHU
* @UpdateDate:     2019/6/2 14:01
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@CrossOrigin(maxAge = 3600)
@RestController
public class LoginController extends BaseController {

    @Autowired
    UserServiceImpl userService;

    /**
    * @Description:    登录web
    * @UpdateUser:     GEBILAOHU
    * @UpdateDate:     19.6.2
    * @UpdateRemark:   无
    * @Version:        1.0
    */
    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map loginIn(@RequestParam String username,@RequestParam String pwd){
        Map<String,Object> payloadMap = null;
        String token = "";

        User u = userService.login(username,pwd);
        //判断登录成功
        if(isLogin(u)){
            try {
                payloadMap = new HashMap<>();//创建当前toke
                payloadMap.put("user",u.getUserName());
                payloadMap.put("exp",getTokenExp());//设置过期时间
                token = JwtUtils.creatToken(payloadMap);
            }catch (JOSEException e){
                return ToMap(new Result(ResultCode.LOGINEVER,"登录失败",null));
            }
        }else {
            return ToMap(new Result(ResultCode.LOGINEVER,"登录失败",null));
        }

        return ToMap(new Result(ResultCode.SUCCESS,"登录成功",token));
    }

    /**
     * @Description:    登录web
     * @UpdateUser:     GEBILAOHU
     * @UpdateDate:     19.6.2
     * @UpdateRemark:   无
     * @Version:        1.0
     */
    @CrossOrigin
    @RequestMapping(value = "/wxlogin", method = RequestMethod.GET)
    public Map loginWX(@RequestParam String code){
        String openid = getWxOpenId(code);
        if(userService.createUserByOpenId(openid)== 0){
            return ToMap(new Result(ResultCode.EVER,"插入数据错误",null));
        }else{
            return ToMap(new Result(ResultCode.SUCCESS,"插入数据成功",null));
        }
    }

    /**
     * @Description:    保存用户唯一识别码
     * @UpdateUser:     GEBILAOHU
     * @UpdateDate:     19.6.2
     * @UpdateRemark:   无
     * @Version:        1.0
     */
    @CrossOrigin
    @RequestMapping(value = "/creatDeviceId", method = RequestMethod.POST)
    public Map creatDeviceId(@RequestParam String deviceId){
        if(deviceId == null || "".equals(deviceId)){
            deviceId = "0000";
        }
        if(userService.createUser(deviceId) == 0){
            return ToMap(new Result(ResultCode.EVER,"插入数据错误",null));
        }else{
            return ToMap(new Result(ResultCode.SUCCESS,"插入数据成功",null));
        }
    }

    /**
     * @Description:    测试
     * @UpdateUser:     GEBILAOHU
     * @UpdateDate:     19.6.2
     * @UpdateRemark:   无
     * @Version:        1.0
     */
    @CrossOrigin
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() throws Exception{

        return "测试成功";
    }

    @CrossOrigin
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test2() throws Exception{

        return "测试成功";
    }
}
