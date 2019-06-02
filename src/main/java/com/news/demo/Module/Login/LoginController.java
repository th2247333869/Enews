package com.news.demo.Module.Login;

import com.alibaba.fastjson.JSONObject;
import com.news.demo.Module.BaseController;
import com.news.demo.ResultSet.Result;
import com.news.demo.ResultSet.ResultCode;
import com.news.demo.Utils.JwtUtils;
import com.nimbusds.jose.JOSEException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

        //创建当前toke
        payloadMap = new HashMap<>();
        payloadMap.put("user","tianhao");

        //判断登录成功
        if(isLogin(username,pwd)){
            try {
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
     * @Description:    测试
     * @UpdateUser:     GEBILAOHU
     * @UpdateDate:     19.6.2
     * @UpdateRemark:   无
     * @Version:        1.0
     */
    @CrossOrigin
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){

        return "测试成功";
    }

}
