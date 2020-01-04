package top.qiin.library.bean;


import java.util.Date;

/**
 * @program: library
 * @description:
 * @author: qin
 * @create: 2019-11-24 19:24
 **/

public class Student {
    private Integer id;
    private Integer sid;
    private String sname;
    private Sex sex;
    private Integer sexid;
    private Date stime;
    private String password;
    private Integer administrator;
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sex=" + sex +
                ", sexid=" + sexid +
                ", stime=" + stime +
                ", password='" + password + '\'' +
                ", administrator=" + administrator +
                '}';
    }

    public Integer getSexid() {
        return sexid;
    }

    public void setSexid(Integer sexid) {
        this.sexid = sexid;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getStime() {
        return stime;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Integer administrator) {
        this.administrator = administrator;
    }
}
