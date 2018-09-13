package com.commodity.ssm.service.file;

import com.commodity.common.JsonData;
import com.commodity.ssm.model.User;
import com.commodity.ssm.model.file.FileInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author GongDiXin
 * @version 1.0
 * @created 2018/9/4 20:52
 */
@Service
public interface FileService {

    /**
     * 上传用户头像
     *
     * @author GongDiXin
     * @date 2018/9/4 21:02
     * @param request
     * @param headPortrait
     * @param userId
     *
     * @return String
    */
    String uploadHeadPortrait(HttpServletRequest request, MultipartFile headPortrait, Integer userId);


    /**
     * 更新用户头像地址
     *
     * @author GongDiXin
     * @date 2018/9/4 21:02
     * @param request
     * @param user
     * @param headPortrait
     * @return String
     */
    String updateHeadPortrait(HttpServletRequest request, User user, MultipartFile headPortrait);

    /**
     * 获取用户头像地址
     *
     * @author GongDiXin
     * @date 2018/9/4 21:02
     * @param user
     * @return
     */
    FileInfo getUserHeadPortraitUrl(User user);

    /**
     * 上传文件
     *
     * @author GongDiXin
     * @date 2018/9/4 21:02
     * @param file
     * @return JsonData
     */
    JsonData uploadFile(MultipartFile file);
}
