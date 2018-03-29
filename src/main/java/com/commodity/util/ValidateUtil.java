package com.commodity.util;

/**
 * 数据校验类
 *
 * @author GongDiXin
 * @version 1.0
 * @created 2018/3/29 21:50
 */
public class ValidateUtil {

    private ValidateUtil() {}

    public static boolean isEmpty(Object obj) {
        if (obj == null || obj.equals("")) {
            return true;
        } else {
            return false;
        }
    }

}
