package com.news.demo.Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class OrderCodeFactoryUtils {

    private static final String ORDER_CODE = "A";//置顶新闻类

    private static final String RETURN_ORDER = "B";//推荐新闻类

    private static final String CANCEL_ORDER = "C";//普通新闻类

    /** 随即编码 */
    private static final int[] r = new int[]{7, 9, 6, 2, 8 , 1, 3, 0, 5, 4};
    /** 用户id和随机数总长度 */
    private static final int maxLength = 14;

    private static String toCode(int id) {
        String idStr = String.valueOf(id);
        StringBuilder idsbs = new StringBuilder();
        for (int i = idStr.length() - 1 ; i >= 0; i--) {
            idsbs.append(r[idStr.charAt(i)-'0']);
        }
        return idsbs.append(getRandom(maxLength - idStr.length())).toString();
    }

    /**
     * 生成固定长度随机码
     * @param n    长度
     */
    private static long getRandom(long n) {
        long min = 1,max = 9;
        for (int i = 1; i < n; i++) {
            min *= 10;
            max *= 10;
        }
        long rangeLong = (((long) (new Random().nextDouble() * (max - min)))) + min ;
        return rangeLong;
    }

    /**
     * 生成时间戳
     */
    private static String getDateTime(){
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(new Date());
    }

    /**
     * 得到新闻单独编号
     * @param id
     * @return
     */
    public static String  getCommonCode(int id,String level){
        String code = "";
        switch (level) {
            case ORDER_CODE:
                code = ORDER_CODE + getDateTime() + toCode(id);
                break;
            case RETURN_ORDER:
                code = RETURN_ORDER + getDateTime() + toCode(id);
                break;
            default :
                code = CANCEL_ORDER + getDateTime() + toCode(id);
                break;
        }
        return ORDER_CODE+getDateTime()+toCode(id);
    }

}
