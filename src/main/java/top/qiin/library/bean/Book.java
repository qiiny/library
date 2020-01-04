package top.qiin.library.bean;

import lombok.Data;
import lombok.Getter;

/**
 * @program: library
 * @description: 书本信息类
 * @author: qin
 * @create: 2019-11-04 16:33
 **/

public class Book {
    private Integer id;
    private String name;
    private String isbn;
    private String author;
    private Publishing publishingName;
    private Integer publishing;
    private BookType booktype;
    private Integer type;
    private Integer money;
    private Integer sum;
    private String intro;
    private String images;
    private Integer jie;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", publishingName=" + publishingName +
                ", publishing=" + publishing +
                ", booktype=" + booktype +
                ", type=" + type +
                ", money=" + money +
                ", sum=" + sum +
                ", intro='" + intro + '\'' +
                ", images='" + images + '\'' +
                ", jie=" + jie +
                '}';
    }

    public Integer getPublishing() {
        return publishing;
    }

    public void setPublishing(Integer publishing) {
        this.publishing = publishing;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BookType getBooktype() {
        return booktype;
    }

    public void setBooktype(BookType booktype) {
        this.booktype = booktype;
    }
    public Integer getJie() {
        return jie;
    }

    public void setJie(Integer jie) {
        this.jie = jie;
    }

    public Publishing getPublishingName() {
        return publishingName;
    }

    public void setPublishingName(Publishing publishing) {
        this.publishingName = publishing;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
