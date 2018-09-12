package com.commodity.ssm.dao;

import com.commodity.ssm.model.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * @author GongDiXin
 * @version 1.0
 * @created 2018/9/12 21:00
 */
@Repository
public interface UserInfoDAO {

    /**
     * 添加用户信息
     *
     * @author GongDiXin
     * @date 2018/9/12 21:01
     * @param userInfo
     * @return
     * @exception
    */
    int insertUserInfo(UserInfo userInfo);

    /**
     * 更新用户信息
     *
     * @author GongDiXin
     * @date 2018/9/12 21:20
     * @param userInfo
     * @return
     * @exception
    */
    void updateUserInfo(UserInfo userInfo);

    /**
     * 获取用户信息
     *
     * @author GongDiXin
     * @date 2018/9/12 21:45
     * @param userId
     * @return
    */
    UserInfo getUserInfo(Integer userId);
}
