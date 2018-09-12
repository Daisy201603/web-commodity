package com.commodity.ssm.service;

import com.commodity.ssm.dao.UserInfoDAO;
import com.commodity.ssm.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author GongDiXin
 * @version 1.0
 * @created 2018/9/12 21:47
 */
@Component
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDAO userInfoDAO;

    @Override
    public UserInfo getUserInfo(Integer userId) {
        return userInfoDAO.getUserInfo(userId);
    }
}
