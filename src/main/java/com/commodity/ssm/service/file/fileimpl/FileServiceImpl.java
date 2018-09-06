package com.commodity.ssm.service.file.fileimpl;

import com.commodity.ssm.dao.file.FileDAO;
import com.commodity.ssm.model.file.FileInfo;
import com.commodity.ssm.service.file.FileService;
import com.commodity.util.FileUtil;
import com.commodity.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author GongDiXin
 * @version 1.0
 * @created 2018/9/4 20:53
 */
@Component
public class FileServiceImpl implements FileService {

    @Autowired
    private FileDAO fileDAO;

    @Override
    public String uploadHeadPortrait(HttpServletRequest request, MultipartFile headPortrait) {
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
            return "文件上传成功";
        }
    }
}
