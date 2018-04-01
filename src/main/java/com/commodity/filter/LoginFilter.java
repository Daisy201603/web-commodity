package com.commodity.filter;

import com.commodity.ssm.model.User;
import com.commodity.util.ValidateUtil;

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

    private static List<String> pattenUrl = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        pattenUrl.add("/index.jsp");
        pattenUrl.add("/user/login");
        pattenUrl.add("/user/userLogin");
        pattenUrl.add(".css");
        pattenUrl.add(".image");
        pattenUrl.add(".js");
        pattenUrl.add(".fonts");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        HttpSession session = servletRequest.getSession();
        User user = (User)session.getAttribute("loginUser");

        String indexUrl = servletRequest.getContextPath() + "/index.jsp";
        String url = servletRequest.getRequestURI().toString();
        if (!ValidateUtil.isEmpty(user)) {
            chain.doFilter(request, response);
            return;
        } else {
            boolean doRedirect = true;
            // 注：在pattenURL中的全部不拦截 url.indexOf(urlStr) > -1 表示urlStr在url中出现过，出现就不拦截
            for (String urlStr : pattenUrl) {
                if (url.indexOf(urlStr) > -1) {
                    doRedirect = false;
                    break;
                }
            }
            if (doRedirect) {
                httpResponse.sendRedirect(indexUrl);
            } else {
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
