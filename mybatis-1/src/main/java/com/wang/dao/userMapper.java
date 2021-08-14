package com.wang.dao;

import com.wang.pojo.User;
import java.util.List;
import java.util.Map;

public interface userMapper
{

    //模糊查询
    List<User> getUserLike(String value);

    /*
    * 当实体类的属性或数据库中的表、字段过多时应考虑用map
    */
    //万能Map
    int addUser2(Map<String ,Object> map);

    //修改用户
    int updateUser(User user);

    //insert一个用户
    int addUser(User user);

    //获取全部用户
    List <User> getUserList();

    //根据id查询用户
    User getUserById(int id);

    User getUserById2(Map <String, Object> map);

    //删除用户
    int deleteUser(int id);
}
