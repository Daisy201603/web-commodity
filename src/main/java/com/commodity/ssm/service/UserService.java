package com.commodity.ssm.service;

import com.commodity.ssm.model.Course;
import com.commodity.ssm.model.Student;
import com.commodity.ssm.model.User;

import java.util.List;

/**
 * @author GongDiXin
 * @date 2018/3/14 19:38
 * @param
 * @return
 * @exception
*/

public interface UserService {
    
    /**
     * @author GongDiXin
     * @date 2018/3/14 19:39
     * @param
     * @return
     * @exception
    */
    List<User> getAllUser();
    
    /**
     * @author GongDiXin
     * @date 2018/3/14 19:39
     * @param
     * @return
     * @exception
    */
    User login(User user);

    /**
     * @author GongDiXin
     * @date 2018/3/14 19:24
     * @param studentId
     * @return
     */
    Student selectStudentWithAddress(int studentId);

    /**
     * @author GongDiXin
     * @date 2018/3/14 22:13
     * @param
     */
    Student selectStudentWithAddressTwo(int studentId);

    /**
     * @author GongDiXin
     * @date 2018/3/14 22:13
     * @param studentId
     */
    Student selectStudentWithAddressThree(int studentId);

    /**
     * @author GongDiXin
     * @date 2018/3/14 22:53
     * @param tutorId
     */
    List<Course> findTutorByIdOne(int tutorId);

    /**
     * @author GongDiXin
     * @date 2018/3/14 22:53
     * @param tutorId
     */
    List<Course> findTutorByIdTwo(int tutorId);

    /**
     * @author GongDiXin
     * @date 2018/3/14 22:53
     */
    List<Course> findAllTutor();
}
