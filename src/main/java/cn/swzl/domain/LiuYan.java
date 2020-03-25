package cn.swzl.domain;

import java.io.Serializable;

/**
 * @author zhangxw
 * @date 20/2/17 - 11:54
 */
public class LiuYan implements Serializable {
    private String username;
    private String liuyan;
    private int id;
    private int InforId;
    private String headPortrait;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLiuyan() {
        return liuyan;
    }

    public void setLiuyan(String liuyan) {
        this.liuyan = liuyan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInforId() {
        return InforId;
    }

    public void setInforId(int inforId) {
        InforId = inforId;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    @Override
    public String toString() {
        return "LiuYan{" +
                "username='" + username + '\'' +
                ", liuyan='" + liuyan + '\'' +
                ", id=" + id +
                ", InforId=" + InforId +
                ", headPortrait='" + headPortrait + '\'' +
                '}';
    }
}
