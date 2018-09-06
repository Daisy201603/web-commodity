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
     * @param
     * @return
     * @exception
    */
    public static String getTime(String format) {
        simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(new Date());
    }
}
