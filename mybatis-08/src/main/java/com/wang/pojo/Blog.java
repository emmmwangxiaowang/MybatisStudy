package com.wang.pojo;

import lombok.Data;
import java.util.Date;

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2021/8/17 0017
 */

@Data
public class Blog
{
    private String id;
    private String title;
    private String author;
    private Date createTime;
    private int views;

}
