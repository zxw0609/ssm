package cn.swzl.service;

import cn.swzl.domain.LiuYan;

import java.util.List;

/**
 * @author zhangxw
 * @date 20/2/17 - 12:08
 */
public interface LiuYanService {
    //查询物品留言
    public List<LiuYan> find(int InforId);

    //保存留言信息
    public void saveLiuYan(LiuYan liuYan);

    /*//删除物品对应的留言信息
    public void delete(int InforId);*/
}
