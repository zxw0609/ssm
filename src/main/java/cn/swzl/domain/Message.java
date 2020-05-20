package cn.swzl.domain;

import java.io.Serializable;

/**
 * @author zhangxw
 * @date 20/2/17 - 11:54
 */
public class Message implements Serializable {
    private String message;
    private int id;
    private int inforId;
    private int userId;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", id=" + id +
                ", inforId=" + inforId +
                ", userId=" + userId +
                '}';
    }
}
