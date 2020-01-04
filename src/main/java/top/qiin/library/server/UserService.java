package top.qiin.library.server;

import top.qiin.library.bean.Sex;
import top.qiin.library.bean.Student;

import java.util.ArrayList;

public interface UserService {
    ArrayList<Student> getStu();

    void deleteStu(Integer id);

    void updateStu(Student student);

    Student getStuById(Integer id);

    void addStu(Student student);

    ArrayList<Sex> getSex();

    ArrayList<Student> login(String username, String password);
}
