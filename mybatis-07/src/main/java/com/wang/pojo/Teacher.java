package com.wang.pojo;

import lombok.Data;
import java.util.List;

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2021/8/16 0016
 */

@Data
public class Teacher
{
    private int            id;
    private String         name;
    //一个老师拥有多个学生
    private List <Student> students;
}
