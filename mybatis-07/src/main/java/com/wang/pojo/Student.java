package com.wang.pojo;

import lombok.Data;

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2021/8/16 0016
 */

@Data
public class Student
{
    private int id;
    private String name;
    //学生要关联一个老师！
    private int tid;


}
