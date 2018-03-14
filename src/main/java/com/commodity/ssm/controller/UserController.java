package com.commodity.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.commodity.ssm.model.Course;
import com.commodity.ssm.model.Student;
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
}
