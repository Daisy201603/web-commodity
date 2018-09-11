package com.commodity.filter;

import com.commodity.common.RequestHolder;
import com.commodity.ssm.model.User;
import com.commodity.util.CommodityConst;
import com.commodity.util.ValidateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author GongDiXin
 * @version 1.0
 * @created 2018/3/29 21:34
 */
public class LoginFilter implements Filter{

    Logger logger = LoggerFactory.getLogger(LoginFilter.class);

    /**
     * 登录请求
     * */
    private final String LOGIN_URL = "/commodity/user/userLogin";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        // 如果是登录界面发起的登录请求不过滤
        if (!LOGIN_URL.equals(request.getRequestURI())) {
            User user = (User)session.getAttribute(CommodityConst.REQUEST_USER);
            if (user == null) {
                response.sendRedirect(request.getContextPath() + "/login.jsp");
                return;
            } else {
                RequestHolder.addRequest(request);
                RequestHolder.addUser(user);
            }
        }
        chain.doFilter(servletRequest, response);
    }

    @Override
    public void destroy() {

    }
}
