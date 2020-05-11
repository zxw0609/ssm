package cn.swzl.service;

import cn.swzl.domain.Message;

import java.util.List;

/**
 * @author zhangxw
 * @date 20/2/17 - 12:08
 */
public interface MessageService {
    //查询物品留言
    public List<Message> find(int inforId);

    //保存留言信息
    public void saveMessage(Message message);

    /*//删除物品对应的留言信息
    public void delete(int inforId);*/
}
