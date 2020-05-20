package cn.swzl.service.impl;

import cn.swzl.dao.UserDao;
import cn.swzl.domain.User;
import cn.swzl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangxw
 * @date 20/2/20 - 20:17
 */
@Service("userService")
/*1、@service("serviceName")： 表示给当前类命名一个别名，方便注入到其他类中；
2、@service：不加的话，默认别名就是当前类名，但是首字母小写*/
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findAll() {
        System.out.println("service:查询所有用户信息");
        return userDao.findAll();
    }


    public void saveUser(User user) {
        System.out.println("service:保存用户信息");
        userDao.saveUser(user);
    }

    public User findOne(String username) {
        System.out.println("service:查询单个用户");
        return userDao.findOne(username);
    }

    public User findOneId(int userId) {
        System.out.println("service:查询单个用户");
        return userDao.findOneId(userId);
    }

    public void update(User user) {
        System.out.println("service:修改用户信息");
        userDao.updateUser(user);
    }

    public void updatePas(String password, String username) {
        System.out.println("service:修改用户密码");
        userDao.updatePas(password,username);
    }
}
