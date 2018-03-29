package com.commodity.filter;

import com.commodity.ssm.model.User;
import com.commodity.util.ValidateUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author GongDiXin
 * @version 1.0
 * @created 2018/3/29 21:34
 */
public class LoginFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        HttpSession session = servletRequest.getSession();
        User user = (User)session.getAttribute("loginUser");
        if (ValidateUtil.isEmpty(user) || ((HttpServletRequest) request).getRequestURL().toString().contains("index.jsp")) {
            chain.doFilter(request,response);
        } else {
            httpResponse.sendRedirect(servletRequest.getContextPath() + "/index.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
