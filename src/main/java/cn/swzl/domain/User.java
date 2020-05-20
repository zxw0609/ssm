package cn.swzl.domain;

import java.io.Serializable;

/**
 * @author zhangxw
 * @date 20/2/20 - 19:55
 */
public class User implements Serializable {
    private int id;
    //用户名
    private String username;
    //密码
    private String password;
    //学号
    private String stu;
    //姓名
    private String name;
    //班级
    private String grade;
    //专业
    private String magor;
    //院系
    private String department;
    //头像
    private String headPortrait;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStu() {
        return stu;
    }

    public void setStu(String stu) {
        this.stu = stu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMagor() {
        return magor;
    }

    public void setMagor(String magor) {
        this.magor = magor;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", stu='" + stu + '\'' +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", magor='" + magor + '\'' +
                ", department='" + department + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                '}';
    }
}
