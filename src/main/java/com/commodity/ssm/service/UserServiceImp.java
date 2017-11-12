package com.commodity.ssm.service;

import com.commodity.ssm.model.User;
import com.commodity.ssm.dao.UserDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 龚帝鑫 on 2017/3/21/0021.
 */
@Service
public class UserServiceImp implements UserService{

    @Resource
    private UserDAO userDAO;
    public List<User> getAllUser() {
       List<User> users = userDAO.selectAllUser();
       return users;
    }

    public User login(User user) {
        return userDAO.queryUserByNameAndPassword(user);
    }
}
