package com.news.demo.Utils;

import java.util.Calendar;
import java.util.Date;

public class commonUtils {


    public static Date getNow(){
        Calendar now = Calendar.getInstance();
        Date d = new Date();
        return d;
    }
}
