package com.commodity.util;

import com.commodity.common.JsonData;
import com.commodity.ssm.manager.UserManager;
import com.commodity.ssm.model.User;
import com.commodity.ssm.model.file.FileInfo;
import com.commodity.system.CommoditySystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
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

    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

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
     * @param request
     * @param multipartFile
     * @return
    */
    public static FileInfo upload(HttpServletRequest request, MultipartFile multipartFile) {
        User user = (User) request.getSession().getAttribute(CommodityConst.REQUEST_USER);
        if (ValidateUtil.isEmpty(user)) {
            return null;
        }
        String configFileUrl = CommoditySystem.configProperties.get("com.commodity.file.url");
        String filePath = CommoditySystem.systemUrl + configFileUrl;
        createFileOrDir(filePath);
        FileInfo fileInfo = null;
        InputStream input = null;
        OutputStream out = null;
        try {
            File file = new File(filePath + multipartFile.getOriginalFilename());
            input = multipartFile.getInputStream();
            out = new FileOutputStream(file);
            int temp;
            while ((temp = input.read()) != -1) {
                out.write(temp);
            }
            fileInfo = new FileInfo();
            fileInfo.setFileName(multipartFile.getOriginalFilename());
            fileInfo.setFileId(createFileName());
            fileInfo.setUserId(user.getId());
            fileInfo.setCreateTime(DateUtil.getTime("yyyyMMdd"));
            // TODO: 系统级的获得服务器地址
            fileInfo.setFileUrl(request.getRemoteAddr()+ request.getRemotePort() + request.getContextPath() + configFileUrl + multipartFile.getOriginalFilename());
            return fileInfo;
        } catch (IOException e) {
            if (logger.isErrorEnabled()) {
                logger.error("上传文件错误", e);
            }
            return fileInfo;
        } finally {
            try {
                input.close();
                out.close();
                out.flush();
            } catch (IOException e) {
                if (logger.isErrorEnabled()) {
                    logger.error("文件流关闭失败");
                }
            }
        }
    }

    /**
     * 创建文件目录
     *
     * @author GongDiXin
     * @date 2018/9/6 21:13
     * @param
     * @return
     * @exception
    */
    private static void createFileOrDir(String filePath) {
        File file = new File(filePath);
        //mkdir()  创建此抽象路径名指定的目录。如果父目录不存在则创建不成功
        // mkdirs() 创建此抽象路径名指定的目录，包括所有必需但不存在的父目录
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /**
     * 创建文件id
     * java生成流水号
     * 14位时间戳 + 6位随机数
     *
     * @author GongDiXin
     * @date 2018/9/6 22:22
     * @param
     * @return
     * @exception
    */
    private static String createFileName() {
        // TODO: 文件id生成规则需要修改
        return (DateUtil.getTime("yyyy-MM-dd hh:mm:ss") + (Math.random() + 1) * 100000).trim();
    }
}
