package com.commodity.ssm.manager;

import com.commodity.ssm.model.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author GongDiXin
 * @version 1.0
 * @created 2018/9/6 23:14
 */
public class UserManager {

    private static Map<Integer, User> userManager = new ConcurrentHashMap<>();

    /**
     * 添加登录用户
     *
     * @author GongDiXin
     * @date 2018/9/6 23:17
     * @param user
     */
    public static void addUser(User user) {
        userManager.put(user.getId(), user);
    }

    /**
     * 获取登录用户
     *
     * @author GongDiXin
     * @date 2018/9/6 23:19
     * @param
     * @return
     * @exception
    */
    public static User getCurrentLoginUser(int userId) {
        return userManager.get(userId);
    }
}
