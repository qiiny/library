package top.qiin.library.bookmapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
import top.qiin.library.bean.Book;
import top.qiin.library.bean.BookType;
import top.qiin.library.bean.Borrow;
import top.qiin.library.bean.Publishing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: library
 * @description: 获取 书本信息
 * @author: qin
 * @create: 2019-11-04 16:32
 **/
@Mapper
@Service
public interface BookMapper {
    /**
     * 查询所有书籍
     * @return
     */
    ArrayList<Book> getBook();

    /**
     * 查询所有出版社
     * @return
     */
    @Select("select * from publishing")
    ArrayList<Publishing> getPublishing();

    /**
     * 查询所有书本类型
     * @return
     */
    @Select("select * from book_type")
    ArrayList<BookType> getBookType();

    /**
     * 添加书本
     * @param book
     * @return
     */
    @Insert("INSERT INTO `book`.`book` (`name`, `isbn`, `author`, `publishing`, `type`, `money`, `sum`, `intro`) VALUES (#{name}, #{isbn},#{author},#{publishing},#{type},#{money},#{sum},#{intro})")
    int addBook(Book book);

    /**
     * 根据id获取书本
     * @param id
     * @return
     */
    Book getBookById(Integer id);

    /**
     * 更新书本
     * @param book
     */
    @Update("UPDATE `book`.`book` t SET t.`name` = #{name}, t.`isbn` = #{isbn}, t.`author` = #{author}, t.`publishing` = #{publishing}, t.`type` = #{type}, t.`money` = #{money}, t.`sum` = #{sum}, t.`intro` = #{intro} WHERE t.`id` = #{id}")
    void updateBook(Book book);

    /**
     * 根据id删除书本
     * @param id
     */
    @Delete("delete from book where id = #{id}")
    void daleteBook(Integer id);

    /**
     * 添加借书信息
     * @param bname
     * @param bid
     * @param sname
     * @param jtime
     */
    @Insert("insert into borrow(bname,bid,sname,jtime) values (#{bname},#{bid},#{sname},#{jtime})")
    void jie(@Param("bname") String bname, @Param("bid") Integer bid,@Param("sname") String sname, @Param("jtime")Date jtime);

    /**
     * 书本表借书数加一
     * @param id
     */
    @Update("update book set jie=jie+1 where id  = #{id}")
    void jiebook(@Param("id") Integer id);

    /**
     * 添加书本类型
     * @param typename
     */
    @Insert("INSERT INTO `book`.`book_type` (`type`, `typename`) VALUES (NULL, #{typename})")
    void addType(@Param("typename") String typename);

    /**
     * 添加出版社
     * @param publishingname
     */
    @Insert("insert into publishing(publishing,publishingname) values (null,#{publishing})")
    void addPublishing(@Param("publishingname") String publishingname);

    /**
     * 查询借书表
     * @return
     */
    @Select("select * from borrow")
    ArrayList<Borrow> getBorrow();

    /**
     * 联合搜索查询
     * @param type
     * @param publishing
     * @param name
     * @return
     */
    List<Book> souSuo(@Param("type") Integer type, @Param("publishing") Integer publishing, @Param("name") String name);

    /**
     * 查询个人借书表
     * @param sname
     * @return
     */
    @Select("select * from borrow where sname=#{sname}")
    ArrayList<Borrow> getBorrowBySid(String sname);

    /**
     * 还书后借出-1
     * @param bid
     */
    @Update("update book set jie=jie-1 where id=#{bid}")
    void updateBookJie(@Param("bid") Integer bid);
    @Update("update borrow set gtime=#{gtime},huan=1 where id=#{id}")
    void bookRetuning(@Param("id") Integer id, @Param("gtime") Date date);
}
