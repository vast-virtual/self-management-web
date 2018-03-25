package vast.selfmanagementweb.mapper;

import org.apache.ibatis.annotations.Mapper;
import vast.selfmanagementweb.model.User;

import java.util.List;
//@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //这个方式我自己加的
    List<User> selectAllUser();

    User selectUserByUserNameAndPassword(User user);

}