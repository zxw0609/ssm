package cn.swzl.service.impl;

import cn.swzl.dao.LiuYanDao;
import cn.swzl.domain.LiuYan;
import cn.swzl.service.LiuYanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangxw
 * @date 20/2/17 - 12:09
 */

@Service("accountService")
public class LiuYanServiceImpl implements LiuYanService {

    @Autowired //注入
    private LiuYanDao liuYanDao;

    public List<LiuYan> find(int InforId) {
        System.out.println("业务层:查询物品留言");
        return liuYanDao.find(InforId);
    }


    public void saveLiuYan(LiuYan liuYan) {
        System.out.println("业务层：保存留言信息");
        liuYanDao.saveLiuYan(liuYan);
    }

    /*public void delete(int InforId) {
        System.out.println("业务层：删除物品对应的留言信息");
        liuYanDao.delete(InforId);
    }*/
}
