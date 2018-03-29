package com.commodity.ssm.service;

import com.commodity.ssm.model.Course;
import com.commodity.ssm.model.Student;
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

    @Override
    public List<User> getAllUser() {
       List<User> users = userDAO.selectAllUser();
       return users;
    }

    @Override
    public User login(User user) {
        return userDAO.queryUserByNameAndPassword(user);
    }

    @Override
    public Student selectStudentWithAddress(int studentId) {
        return userDAO.selectStudentWithAddress(studentId);
    }

    @Override
    public Student selectStudentWithAddressTwo(int studentId) {
        return userDAO.selectStudentWithAddressTwo(studentId);
    }

    @Override
    public Student selectStudentWithAddressThree(int studentId) {
        return userDAO.selectStudentWithAddressThree(studentId);
    }

    @Override
    public List<Course> findTutorByIdOne(int tutorId) {
        return userDAO.findTutorByIdOne(tutorId);
    }

    @Override
    public List<Course> findTutorByIdTwo(int tutorId) {
        return userDAO.findTutorByIdTwo(tutorId);
    }

    @Override
    public List<Course> findAllTutor() {
        return userDAO.findAllTutor();
    }
}
