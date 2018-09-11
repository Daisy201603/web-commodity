package com.commodity.ssm.service.file.fileimpl;

import com.commodity.common.JsonData;
import com.commodity.ssm.dao.file.FileDAO;
import com.commodity.ssm.manager.UserManager;
import com.commodity.ssm.model.User;
import com.commodity.ssm.model.UserInfo;
import com.commodity.ssm.model.file.FileInfo;
import com.commodity.ssm.service.file.FileService;
import com.commodity.system.CommoditySystem;
import com.commodity.util.CommodityConst;
import com.commodity.util.DateUtil;
import com.commodity.util.FileUtil;
import com.commodity.util.ValidateUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author GongDiXin
 * @version 1.0
 * @created 2018/9/4 20:53
 */
@Component
public class FileServiceImpl implements FileService {

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Autowired
    private FileDAO fileDAO;

    @Override
    public String uploadHeadPortrait(HttpServletRequest request, MultipartFile headPortrait, Integer userId) {
        String filename = headPortrait.getName();
        boolean legalType = FileUtil.checkImgType(filename);
        if (legalType) {
            return "不支持的文件类型";
        }
        FileInfo fileInfo = FileUtil.upload(request, headPortrait);
        if (ValidateUtil.isEmpty(fileInfo)) {
            return "文件上传失败";
        } else {
            fileDAO.addFileInfo(fileInfo);
            updateUserInfo(request, fileInfo, userId);
            return "文件上传成功";
        }
    }

    @Override
    public String updateHeadPortrait(HttpServletRequest request, User user, MultipartFile headPortrait) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setUserId(user.getId());
        fileInfo.setFileName(headPortrait.getOriginalFilename());
        fileInfo.setLastModifyTime(DateUtil.getCurrentTime("yyyy-MM-dd hh:mm:ss"));
        fileInfo.setFileUrl(CommoditySystem.getOrdinaryFileUrl() + headPortrait.getOriginalFilename());
        fileDAO.updateHeadPortrait(fileInfo);
        updateUserInfo(request, fileInfo, user.getId());
        return "更新成功";
    }

    @Override
    public FileInfo getUserHeadPortraitUrl(User user) {
        if (ValidateUtil.isEmpty(user.getId())) {
            if (logger.isErrorEnabled()) {
                logger.error("用户id为空");
            }
            return null;
        }
        FileInfo fileInfo =  fileDAO.getUserHeadPortraitUrl(user.getId());
        return fileInfo;
    }

    /**
     * 更新用户信息
     *
     * @author GongDiXin
     * @date 2018/9/11 23:38
     * @param
     * @return
     * @exception
    */
    private void updateUserInfo(HttpServletRequest request, FileInfo fileInfo, Integer userId) {
        User user = UserManager.getCurrentLoginUser(userId);
        UserInfo userInfo = new UserInfo();
        userInfo.setHeadFileId(fileInfo.getFileId());
        userInfo.setHeadImgUrl(fileInfo.getFileUrl());
        user.setUserInfo(userInfo);
        request.setAttribute(CommodityConst.REQUEST_USER, user);
    }
}
