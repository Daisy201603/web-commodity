package com.commodity.ssm.model;

import org.springframework.stereotype.Component;

/**
 * @author GongDiXin
 * @version 1.0
 * @created 2018/9/10 23:10
 */
@Component
public class UserInfo extends User {

    private int id;

    /**
     * 头像文件id
     */
    private String headFileId;

    /**
     * 头像地址
     */
    private String headImgUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getHeadFileId() {
        return headFileId;
    }

    public void setHeadFileId(String headFileId) {
        this.headFileId = headFileId;
    }
}
