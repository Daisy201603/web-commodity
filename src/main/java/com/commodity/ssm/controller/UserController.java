package com.commodity.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.commodity.common.JsonData;
import com.commodity.ssm.model.Course;
import com.commodity.ssm.model.Student;
import com.commodity.ssm.model.User;
import com.commodity.ssm.service.UserService;
import com.commodity.util.ValidateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    

    @RequestMapping(value = "/login",method= {RequestMethod.GET})
    public ModelAndView login(HttpServletRequest request){
        // User user = sessionCheck(request);
        ModelAndView model = new ModelAndView();
        // model.addObject("user",user);
        model.setViewName("/biz/login");
        return model;
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
    public boolean userLogin(@RequestBody User user, HttpServletRequest request){
        if (false) {
            // TODO:!ValidateUtil.isEmpty(sessionCheck(request))
            return true;
        } else {
            User loginUser = userService.login(user);
            if (!ValidateUtil.isEmpty(loginUser)) {
                HttpSession session = request.getSession();
                session.setAttribute("loginUser",loginUser);
                return true;
            }
        }
        return false;
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

    @RequestMapping("/queryStudentOne")
    @ResponseBody
    public String queryStudentOne(HttpServletRequest request,Model model){
        int studentId = 1;
        Student student = userService.selectStudentWithAddress(studentId);
        return JSON.toJSON(student).toString();
    }

    @RequestMapping("/queryStudentTwo")
    @ResponseBody
    public String queryStudentTwo(HttpServletRequest request,Model model){
        int studentId = 1;
        Student student = userService.selectStudentWithAddressTwo(studentId);
        return JSON.toJSON(student).toString();
    }

    @RequestMapping("/queryStudentThree")
    @ResponseBody
    public String queryStudentThree(HttpServletRequest request,Model model){
        int studentId = 2;
        Student student = userService.selectStudentWithAddressThree(studentId);
        return JSON.toJSON(student).toString();
    }

    @RequestMapping("/findTutorByIdOne")
    @ResponseBody
    public String findTutorByIdOne(HttpServletRequest request,Model model){
        int tutorId = 2;
        List<Course> courses = userService.findTutorByIdOne(tutorId);
        return JSON.toJSON(courses).toString();
    }

    @RequestMapping("/findTutorByIdTwo")
    @ResponseBody
    public String findTutorByIdTwo(HttpServletRequest request,Model model){
        int tutorId = 2;
        List<Course> courses = userService.findTutorByIdTwo(tutorId);
        return JSON.toJSON(courses).toString();
    }

    @RequestMapping("/findAllTutor")
    @ResponseBody
    public String findAllTutor(HttpServletRequest request,Model model){
        List<Course> courses = userService.findAllTutor();
        return JSON.toJSON(courses).toString();
    }

    /**
     * session检查
     *
     * @author GongDiXin
     * @date 2018/3/29 21:47
     * @param request
     * @return 是否存在session
    */
    private User sessionCheck(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user =  (User) session.getAttribute("loginUser");
        if (ValidateUtil.isEmpty(user)) {
            return null;
        }
        User queryUser = userService.login(user);
        if (ValidateUtil.isEmpty(queryUser)) {
            return null;
        } else {
            return queryUser;
        }
    }
}
