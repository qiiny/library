package top.qiin.library.server.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import top.qiin.library.bean.Book;
import top.qiin.library.bean.BookType;
import top.qiin.library.bean.Borrow;
import top.qiin.library.bean.Publishing;
import top.qiin.library.bookmapper.BookMapper;
import top.qiin.library.server.BookServer;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: library
 * @description:
 * @author: qin
 * @create: 2019-12-18 22:29
 **/
@Service
public class BookServerImpl implements BookServer {
    @Autowired
    private BookMapper bookMapper;

    /**
     * 借书
     * @param bname
     * @param sname
     * @param jtime
     * @param bid
     */
    @Override
    public void jieshu(String bname, String sname, Date jtime,Integer bid) {
        bookMapper.jie(bname,bid,sname,jtime);
        bookMapper.jiebook(bid);
    }

    /**
     * 添加图书
     * @param book
     * @return
     */
    @Override
    public boolean addBook(Book book) {
        int n=bookMapper.addBook(book);
        return n > 0;
    }

    @Override
    public List<Book> getBook() {
        return bookMapper.getBook();
    }
    @Override
    public ArrayList<Publishing> getPublishing() {
        return bookMapper.getPublishing();
    }

    @Override
    public ArrayList<BookType> getBookType() {
        return bookMapper.getBookType();
    }

    @Override
    public Book getBookById(Integer id) {
        return bookMapper.getBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }

    @Override
    public void daleteBook(Integer id) {
        bookMapper.daleteBook(id);
    }

    @Override
    public void addPublishing(String publishingname) {
        bookMapper.addPublishing(publishingname);
    }

    @Override
    public ArrayList<Borrow> getBorrow() {
        return bookMapper.getBorrow();
    }

    @Override
    public List<Book> getAllBook() {
        return null;
    }

    @Override
    public Page<Book> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        return null;
    }


    @Override
    public List<Book> souSuo(Integer type, Integer publishing, String name) {
        List<Book>list=bookMapper.souSuo(type,publishing,name);
        return list;
    }

    @Override
    public ArrayList<Borrow> getBorrowBySid(String sname) {
        return bookMapper.getBorrowBySid(sname);
    }

    @Override
    public void bookReturning(Integer id, Integer bid) {
        bookMapper.bookRetuning(id,new Date());
        bookMapper.updateBookJie(bid);

    }


}
