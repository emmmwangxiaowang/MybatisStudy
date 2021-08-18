package com.wang.dao;

import com.wang.pojo.Blog;
import java.util.List;
import java.util.Map;

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2021/8/17 0017
 */
public interface BlogMapper
{

    //查询forEach
    List<Blog> queryBlogForeach(Map map);

    //更新博客
    int updateBlog(Map map);

    //插入数据
    int addBlog(Blog blog);

    //查询博客
    List<Blog> queryBlogIf(Map map);

    List<Blog> queryBlogChoose(Map map);

}
