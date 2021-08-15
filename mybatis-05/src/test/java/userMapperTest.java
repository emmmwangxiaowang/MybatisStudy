import com.wang.dao.userMapper;
import com.wang.pojo.User;
import com.wang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2021/8/15 0015
 */
public class userMapperTest
{
    @Test
    public void Test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //底层主要用反射
        userMapper mapper     = sqlSession.getMapper(userMapper.class);
        List <User> users     = mapper.getUsers();
        for (User user : users)
        {
            System.out.println(user);
        }

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //底层主要用反射
        userMapper mapper     = sqlSession.getMapper(userMapper.class);
        User       user   = mapper.getUserById(2);
        System.out.println(user);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //底层主要用反射
        userMapper mapper     = sqlSession.getMapper(userMapper.class);
        mapper.addUser(new User(6,"jack","123"));

        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //底层主要用反射
        userMapper mapper     = sqlSession.getMapper(userMapper.class);
        mapper.updateUser(new User(5,"zeroQ","123"));

        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //底层主要用反射
        userMapper mapper     = sqlSession.getMapper(userMapper.class);
        mapper.deleteUser(6);

        sqlSession.close();
    }
}
