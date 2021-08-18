package com.wang.dao;

import com.wang.pojo.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2021/8/18 0018
 */
public interface UserMapper
{
    List<User> queryUser(@Param("id")int id);

    //更新用户
    int updateUser(User user);
}
