package cn.swzl.dao;

import cn.swzl.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangxw
 * @date 20/2/20 - 20:03
 */
@Repository   //将该类交给ioc容器进行管理
public interface UserDao {

    //查询所有用户
    @Select("select * from users")
    public List<User> findAll();

    //保存用户信息
    @Insert("insert into users (username,password,stu,name,grade,magor,department,headPortrait) value (#{username},#{password},#{stu},#{name},#{grade},#{magor},#{department},#{headPortrait})")
    public void saveUser(User user);

    //查询单个用户
    @Select("select * from users where username = #{username}")
    public User findOne(String username);

    //修改用户信息
    @Update("update users set stu=#{stu},name=#{name},grade=#{grade},magor=#{magor},department=#{department},headPortrait=#{headPortrait} where username=#{username}")
    public void updateUser(User user);

    //修改密码信息
    @Update("update users set password=#{password} where username=#{username}")
    public void updatePas(@Param("password") String password, @Param("username") String username);
}
