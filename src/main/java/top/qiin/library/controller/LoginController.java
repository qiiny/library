package top.qiin.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.qiin.library.bean.Book;
import top.qiin.library.bean.Student;
import top.qiin.library.bookmapper.StuMapper;
import top.qiin.library.server.BookServer;
import top.qiin.library.server.UserService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: library
 * @description:
 * @author: qin
 * @create: 2019-12-24 17:16
 **/
@Controller
public class LoginController {
    @Autowired
    private UserService service;
    @Autowired
    private BookServer bookServer;
    @RequestMapping("/")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("login")
    public String login(String username, String password, HttpSession session, Model model){
        System.out.println(username+password);
        ArrayList<Student> login = service.login(username, password);
        System.out.println(login);
        if (login==null||login.size()<1){
            model.addAttribute("error","账号或密码错误");
            return "redirect:/";
        }else {
            session.setAttribute("user",login.get(0));
            return "redirect:/book";
        }
    }
    @RequestMapping("/userLogin")
    public String userLogin(String username, String password, HttpSession session, Model model){
        System.out.println(username+password);
        ArrayList<Student> login = service.login(username, password);
        System.out.println(login);
        if (login==null||login.size()<1){
            model.addAttribute("error","账号或密码错误");
            return "redirect:/toUser";
        }else {
            session.setAttribute("user",login.get(0));
            return "redirect:/userBook";
        }
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
    @RequestMapping("/toUser")
    public String toUser(){
        System.out.println("**************************");
        return "userLogin";
    }

}
