package com.news.demo.Utils;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

/**
* @Description:    微信接口工具类
* @Author:         GEBILAOHU
* @CreateDate:     2019/6/18 21:11
* @UpdateUser:     GEBILAOHU
* @UpdateDate:     2019/6/18 21:11
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class WeChatUtil {

    public static String httpRequest(String requestUrl,String requestMethod,String output){
        try{
            URL url = new URL(requestUrl);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            if(null != output){
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(output.getBytes("utf-8"));
                outputStream.close();
            }
            // 从输入流读取返回内容
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null){
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            connection.disconnect();
            return buffer.toString();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }

}
