package com.wang.utils;

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2021/8/14 0014
 */
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

//sqlSessionFactory --->sqlSession
public class MybatisUtils
{
    private static SqlSessionFactory sqlSessionFactory;

    static
    {

        try
        {
            //使用mybatis第一步： 获取sqlSessionFactory对象
            String      resource    = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    //既然有了SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。org.apache.ibatis.session.SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。
    // 你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。例如：
    public static SqlSession getSqlSession()
    {

        return sqlSessionFactory.openSession(true);
    }

}

