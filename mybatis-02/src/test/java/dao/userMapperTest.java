package dao;

import com.wang.dao.userMapper;
import com.wang.pojo.User;
import com.wang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;

public class userMapperTest
{

    @Test
    public void test()
    {
        //1.获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一:2.执行sql
        userMapper  mapper   = sqlSession.  getMapper(userMapper.class);
        List <User> userList = mapper.getUserList();

        for (User user : userList)
        {
            System.out.println(user);
        }

        //关闭sqlSession
        sqlSession.close();
    }

}
