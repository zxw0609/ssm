package cn.swzl.dao;

import cn.swzl.domain.LiuYan;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangxw
 * @date 20/2/17 - 12:01
 */
@Repository  //将该类交给ioc容器进行管理
public interface LiuYanDao {
    //查询物品留言
    @Select("select * from liuyanbiao where InforId = #{InforId} order by id desc")
    public List<LiuYan> find(int InforId);

    //保存留言信息
    @Insert(value = "insert into liuyanbiao (InforId,username,liuyan) value (#{InforId},#{username},#{liuyan})")
    public void saveLiuYan(LiuYan liuYan);

    //删除留言信息
    /**
     * 删除物品对用的留言信息
     * @param InforId
     */
    @Delete("delete from liuyanbiao where InforId = #{InforId}")
    public void delete(int InforId);
}









