package cn.swzl.dao;

import cn.swzl.domain.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangxw
 * @date 20/2/17 - 12:01
 */
@Repository  //将该类交给ioc容器进行管理
public interface MessageDao {
    //查询物品留言
    @Select("select * from message where inforId = #{inforId} order by id desc")
    public List<Message> find(int inforId);

    //保存留言信息
    @Insert(value = "insert into message (inforId,username,message,headPortrait) value (#{inforId},#{username},#{message},#{headPortrait})")
    public void saveMessage(Message message);

    //删除留言信息
    /**
     * 删除物品对用的留言信息
     * @param inforId
     */
    /*@Delete("delete from message where inforId = #{inforId}")
    public void delete(int inforId);*/
}









