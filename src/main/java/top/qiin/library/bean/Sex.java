package top.qiin.library.bean;

/**
 * @program: library
 * @description:
 * @author: qin
 * @create: 2019-11-24 19:26
 **/

public class Sex {
    private Integer sexid;
    private String sex;

    @Override
    public String toString() {
        return "Sex{" +
                "sexid=" + sexid +
                ", sex='" + sex + '\'' +
                '}';
    }

    public Integer getSexid() {
        return sexid;
    }

    public void setSexid(Integer sexid) {
        this.sexid = sexid;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
