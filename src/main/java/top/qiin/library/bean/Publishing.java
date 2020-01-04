package top.qiin.library.bean;

import java.io.Serializable;

/**
 * @program: library
 * @description: 出版社
 * @author: qin
 * @create: 2019-11-04 17:19
 **/

public class Publishing {
    private int publishing;
    private String Publishingname;

    public int getPublishing() {
        return publishing;
    }

    public void setPublishing(int publishing) {
        this.publishing = publishing;
    }

    @Override
    public String toString() {
        return "Publishing{" +
                "publishing='" + publishing + '\'' +
                ", Publishingname='" + Publishingname + '\'' +
                '}';
    }

    public String getPublishingname() {
        return Publishingname;
    }

    public void setPublishingname(String publishingname) {
        Publishingname = publishingname;
    }
}
