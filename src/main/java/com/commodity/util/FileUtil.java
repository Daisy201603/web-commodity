package com.commodity.util;

import com.commodity.common.JsonData;
import com.commodity.system.CommoditySystem;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 文件处理工具
 *
 * @author GongDiXin
 * @version 1.0
 * @created 2018/9/4 23:06
 */
public class FileUtil {

    private static final String POINT = ".";

    /**
     * 获取文件后缀
     *
     * @author GongDiXin
     * @date 2018/9/4 23:07
     * @param
     * @return
     * @exception
    */
    public static String getFileSuffix(String filename) {
        String fileSuffix;
        if (filename.lastIndexOf(POINT) == -1) {
            fileSuffix = "";
        } else {
            fileSuffix = filename.substring(filename.lastIndexOf(POINT) + 1, filename.length());
        }
        return fileSuffix;
    }

    /**
     * 校验文件类型合法性
     *
     * @author GongDiXin
     * @date 2018/9/4 23:13
     * @param
     * @return
     * @exception
    */
    public static boolean checkImgType(String filename) {
        String filesuffix = getFileSuffix(filename);
        if (!(filesuffix.equals("jpg") || filesuffix.equals("jpeg") || filesuffix.equals("png"))) {
            return false;
        }
        return true;
    }

    /**
     * 上传文件
     *
     * @author GongDiXin
     * @date 2018/9/4 23:21
     * @param multipartFile
     * @return
    */
    public static String upload(MultipartFile multipartFile) {
        String filePath = CommoditySystem.configProperties.get("com.commodity.file.url");
        return JsonData.fail("123").getMsg();
    }
}
