package com.commodity.ssm.service.file;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
     * @param headPortrait
     * @return String
    */
    String uploadHeadPortrait(MultipartFile headPortrait);
}
