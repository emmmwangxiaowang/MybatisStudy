package com.wang.dao;

import com.wang.pojo.Student;
import java.util.List;

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2021/8/16 0016
 */
public interface StudentMapper
{
    //查询所有的学生的信息,以及对应的老师的信息
    public List<Student> getStudent();

    public List <Student> getStudent2();



}
