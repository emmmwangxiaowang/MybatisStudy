package dao;

import com.wang.dao.userMapper;
import com.wang.pojo.User;
import com.wang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

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

}
