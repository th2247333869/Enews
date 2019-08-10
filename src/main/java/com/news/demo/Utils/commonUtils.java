package com.news.demo.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
        return df.format(day);
    }

    public static boolean ofNullable(List<?> list){
        return list == null ? false:true;
    }

    public static boolean ofNull(List<?> list){
        return list == null ? true:false;
    }

    public static boolean ofEmpty(List<?> list){
        if(commonUtils.ofNullable(list) && !list.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    public static boolean ofEmptyAble(List<?> list){
        if(commonUtils.ofNullable(list) && !list.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public static boolean ofNowDate(Date date){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

        String nowDay = sf.format(date);

        String day = sf.format(date);

        return day.equals(nowDay);
    }

    /**
     * 通过日历类的Calendar.add方法第二个参数-1达到前一天日期的效果
     * @return
     */
    public static String getYesterdayByCalendar(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(Calendar.DATE);
        calendar.add(Calendar.DATE,-1);
        Date time = calendar.getTime();
        String yesterday = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(time);
        return yesterday;
    }

}
