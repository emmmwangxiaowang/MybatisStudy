package com.wang.dao;

import com.wang.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2021/8/16 0016
 */
public interface TeacherMapper
{
    @Select("select * from teacher where id =#{tid} ")
    Teacher getTeacher(@Param("tid")int id);
}
