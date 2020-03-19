package cn.swzl.service.impl;

import cn.swzl.dao.InforDao;
import cn.swzl.domain.Infor;
import cn.swzl.service.InforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangxw
 * @date 20/2/20 - 22:33
 */
@Service("inforService")
public class InforServiceImpl implements InforService {

    @Autowired
    private InforDao inforDao;

    public void saveInfor(Infor infor) {
        System.out.println("service:保存物品信息");
        inforDao.saveInfor(infor);
    }


    public List<Infor> findAll() {
        System.out.println("service:查询所有物品信息");
        return inforDao.findAll();
    }

    public List<Infor> find(String xinxi) {
        System.out.println("service:模糊查询相关物品信息");
        return inforDao.find("%"+xinxi+"%");
    }

    public Infor findOne(int id) {
        System.out.println("service:查询指定id的物品信息");
        return inforDao.findOne(id);
    }

    public List<Infor> userFind(String username) {
        System.out.println("service:查询指定用户名的物品信息");
        return inforDao.userFind(username);
    }

    public void update(Infor infor) {
        System.out.println("service:更新物品信息");
        inforDao.update(infor);
    }

    public void delete(int id) {
        System.out.println("service:删除物品信息");
        inforDao.delete(id);
    }
}
