package com.commodity.ssm.dao.file;

import com.commodity.ssm.model.file.FileInfo;
import org.springframework.stereotype.Component;

/**
 * 文件DBM
 *
 * @author GongDiXin
 * @version 1.0
 * @created 2018/9/6 22:41
 */
@Component
public interface FileDAO {

    /**
     * 增加文件信息
     *
     * @author GongDiXin
     * @date 2018/9/6 22:42
     * @param fileInfo
     * @return
     * @exception
    */
    int addFileInfo(FileInfo fileInfo);

    /**
     * 更新用户头像地址
     *
     * @author GongDiXin
     * @date 2018/9/9 22:55
     * @param fileInfo
    */
    void updateHeadPortrait(FileInfo fileInfo);

    /**
     * 获取用户头像
     *
     * @author GongDiXin
     * @date 2018/9/6 22:42
     * @param userId
     * @return
     * @exception
     */
    String getUserHeadPortraitUrl(Integer userId);
}
