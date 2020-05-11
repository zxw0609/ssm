package cn.swzl.domain;

import java.io.Serializable;

/**
 * @author zhangxw
 * @date 20/2/17 - 11:54
 */
public class Message implements Serializable {
    private String username;
    private String message;
    private int id;
    private int inforId;
    private String headPortrait;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInforId() {
        return inforId;
    }

    public void setInforId(int inforId) {
        this.inforId = inforId;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    @Override
    public String toString() {
        return "Message{" +
                "username='" + username + '\'' +
                ", message='" + message + '\'' +
                ", id=" + id +
                ", inforId=" + inforId +
                ", headPortrait='" + headPortrait + '\'' +
                '}';
    }
}
