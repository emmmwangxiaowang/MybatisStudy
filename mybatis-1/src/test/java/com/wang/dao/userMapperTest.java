package com.wang.dao;

import com.wang.pojo.User;
import com.wang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class userMapperTest
{

    @Test
    public void test()
    {
        //1.获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一:2.执行sql
        userMapper  mapper   = sqlSession.getMapper(userMapper.class);
        List <User> userList = mapper.getUserList();

        for (User user : userList)
        {
            System.out.println(user);
        }

        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void getUserId(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        userMapper mapper = sqlSession.getMapper(userMapper.class);
        User       user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        userMapper mapper = sqlSession.getMapper(userMapper.class);
        int        count    = mapper.addUser(new User(4, "李墁墁", "123"));
        System.out.println(count);

        //提交事务----增删改必须提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        userMapper mapper = sqlSession.getMapper(userMapper.class);
        mapper.updateUser(new User(4,"陈昌霖","123"));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        userMapper mapper     = sqlSession.getMapper(userMapper.class);
        mapper.deleteUser(4);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        userMapper           mapper = sqlSession.getMapper(userMapper.class);
        Map <String, Object> map    = new HashMap <String, Object>();
        map.put("userid",5);
        map.put("userName","zeroQ");
        map.put("userPwd","123");
        mapper.addUser2(map);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getUserById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        userMapper mapper     = sqlSession.getMapper(userMapper.class);
        Map <String, Object> map = new HashMap <>();
        map.put("id",2);
        map.put("name","蒋莹莹");

        User userById2 = mapper.getUserById2(map);
        System.out.println(userById2);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        userMapper mapper     = sqlSession.getMapper(userMapper.class);
        List <User> list = mapper.getUserLike("%李%");
        for (User user : list)
        {
            System.out.println(user);
        }

        sqlSession.commit();
        sqlSession.close();
    }
}
