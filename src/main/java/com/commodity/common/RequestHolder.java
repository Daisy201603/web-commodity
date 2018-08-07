package com.commodity.common;

import com.commodity.ssm.model.User;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求控制
 *
 * @author GongDiXin
 * @version 1.0
 * @created 2018/8/6 21:57
 */
public class RequestHolder {

    private static final ThreadLocal<HttpServletRequest> REQUEST_HOLDER = new ThreadLocal<>();

    private static final ThreadLocal<User> USER_HOLDER = new ThreadLocal<>();

    /**
     * 添加Request
     *
     * @author GongDiXin
     * @date 2018/8/6 22:26
     * @param request
     */
    public static void addRequest(HttpServletRequest request) {
        REQUEST_HOLDER.set(request);
    }

    /**
     * 获取当前用户
     *
     * @author GongDiXin
     * @date 2018/8/6 22:25
     * @return
    */
    public static User getCurrentUser() {
        return USER_HOLDER.get();
    }

    /**
     * 获取当前Request
     *
     * @author GongDiXin
     * @date 2018/8/6 22:25
     * @return
    */
    public static HttpServletRequest getCurrentRequest() {
        return REQUEST_HOLDER.get();
    }

    /**
     * 添加用户
     *
     * @author GongDiXin
     * @date 2018/8/6 22:26
     * @param user
    */
    public static void addUser(User user) {
        USER_HOLDER.set(user);
    }

    /**
     * 移除用户
     *
     * @author GongDiXin
     * @date 2018/8/6 22:26
     */
    public static void remove() {
        USER_HOLDER.remove();
        REQUEST_HOLDER.remove();
    }
}
