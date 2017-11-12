package com.commodity.ssm.service;

import com.commodity.ssm.model.User;

import java.util.List;

/**
 * Created by 龚帝鑫 on 2017/3/21/0021.
 */

public interface UserService {
    List<User> getAllUser();
    User login(User user);
}
