package com.commodity.ssm.model.file;

import org.springframework.stereotype.Component;

/**
 * @author GongDiXin
 * @version 1.0
 * @created 2018/9/6 22:37
 */
@Component
public class FileInfo {

    /**
     * 主键
     * */
    private int id;

    /**
     * 文件名
     * */
    private String fileName;

    /**
     * 文件id
     * */
    private String fileId;

    /**
     * 上传用户
     * */
    private int userId;

    /**
     * 创建时间
     * */
    private String createTime;

    /**
     * 文件地址
     * */
    private String fileUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
