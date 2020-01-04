package top.qiin.library.server;

import com.github.pagehelper.Page;

import org.springframework.stereotype.Service;
import top.qiin.library.bean.Book;
import top.qiin.library.bean.BookType;
import top.qiin.library.bean.Borrow;
import top.qiin.library.bean.Publishing;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public interface BookServer {
    void jieshu(String bname,String sname,Date date,Integer bid);
    boolean addBook(Book book);
    List<Book> getBook();

    ArrayList<Publishing> getPublishing();

    ArrayList<BookType> getBookType();

    Book getBookById(Integer id);

    void updateBook(Book book);

    void daleteBook(Integer id);

    void addPublishing(String publishingname);

    ArrayList<Borrow> getBorrow();

    List<Book> getAllBook();

    Page<Book> findByPage(int pageNo, int pageSize);



    List<Book> souSuo(Integer type, Integer publishing, String name);

    ArrayList<Borrow> getBorrowBySid(String sname);

    void bookReturning(Integer id, Integer bid);
}

