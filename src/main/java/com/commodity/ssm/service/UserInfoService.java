package com.commodity.ssm.service;

import com.commodity.ssm.model.UserInfo;
import org.springframework.stereotype.Service;

/**
 * @author GongDiXin
 * @version 1.0
 * @created 2018/9/12 21:47
 */
@Service
public interface UserInfoService {

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
