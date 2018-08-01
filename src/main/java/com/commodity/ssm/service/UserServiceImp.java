package com.commodity.ssm.service;

import com.commodity.common.JsonData;
import com.commodity.ssm.model.Course;
import com.commodity.ssm.model.Student;
import com.commodity.ssm.model.User;
import com.commodity.ssm.dao.UserDAO;
import com.commodity.util.RegexUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sun.net.util.URLUtil;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * 用户服务
 *
 * @author GongDiXin
 * @date 2018/7/31 22:31
*/
@Service
public class UserServiceImp implements UserService{

    Logger logger = LoggerFactory.getLogger(UserServiceImp.class);

    @Resource
    private UserDAO userDAO;

    @Override
    public List<User> getAllUser() {
       List<User> users = userDAO.selectAllUser();
       return users;
    }

    @Override
    public User login(User user) {
        // 登录时的用户名为邮箱或者电话 保证唯一性
        String account = user.getAccount();
        if (StringUtils.isNotEmpty(account)) {
            if (RegexUtil.regexEmail(account)) {
                user.setEmail(account);
            } else if (RegexUtil.regexPhone(account)) {
                user.setPhone(account);
            }
        } else {
            logger.info("UserServiceImp login" + "登录账号为空");
            return null;
        }

        if (StringUtils.isEmpty(user.getPhone()) && StringUtils.isEmpty(user.getEmail())) {
            logger.info("UserServiceImp login" + "电子邮箱或电话号码为空");
            return null;
        }

        // 目前密码是post提交的 没做编码
        String password = user.getPassword();
        User result = userDAO.queryUserByNameAndPassword(user);
        if (result.getPassword().equals(DigestUtils.md5Hex(password))) {
            return result;
        } else {
            return null;
        }
    }

    @Override
    public JsonData register(User user) {
        if (StringUtils.isEmpty(user.getEmail()) || StringUtils.isEmpty(user.getPhone())) {
            return JsonData.fail("邮箱或电话为空");
        }
        if (userDAO.queryUserByPhoneAndEmail(user) == null) {
            user.setPassword(DigestUtils.md5Hex(user.getPassword()));
            if (userDAO.register(user) != 0) {
                return JsonData.fail("注册成功");
            }
        } else {
            return JsonData.fail("账号已被注册");
        }
        return JsonData.fail("注册失败");
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
