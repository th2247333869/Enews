package com.news.demo.Utils;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import net.minidev.json.JSONObject;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
* @Description:    JWT生成TOKEN工具类（HS256 对称加密）
* @Author:         GEBILAOHU
* @CreateDate:     2019/6/2 14:08
* @UpdateUser:     GEBILAOHU
* @UpdateDate:     2019/6/2 14:08
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class JwtUtils {

    /**
     * 1.创建一个32-byte的密匙
     */
    private static final byte[] secret = "geiwodiangasfdjsikolkjikolkijswe".getBytes();

    /**
    * @Description:    生成一个token
    * @UpdateUser:     GEBILAOHU
    * @UpdateDate:      19.6.2
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public static String creatToken(Map<String,Object> payloadMap) throws JOSEException {

        //3.先建立一个头部Header
        /**
         * JWSHeader参数：1.加密算法法则,2.类型，3.。。。。。。。
         * 一般只需要传入加密算法法则就可以。
         * 这里则采用HS256
         *
         * JWSAlgorithm类里面有所有的加密算法法则，直接调用。
         */
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS256);

        //建立一个载荷Payload
        Payload payload = new Payload(new JSONObject(payloadMap));

        //将头部和载荷结合在一起
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);

        //建立一个密匙

        JWSSigner jwsSigner = new MACSigner(secret);

        //签名
        jwsObject.sign(jwsSigner);

        //生成token
        return jwsObject.serialize();
    }

    /**
    * @Description:    解析一个token
    * @UpdateUser:     GEBILAOHU
    * @UpdateDate:      19.6.2
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public static Map<String,Object> valid(String token) throws Exception, JOSEException {

    //        解析token

        JWSObject jwsObject = JWSObject.parse(token);

        //获取到载荷
        Payload payload=jwsObject.getPayload();

        //建立一个解锁密匙
        JWSVerifier jwsVerifier = new MACVerifier(secret);

        Map<String, Object> resultMap = new HashMap<>();
        //判断token
        if (jwsObject.verify(jwsVerifier)) {
            resultMap.put("Result", 0);
            //载荷的数据解析成json对象。
            JSONObject jsonObject = payload.toJSONObject();
            resultMap.put("data", jsonObject);

            //判断token是否过期
            if (jsonObject.containsKey("exp")) {
                Long expTime = Long.valueOf((String) jsonObject.get("exp"));
                Long nowTime = new Date().getTime();
                //判断是否过期
                if (nowTime > expTime) {
                    //已经过期
                    resultMap.clear();
                    resultMap.put("Result", 2);

                }
            }
        }else {
            resultMap.put("Result", 1);
        }
        return resultMap;

    }


}
