package com.wang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2021/8/18 0018
 */

@Data
@AllArgsConstructor
public class User
{
    private int id;
    private String name;
    private String pwd;
}
