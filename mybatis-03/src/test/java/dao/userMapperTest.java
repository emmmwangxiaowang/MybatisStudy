package dao;

import com.wang.dao.userMapper;
import com.wang.pojo.User;
import com.wang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class userMapperTest
{

    @Test
    public void test()
    {
        //1.获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一:2.执行sql
        userMapper  mapper   = sqlSession.  getMapper(userMapper.class);
        User user = mapper.getUserById(2);

        System.out.println(user);

        sqlSession.commit();
        //关闭sqlSession
        sqlSession.close();
    }

}
