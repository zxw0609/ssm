package cn.swzl.dao;

import cn.swzl.domain.Infor;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangxw
 * @date 20/2/20 - 22:10
 */
@Repository
public interface InforDao {

    /**
     * 保存物品信息
     * @param infor
     */
    @Insert("insert into infors (username,tname,infor,tape,locar,genre,stape,headPortrait,image) values (#{username},#{tname},#{infor},#{tape},#{locar},#{genre},#{stape},#{headPortrait},#{image})")
    public void saveInfor(Infor infor);

    /**
     * 查询所有信息
     * @return
     */
    @Select("select * from infors order by stape desc")
    public List<Infor> findAll();

    /**
     * 查询相关信息
     * @return
     */

    @Select("select * from infors where tname like #{xinxi} or infor like #{xinxi} or locar like #{xinxi} or genre like #{xinxi} and act='0'")
    public List<Infor> find(String xinxi);

    /**
     * 查询单个信息
     * @param id
     * @return
     */
    @Select("select * from infors where id = #{id}")
    public Infor findOne(int id);

    /**
     * 查询用户所有物品信息
     * @param username
     * @return
     */
    @Select("select * from infors where username = #{username} order by stape desc")
    public List<Infor> userFind(String username);

    /**
     * 更新物品信息
     * @param infor
     */
    @Update("update infors set tname=#{tname},infor=#{infor},tape=#{tape},locar=#{locar},genre=#{genre},image=#{image} where id=#{id}")
    public void update(Infor infor);

    /**
     * 删除物品信息
     * @param id
     */
    @Delete("delete from infors where id = #{id}")
    public void delete(int id);

    /**
     * 用户更改头像时更改所有物品信息中对应的用户头像
     * @param username
     */
    @Update("update infors set headPortrait=#{headPortrait} where username=#{username}")
    public void updateHeadPortrait(@Param("username") String username, @Param("headPortrait") String headPortrait);
}
