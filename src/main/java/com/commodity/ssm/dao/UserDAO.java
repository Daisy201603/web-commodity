package com.commodity.ssm.dao;
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
}
