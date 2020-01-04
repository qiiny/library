package top.qiin.library.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.qiin.library.bean.*;
import top.qiin.library.bookmapper.BookMapper;
import top.qiin.library.bookmapper.StuMapper;
import top.qiin.library.server.BookServer;
import top.qiin.library.server.UserService;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: library
 * @description:
 * @author: qin
 * @create: 2019-11-24 19:08
 **/
@Controller

public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookServer bookServer;

    @RequestMapping("/userBook")
    public String userBook(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<Book> list = bookServer.getBook();
        PageInfo<Book> pageInfo = new PageInfo<Book>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "user/userBook";
    }
    @RequestMapping("borrowBook")
    public String borrowBook(HttpSession session,Integer id,String bname){
        System.out.println(id+bname);
        Student user = (Student) session.getAttribute("user");
        bookServer.jieshu(bname,user.getSname(),new Date(),id);
        return "redirect:/userBook";
    }
    @RequestMapping("/jie")
    public String toJie(Model model,HttpSession session,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        Student user = (Student) session.getAttribute("user");
        PageHelper.startPage(pageNum,10);
        ArrayList<Borrow>list=bookServer.getBorrowBySid(user.getSname());
        PageInfo<Borrow> pageInfo = new PageInfo<Borrow>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "user/borrow";
    }
    @RequestMapping("/bookReturning")
    public String bookReturning(Integer id,Integer bid,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        bookServer.bookReturning(id,bid);
        return "redirect:/jie";
    }
}
