package cn.swzl.service;

import cn.swzl.domain.User;

import java.util.List;

/**
 * @author zhangxw
 * @date 20/2/20 - 20:14
 */
public interface UserService {

    //查询所有用户
    public List<User> findAll();
    //保存用户信息
    public void saveUser(User user);
    //查询单个用户用于登录验证;
    public User findOne(String username);
    public User findOneId(int userId);
    //修改用户信息
    public void update(User user);
    //修改用户密码
    public void updatePas(String password ,String username);
}
