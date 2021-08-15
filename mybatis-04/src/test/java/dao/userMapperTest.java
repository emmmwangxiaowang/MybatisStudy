package dao;

import com.wang.dao.userMapper;
import com.wang.pojo.User;
import com.wang.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class userMapperTest
{

    static Logger logger = Logger.getLogger(userMapper.class);


    @Test
    public void getUserById()
    {
        //1.获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一:2.执行sql
        userMapper  mapper   = sqlSession.  getMapper(userMapper.class);
        User user = mapper.getUserById(2);
        logger.debug("debug:进入了getUserById");
        System.out.println(user);

        sqlSession.commit();
        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void testLog4j(){
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testL0g4j");
    }

    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        userMapper           mapper = sqlSession.getMapper(userMapper.class);
        Map <String, Integer> map    = new HashMap <>();
        map.put("startIndex",1);
        map.put("pageSize",1);
        List <User> userByLimit = mapper.getUserByLimit(map);
        for (User user : userByLimit)
        {
            System.out.println(user);
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //RowBounds实现
        RowBounds rowBounds = new RowBounds(1, 2);

        //通过Java代码层面实现分页
        List <User> userList = sqlSession.selectList("com.wang.dao.userMapper.getUserByRowBounds",null,rowBounds);

        for (User user : userList)
        {
            System.out.println(user);
        }

        sqlSession.commit();
        sqlSession.close();
    }

}
