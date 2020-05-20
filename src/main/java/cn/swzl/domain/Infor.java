package cn.swzl.domain;

import java.io.Serializable;

/**
 * @author zhangxw
 * @date 20/2/20 - 22:13
 */
public class Infor implements Serializable {

    private int id;
    private int userId;
    private String tname;
    private String infor;
    private String tape;
    private String locar;
    private String genre;
    private String stape;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }

    public String getTape() {
        return tape;
    }

    public void setTape(String tape) {
        this.tape = tape;
    }

    public String getLocar() {
        return locar;
    }

    public void setLocar(String locar) {
        this.locar = locar;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStape() {
        return stape;
    }

    public void setStape(String stape) {
        this.stape = stape;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Infor{" +
                "id=" + id +
                ", userId=" + userId +
                ", tname='" + tname + '\'' +
                ", infor='" + infor + '\'' +
                ", tape='" + tape + '\'' +
                ", locar='" + locar + '\'' +
                ", genre='" + genre + '\'' +
                ", stape='" + stape + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
