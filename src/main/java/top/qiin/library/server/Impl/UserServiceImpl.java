package top.qiin.library.server.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.qiin.library.bean.Sex;
import top.qiin.library.bean.Student;
import top.qiin.library.bookmapper.StuMapper;
import top.qiin.library.server.UserService;

import java.util.ArrayList;

/**
 * @program: library
 * @description:
 * @author: qin
 * @create: 2019-12-26 18:09
 **/
@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private StuMapper stuMapper;
    @Override
    public ArrayList<Student> getStu() {
        return stuMapper.getStu();
    }

    @Override
    public void deleteStu(Integer id) {
        stuMapper.deleteStu(id);
    }

    @Override
    public void updateStu(Student student) {
        stuMapper.updateStu(student);
    }

    @Override
    public Student getStuById(Integer id) {
        return stuMapper.getStuById(id);
    }

    @Override
    public void addStu(Student student) {
            stuMapper.addStu(student);
    }

    @Override
    public ArrayList<Sex> getSex() {
        return stuMapper.getSex();
    }

    @Override
    public ArrayList<Student> login(String username, String password) {
        return stuMapper.login(username,password);
    }
}
