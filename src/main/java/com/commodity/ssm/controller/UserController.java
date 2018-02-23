package com.commodity.ssm.controller;

import com.commodity.ssm.model.User;
import com.commodity.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author GongDiXin
 * @version 1.0
 * @created 2017/3/21 20:48
 * @description
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    private Logger log = Logger.getLogger(UserController.class);

    /**
     * @author GongDiXin
     * @date 2017/11/13 0:27
     * @description
     * @param
     * @return
     * @throws
    */
    @Resource
    private UserService userService;
    

    @RequestMapping(value = "/login",method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public User login(HttpServletRequest request){
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUserName(name);
        user.setPassword(password);
        User loginUser = userService.login(user);
        return loginUser;
    }

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request,Model model){
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList",userList);
        return "/biz/showUser";
    }
}
