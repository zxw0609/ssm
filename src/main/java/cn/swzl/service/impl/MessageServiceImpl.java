package cn.swzl.service.impl;

import cn.swzl.dao.MessageDao;
import cn.swzl.domain.Message;
import cn.swzl.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangxw
 * @date 20/2/17 - 12:09
 */

@Service("accountService")
public class MessageServiceImpl implements MessageService {

    @Autowired //注入
    private MessageDao messageDao;

    public List<Message> find(int inforId) {
        System.out.println("业务层:查询物品留言");
        return messageDao.find(inforId);
    }


    public void saveMessage(Message message) {
        System.out.println("业务层：保存留言信息");
        messageDao.saveMessage(message);
    }

    /*public void delete(int inforId) {
        System.out.println("业务层：删除物品对应的留言信息");
        MessageDao.delete(inforId);
    }*/
}
