package com.wang.dao;

import com.wang.pojo.User;
import java.util.List;
import java.util.Map;

public interface userMapper
{



    //分页
    List<User> getUserByLimit(Map<String,Integer> map);

    //根据id查询用户
    User getUserById(int id);

}
