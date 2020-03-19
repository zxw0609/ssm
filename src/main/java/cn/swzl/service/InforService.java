package cn.swzl.service;

import cn.swzl.domain.Infor;

import java.util.List;

/**
 * @author zhangxw
 * @date 20/2/20 - 22:28
 */
public interface InforService {

    //保存物品信息
    public void saveInfor(Infor infor);

    //查询所有物品信息
    public List<Infor> findAll();

    //根据关键字查询物品信息
    public List<Infor> find(String xinxi);

    //根据id查询指定物品信息
    public Infor findOne(int id);

    //根据用户名查询所有物品信息
    public List<Infor> userFind(String username);

    //更新用户信息
    public void update(Infor infor);

    //删除用户信息
    public void delete(int id);
}
