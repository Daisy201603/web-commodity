package com.commodity.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则校验工具
 *
 * @author GongDiXin
 * @version 1.0
 * @created 2018/7/31 21:52
 */
public class RegexUtil {

    /**
     * 校验邮箱
     *
     * @author GongDiXin
     * @date 2018/7/31 21:53
     * @param email
     * @return
    */
    public static boolean regexEmail(String email) {
        String check = "^([a-z0-9A-Z]+[-|.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        return regex(check, email);
    }

    /**
     * 校验邮箱
     *
     * @author GongDiXin
     * @date 2018/7/31 21:53
     * @param phone
     * @return
     */
    public static boolean regexPhone(String phone) {
        String check = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
        return regex(check, phone);
    }

    /**
     * 校验
     *
     * @author GongDiXin
     * @date 2018/7/31 21:59
     * @param regexString
     *              正则表达式
     * @param target
     *              目标字符串
     * @return
     * @exception
    */
    private static boolean regex(String regexString, String target) {
        Pattern regex = Pattern.compile(regexString);
        Matcher matcher = regex.matcher(target);
        return matcher.matches();
    }
}
