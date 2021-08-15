package com.wang.dao;

import com.wang.pojo.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface userMapper
{



    //分页
    List<User> getUserByLimit(Map<String,Integer> map);

    //根据id查询用户
    User getUserById(@Param("qid") int id);

}
