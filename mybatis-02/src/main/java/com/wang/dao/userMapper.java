package com.wang.dao;

import com.wang.pojo.User;
import java.util.List;

public interface userMapper
{


    //修改用户
    int updateUser(User user);

    //insert一个用户
    int addUser(User user);

    //获取全部用户
    List <User> getUserList();

    //根据id查询用户
    User getUserById(int id);


    //删除用户
    int deleteUser(int id);
}
