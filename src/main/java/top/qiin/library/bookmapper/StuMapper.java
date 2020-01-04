package top.qiin.library.bookmapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
import top.qiin.library.bean.Sex;
import top.qiin.library.bean.Student;

import java.util.ArrayList;

/**
 * @program: library
 * @description:
 * @author: qin
 * @create: 2019-11-24 20:18
 **/
@Mapper
@Service
public interface StuMapper {
    ArrayList<Student> getStu();
    @Insert("INSERT INTO `book`.`student` (`sid`, `sname`, `sexid`, `stime`, `password`) VALUES (#{sid},#{sname},#{sexid},#{stime},#{password})")
    void addStu(Student student);

    Student getStuById(Integer id);

    @Update("update student set sid=#{sid},sname=#{sname},sexid=#{sexid},stime=#{stime},password=#{password} where id=#{id}")
    void updateStu(Student student);

    @Delete("delete from student where id= #{id}")
    void deleteStu(Integer id);

    @Select("select * from student where sname = #{sname} and password = #{password}")
    ArrayList<Student> login(@Param("sname") String username,@Param("password") String password);
    @Select("select * from sex")
    ArrayList<Sex> getSex();

}
