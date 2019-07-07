package com.news.demo.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class commonUtils {


    /**
    * @Description:    获取当前时间
    * @UpdateUser:     GEBILAOHU
    * @UpdateDate:
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public static Date getNow(){
        Calendar now = Calendar.getInstance();
        Date d = new Date();
        return d;
    }

    public static String getStrNow(){
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(df.format(day));
        return df.format(day);
    }
}
