package com.commodity.ssm.dao;
import com.commodity.ssm.model.Course;
import com.commodity.ssm.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.commodity.ssm.model.User;
import java.util.List;

/**
 * @author GongDiXin
 * @date 2018/3/20 23:12
 * @param
 * @return
 * @exception
*/
@Repository
public interface UserDAO {

    /**
     * 查询所有用户
     *
     * @author GongDiXin
     * @date 2018/7/30 23:08
     * @param
     * @return
     * @exception
    */
    List<User> selectAllUser();

    /**
     * 登录查询用户
     *
     * @author GongDiXin
     * @date 2018/7/30 23:07
     * @param user
     *          用邮箱或者电话
     * @return
    */
    User queryUserByNameAndPassword(User user);

    /**
     * 注册
     *
     * @author GongDiXin
     * @date 2018/8/1 20:50
     * @param user
     * @return 主键id
    */
    int register(User user);

    /**
     * 根据电话和邮箱查询用户
     *
     * @author GongDiXin
     * @date 2018/8/1 20:55
     * @param user
     * @return
     * @exception
    */
    User queryUserByPhoneAndEmail(User user);

    /**
     * Mybatis一对多或多对多训练
     *
     * @author GongDiXin
     * @date 2018/3/14 19:24
     * @param studentId
     * @return
     * @exception
    */
    Student selectStudentWithAddress(@Param("studentId") int studentId);

    /**
     * Mybatis一对多或多对多训练
     *
     * @author GongDiXin
     * @date 2018/3/14 22:13
     * @param studentId
     * @return
    */
    Student selectStudentWithAddressTwo(@Param("studentId") int studentId);

    /**
     * Mybatis一对多或多对多训练
     *
     * @author GongDiXin
     * @date 2018/3/14 22:13
     * @param studentId
     * @return
    */
    Student selectStudentWithAddressThree(@Param("studentId") int studentId);

    /**
     * Mybatis一对多或多对多训练
     *
     * @author GongDiXin
     * @date 2018/3/14 22:53
     * @param tutorId
     * @return
    */
    List<Course> findTutorByIdOne(@Param("tutorId") int tutorId);

    /**
     * Mybatis一对多或多对多训练
     *
     * @author GongDiXin
     * @date 2018/3/14 22:53
     * @param tutorId
     * @return
     */
    List<Course> findTutorByIdTwo(@Param("tutorId") int tutorId);

    /**
     * Mybatis一对多或多对多训练
     *
     * @author GongDiXin
     * @date 2018/3/14 22:53
     * @return
     */
    List<Course> findAllTutor();
}
