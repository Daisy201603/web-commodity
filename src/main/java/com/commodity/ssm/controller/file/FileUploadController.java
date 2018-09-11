package com.commodity.ssm.controller.file;

import com.commodity.common.JsonData;
import com.commodity.ssm.manager.UserManager;
import com.commodity.ssm.model.User;
import com.commodity.ssm.model.file.FileInfo;
import com.commodity.ssm.service.file.FileService;
import com.commodity.util.CommodityConst;
import com.commodity.util.ValidateUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author GongDiXin
 * @version 1.0
 * @created 2018/8/31 0:09
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {

    @Autowired
    private FileService fileService;

    /**
     * 上传用户头像
     *
     * @author GongDiXin
     * @date 2018/8/31 0:10
     * @param
     * @return JsonData
    */
    @RequestMapping(value = "/uploadHeadPortrait", method = RequestMethod.POST)
    public String uploadHeadPortrait(HttpServletRequest request, @RequestPart("headPortrait") MultipartFile headPortrait) {
        User user = (User) request.getSession().getAttribute(CommodityConst.REQUEST_USER);
        String result;
        if (ValidateUtil.isEmpty(user.getUserInfo()) || StringUtils.isBlank(user.getUserInfo().getHeadFileId())) {
            result = fileService.uploadHeadPortrait(request, headPortrait, user.getId());
        } else {
            result = fileService.updateHeadPortrait(request, user, headPortrait);
        }
        request.setAttribute("uploadResult", result);
        return "/biz/UploadResult";
    }

    /**
     * 获取用户头像
     *
     * @author GongDiXin
     * @date 2018/9/9 21:58
     * @param
     * @return
     * @exception
    */
    @RequestMapping(value = "/getUserHeadPortraitUrl", method = RequestMethod.POST)
    public JsonData getUserHeadPortraitUrl(@RequestParam("userId") String userId, HttpServletRequest request) {
        User user = UserManager.getCurrentLoginUser(Integer.parseInt(userId));
        if (ValidateUtil.isEmpty(user)) {
            user = (User) request.getSession().getAttribute(CommodityConst.REQUEST_USER);
        }
        if (ValidateUtil.isEmpty(user)) {
            return JsonData.fail("用户不存在");
        }

        if (StringUtils.isBlank(user.getUserInfo().getHeadImgUrl())) {
            FileInfo fileInfo = fileService.getUserHeadPortraitUrl(user);
            if (ValidateUtil.isEmpty(fileInfo)) {
                return JsonData.fail("未获取到用户头像地址");
            } else {
                user.getUserInfo().setHeadFileId(fileInfo.getFileId());
                user.getUserInfo().setHeadImgUrl(fileInfo.getFileUrl());
                request.getSession().setAttribute(CommodityConst.REQUEST_USER, user);
                return JsonData.success(fileInfo.getFileUrl());
            }
        } else {
            return JsonData.success(user.getUserInfo().getHeadImgUrl());
        }


    }
}
