package com.wang.dao;

import com.wang.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2021/8/16 0016
 */
public interface TeacherMapper
{
    //获取指定老师下的所有学生及老师的信息
    Teacher getTeacherInfo(@Param("tid") int id);


    Teacher getTeacherInfo2(@Param("tid") int id);

   //获取老师
    List<Teacher> getTeacher();
}
