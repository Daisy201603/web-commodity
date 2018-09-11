package com.commodity.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author GongDiXin
 * @version 1.0
 * @created 2018/9/6 23:09
 */
public class DateUtil {

    private static SimpleDateFormat simpleDateFormat;

    /**
     * 获取指定格式时间
     *
     * @author GongDiXin
     * @date 2018/9/6 23:10
     * @param format
     * @return
     */
    public static String getTime(String format) {
        simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(new Date());
    }

    /**
     * 获取指定格式时间
     *
     * @author GongDiXin
     * @date 2018/9/6 23:10
     * @param format
     * @return
     */
    public static String getCurrentTime(String format) {
        simpleDateFormat = new SimpleDateFormat(format);
        long currentTime = System.currentTimeMillis();
        return simpleDateFormat.format(currentTime);
    }

    public static void main(String[] args) {
        System.out.println(getCurrentTime("yyyy-MM-dd hh:mm:ss"));
    }
}
