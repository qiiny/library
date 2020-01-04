package top.qiin.library.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.qiin.library.bean.*;
import top.qiin.library.server.AdminService;
import top.qiin.library.server.BookServer;
import top.qiin.library.server.UserService;
import top.qiin.library.util.OnlyAdmin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: library
 * @description:
 * @author: qin
 * @create: 2019-12-23 22:31
 **/
@Controller

public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private BookServer bookServer;
    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * 添加书本页面
     * @return
     */
    @RequestMapping("/addBookPage")
    public String addBookPage(){
        return "admin/addBook";
    }

    /**
     * 获取图书类型
     * @return 图书类型
     */
    @OnlyAdmin
    @RequestMapping("/findAllBookType")
    @ResponseBody
    public List<BookType> findAllBookCategory(){
        List<BookType> BookType = bookServer.getBookType();
        return BookType;
    }
    /**
     * 获取出版社
     * @return 出版社
     */
    @OnlyAdmin
    @RequestMapping("/findAllBookPublishing")
    @ResponseBody
    public List<Publishing> findAllBookPublishing(){
        List<Publishing> bookPublishing = adminService.getBookPublishing();
        return bookPublishing;
    }

    @OnlyAdmin
    @RequestMapping("/book")
    public String getAllPerson(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){

        PageHelper.startPage(pageNum,10);
        List<Book> list = bookServer.getBook();
        PageInfo<Book> pageInfo = new PageInfo<Book>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/index";
    }
    @OnlyAdmin
    @RequestMapping("/stu")
    public String stu(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,10);
        ArrayList<Student> stu = userService.getStu();
        PageInfo<Student> pageInfo = new PageInfo<Student>(stu);
        model.addAttribute("stu",pageInfo);
        return "admin/stu";
    }
    @OnlyAdmin
    @RequestMapping("toAdd")
    public String toAdd(Model model){
        ArrayList<Sex> sex=userService.getSex();
        model.addAttribute("sex",sex);
        return "admin/AddStu";
    }
    @OnlyAdmin
    @RequestMapping("/add")
    public String addStu(Student student){
        userService.addStu(student);
        return "redirect:/stu";
    }

    @OnlyAdmin
    @RequestMapping("/toAddBook")
    public String toAddBook(Model model){
        ArrayList<Publishing> publishing = bookServer.getPublishing();
        ArrayList<BookType> bookType = bookServer.getBookType();
        model.addAttribute("publishing",publishing);
        model.addAttribute("BookType",bookType);
        return "admin/AddBook";
    }
    @OnlyAdmin
    @RequestMapping("/addBook")
    public String addBook(Book book){
        System.out.println(book);
        bookServer.addBook(book);
        return "redirect:/book";
    }
    @OnlyAdmin
    @RequestMapping("/getBookById")
    public String getBookById(Integer id,Model model){
        Book bookById = bookServer.getBookById(id);
        ArrayList<Publishing> publishing = bookServer.getPublishing();
        ArrayList<BookType> bookType = bookServer.getBookType();
        model.addAttribute("publishing",publishing);
        model.addAttribute("BookType",bookType);
        model.addAttribute("bookById",bookById);
        return "admin/updateBook";
    }
    @OnlyAdmin
    @RequestMapping("/updateBook")
    public String updateBook(Book book){
        System.out.println(book);
        bookServer.updateBook(book);
        return "redirect:/book";
    }
    @OnlyAdmin
    @RequestMapping("/getStuById")
    public String gertStuByDd(Integer id,Model model){
        Student stuById = userService.getStuById(id);
        ArrayList<Sex> sex = userService.getSex();
        model.addAttribute("sex",sex);
        System.out.println("ssss"+stuById);
        model.addAttribute("stu",stuById);
        return "admin/updateStu";
    }
    @OnlyAdmin
    @RequestMapping("/updateStu")
    public String updateStu(Student student){
        System.out.println(student);
        userService.updateStu(student);
        return "redirect:/stu";
    }
    @OnlyAdmin
    @RequestMapping("/deleteBook")
    public String deleteBook(Integer id){
        bookServer.daleteBook(id);
        return "redirect:/";
    }
    @OnlyAdmin
    @RequestMapping("/deleteStu")
    public String deleteStu(Integer id){
        userService.deleteStu(id);
        return "redirect:/stu";
    }
    @OnlyAdmin
    @RequestMapping("/type")
    public String getType(Model model){
        ArrayList<BookType> bookCategorys = (ArrayList<BookType>) adminService.getBookCategorys();
        System.out.println("46454"+bookCategorys);
        model.addAttribute("type",bookCategorys);
        return "admin/booktype";
    }
    @OnlyAdmin
    @RequestMapping("/addtype")
    public String addType(String typename){
        adminService.addType(typename);
        return "redirect:/type";
    }
    @OnlyAdmin
    @RequestMapping("/publishing")
    public String getPublishing(Model model){
        ArrayList<Publishing>list=bookServer.getPublishing();
        model.addAttribute("publishing",list);
        return "admin/publishing";
    }
    @OnlyAdmin
    @RequestMapping("/addPublishing")
    public String addPublishing(String publishingname){
        bookServer.addPublishing(publishingname);
        return "redirect:/publishing";
    }
    @OnlyAdmin
    @RequestMapping("/borrow")
    public String toBorrow(Model model){
        ArrayList<Borrow>borrow=bookServer.getBorrow();
        model.addAttribute("borrow",borrow);
        return "admin/jie";
    }
    @OnlyAdmin
    @RequestMapping("/sousuo")
    public String sousuo(Integer type,Integer publishing,String name,
                         @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum,
                         Model model){
        PageHelper.startPage(pageNum,10);
        List<Book>list=bookServer.souSuo(type,publishing,name);
        PageInfo<Book> pageInfo = new PageInfo<Book>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/index";
    }
}
