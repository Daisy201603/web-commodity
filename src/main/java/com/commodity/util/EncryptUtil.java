package com.commodity.util;

import java.util.Random;

/**
 * 自定义加解密或随机数工具
 *
 * @author GongDiXin
 * @version 1.0
 * @created 2018/9/9 16:24
 */
public class EncryptUtil {

    /**
     * 获取文件id(格式：14位日期加6位随机数字加字母，区分大小写)
     *
     * @author GongDiXin
     * @date 2018/9/9 16:25
     * @return String
     *          文件id
     * @param length
    */
    public static String getRandomFileId(int length) {
        String val = DateUtil.getTime("yyyyMMddHHmmss");
        Random random = new Random();

        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {
            boolean charOrNum = random.nextInt(2) % 2 == 0 ? true : false;
            //输出字母还是数字
            if(charOrNum) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(getRandomFileId(6));
    }
}
