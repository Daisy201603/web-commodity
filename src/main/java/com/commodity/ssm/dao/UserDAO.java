package com.commodity.ssm.dao;
import com.commodity.ssm.model.Course;
import com.commodity.ssm.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.commodity.ssm.model.User;
import java.util.List;
/**
 * Created by 龚帝鑫 on 2017/3/20/0020.
 */
@Repository
public interface UserDAO {
    List<User> selectAllUser();
    User queryUserByNameAndPassword(User user);

    /**
     * @author GongDiXin
     * @date 2018/3/14 19:24
     * @param
     * @return
     * @exception
    */
    Student selectStudentWithAddress(@Param("studentId") int studentId);

    /**
     * @author GongDiXin
     * @date 2018/3/14 22:13
     * @param
    */
    Student selectStudentWithAddressTwo(@Param("studentId") int studentId);

    /**
     * @author GongDiXin
     * @date 2018/3/14 22:13
     * @param studentId
    */
    Student selectStudentWithAddressThree(@Param("studentId") int studentId);

    /**
     * @author GongDiXin
     * @date 2018/3/14 22:53
     * @param tutorId
    */
    List<Course> findTutorByIdOne(@Param("tutorId") int tutorId);

    /**
     * @author GongDiXin
     * @date 2018/3/14 22:53
     * @param tutorId
     */
    List<Course> findTutorByIdTwo(@Param("tutorId") int tutorId);

    /**
     * @author GongDiXin
     * @date 2018/3/14 22:53
     */
    List<Course> findAllTutor();
}
