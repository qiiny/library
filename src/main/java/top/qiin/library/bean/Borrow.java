package top.qiin.library.bean;

import java.util.Date;

/**
 * @program: library
 * @description:
 * @author: qin
 * @create: 2019-12-28 14:34
 **/

public class Borrow {
    private Integer id;
    private Integer bid;
    private String bname;
    private String sname;
    private Date jtime;
    private Date gtime;
    private Integer huan;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", bid=" + bid +
                ", bname='" + bname + '\'' +
                ", sname='" + sname + '\'' +
                ", jtime=" + jtime +
                ", gtime=" + gtime +
                ", huan=" + huan +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getJtime() {
        return jtime;
    }

    public void setJtime(Date jtime) {
        this.jtime = jtime;
    }

    public Date getGtime() {
        return gtime;
    }

    public void setGtime(Date gtime) {
        this.gtime = gtime;
    }

    public Integer getHuan() {
        return huan;
    }

    public void setHuan(Integer huan) {
        this.huan = huan;
    }
}
