package top.qiin.library.server;

import top.qiin.library.bean.BookType;
import top.qiin.library.bean.Publishing;

import java.util.List;

public interface AdminService {

    List<BookType> getBookCategorys();

    List<Publishing> getBookPublishing();


    void addType(String bookType);
}
