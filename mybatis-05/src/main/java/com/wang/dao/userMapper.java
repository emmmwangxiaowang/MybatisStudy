package com.wang.dao;

import com.wang.pojo.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface userMapper
{
    @Select("select * from user where id=#{id} ")
    //有多个参数的时候在参数前加@Param()
    User getUserById(@Param("id") int id);

    @Select("select * from user ")
    List<User> getUsers();

    @Insert("insert into user(id,name,pwd) values(#{id} ,#{name} ,#{password} )")
    int addUser(User user);

    @Update("update user set name=#{name} ,pwd=#{password} where id=#{id}")
    int updateUser(User user);

    @Delete("delete from user where id =#{uid}")
    //基本类型的参数一般都要加上@Param注解,sql中引用的参数要与Param中的名字一致
    int deleteUser(@Param("uid") int id);
}
