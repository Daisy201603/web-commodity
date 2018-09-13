package com.commodity.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.commodity.common.JsonData;
import com.commodity.common.RequestHolder;
import com.commodity.ssm.manager.UserManager;
import com.commodity.ssm.model.Course;
import com.commodity.ssm.model.Student;
import com.commodity.ssm.model.User;
import com.commodity.ssm.service.UserService;
import com.commodity.util.CommodityConst;
import com.commodity.util.ValidateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

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
    private Logger logger = Logger.getLogger(UserController.class);

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
    

    @RequestMapping(value = "/login",method= {RequestMethod.GET})
    public String login(HttpServletRequest request){
        return "redirect:login";
    }

    /**
     * 用户登录
     *
     * @author GongDiXin
     * @date 2018/8/1 20:43
     * @param
     * @return
     * @exception
    */
    @RequestMapping(value = "/userLogin",method= {RequestMethod.POST})
    @ResponseBody
    public JsonData userLogin(@RequestBody User user, HttpServletRequest request){
        User loginUser = userService.login(user);
        String lastRequestUrl = request.getRequestURI().toString();
        if (!ValidateUtil.isEmpty(loginUser)) {
            request.getSession().setAttribute(CommodityConst.REQUEST_USER, loginUser);
            UserManager.addUser(loginUser);
            return JsonData.success("登录成功", new Object[]{loginUser.getPhone(), loginUser.getEmail(), loginUser.getUsername(), lastRequestUrl});
        }
        return JsonData.fail("登录失败");
    }

    /**
     * 注册
     *
     * @author GongDiXin
     * @date 2018/8/1 20:54
     * @param
     * @return
     * @exception
    */
    @RequestMapping(value = "/userRegister",method= {RequestMethod.POST})
    @ResponseBody
    public JsonData userRegister(@RequestBody User user, HttpServletRequest request){
       return userService.register(user);
    }

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request,Model model){
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList",userList);
        return "/biz/showUser";
    }

    @RequestMapping("/homepage")
    public String homepage(){
        return "biz/homepage";
    }

    @RequestMapping("/logout")
    public void logout(@RequestParam("userId") Integer userId, HttpServletRequest request){
        request.getSession().removeAttribute("user");
        // 移除本地变量
        RequestHolder.remove();
        UserManager.removeUser(userId);
    }
}
