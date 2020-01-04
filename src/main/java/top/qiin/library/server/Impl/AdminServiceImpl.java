package top.qiin.library.server.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.qiin.library.bean.BookType;
import top.qiin.library.bean.Publishing;
import top.qiin.library.bookmapper.BookMapper;
import top.qiin.library.server.AdminService;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: library
 * @description:
 * @author: qin
 * @create: 2019-12-23 22:41
 **/
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private BookMapper bookMapper;

    /**
     * 获取图书类型
     * @return
     */
    @Override
    public List<BookType> getBookCategorys() {
        ArrayList<BookType> bookType = bookMapper.getBookType();
        return bookType;
    }

    /**
     * 获取出版社
     * @return
     */
    @Override
    public List<Publishing> getBookPublishing() {
        List<Publishing> publishing = bookMapper.getPublishing();
        return publishing;
    }

    /**
     * 添加图书
     * @param bookType
     */
    @Override
    public void addType(String bookType) {
        bookMapper.addType(bookType);
    }
}
