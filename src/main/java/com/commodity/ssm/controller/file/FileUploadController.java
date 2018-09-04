package com.commodity.ssm.controller.file;

import com.commodity.common.JsonData;
import com.commodity.ssm.service.file.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;

/**
 * @author GongDiXin
 * @version 1.0
 * @created 2018/8/31 0:09
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {

    Logger logger = LoggerFactory.getLogger(FileUploadController.class);

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
    public void uploadHeadPortrait(@RequestPart("headPortrait") byte[] headPortrait) {
        if (headPortrait == null) {
            logger.info("文件数据为空");
        }
        fileService.uploadHeadPortrait(headPortrait);
    }
}
