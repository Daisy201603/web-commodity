package com.commodity.util;

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
        String fileSuffix = getFileSuffix(filename);
        if (!(fileSuffix.equals("jpg") || fileSuffix.equals("jpeg") || fileSuffix.equals("png"))) {
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
        FileInfo fileInfo = new FileInfo();
        fileInfo.setFileName(multipartFile.getOriginalFilename());
        fileInfo.setFileId(EncryptUtil.getRandomFileId(6));
        fileInfo.setUserId(user.getUserId());
        fileInfo.setCreateTime(DateUtil.getTime("yyyy-MM-dd hh:mm:ss"));
        fileInfo.setFileUrl(CommoditySystem.getOrdinaryFileUrl() + multipartFile.getOriginalFilename());
        if (logger.isDebugEnabled()) {
            logger.debug("FileUtil.upload 文件上传成功" + " [filename: " + fileInfo.getFileName() + "]"
                    + " [fileId: " + fileInfo.getFileId() + "]"
                    + " [userId: " + fileInfo.getUserId() + "]");
        }
        return fileInfo;
    }


    /**
     * 上传文件
     *
     * @author GongDiXin
     * @date 2018/9/12 22:07
     * @param
     * @return
     * @exception
    */
    public static void uploadFile(MultipartFile multipartFile) {
        String configFileUrl = CommoditySystem.configProperties.get("com.commodity.ordinary.file.url");
        String filePath = CommoditySystem.systemUrl + configFileUrl;
        createFileOrDir(filePath);
        filePath = filePath + multipartFile.getOriginalFilename();
        InputStream input = null;
        OutputStream out = null;
        try {
            File file = new File(filePath);
            input = multipartFile.getInputStream();
            out = new FileOutputStream(file);
            int temp;
            while ((temp = input.read()) != -1) {
                out.write(temp);
            }
        } catch (IOException e) {
            if (logger.isErrorEnabled()) {
                logger.error("上传文件错误", e);
            }
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
}
