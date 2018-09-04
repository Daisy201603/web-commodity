package com.commodity.ssm.service.file.fileimpl;

import com.commodity.ssm.service.file.FileService;
import com.commodity.util.FileUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author GongDiXin
 * @version 1.0
 * @created 2018/9/4 20:53
 */
@Component
public class FileServiceImpl implements FileService {

    @Override
    public String uploadHeadPortrait(MultipartFile headPortrait) {
        String resultMsg = "";
        String filename = headPortrait.getName();
        boolean legalType = FileUtil.checkImgType(filename);
        if (legalType) {
            resultMsg = "不支持的文件类型";
            return resultMsg;
        }
        FileUtil.upload(headPortrait);
        return resultMsg;
    }
}
