import com.wang.dao.UserMapper;
import com.wang.pojo.User;
import com.wang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2021/8/18 0018
 */

//缓存测试
public class MyTest
{
    //一级缓存默认开启,只在一次sqlSession中有效,也就是拿到连接到关闭连接这个区间段
    @Test
    public void testCache1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper     = sqlSession.getMapper(UserMapper.class);
        List <User> users     = mapper.queryUser(1);
        System.out.println(users);

        List <User> users1 = mapper.queryUser(2);
        System.out.println(users1);

        List <User> users2     = mapper.queryUser(1);
        System.out.println(users2);

        System.out.println("===============");

        List <User> users3 = mapper.queryUser(3);
        List <User> users4 = mapper.queryUser(2);
        System.out.println(users3);

        //结果为true: 在一个sqlSession内查询的记录都会保存,内存不够时按lru fifo更新缓存
        System.out.println(users==users2);
        System.out.println(users1==users4);
        //System.out.println(users1==users3);
        sqlSession.close();
    }

    //默认一级缓存,sqlsesion内
    @Test
    public void testCache2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper     = sqlSession.getMapper(UserMapper.class);
        List <User> users     = mapper.queryUser(1);
        System.out.println(users);

        //增删改操作会改变原有的数据,所以会更新缓存
        mapper.updateUser(new User(2,"aaa","bbb"));

        System.out.println("===============");

        List <User> users1 = mapper.queryUser(1);
        System.out.println(users1);
        //结果为false,更新数据,缓存就更新了
        System.out.println(users==users1);
        sqlSession.close();
    }

    //默认一级缓存,sqlsesion内
    @Test
    public void testCache3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper     = sqlSession.getMapper(UserMapper.class);
        List <User> users     = mapper.queryUser(1);
        System.out.println(users);

        //手动清理缓存
        sqlSession.clearCache();

        System.out.println("===============");

        List <User> users1 = mapper.queryUser(1);
        System.out.println(users1);
        //结果为false,更新数据,缓存就更新了
        System.out.println(users==users1);
        sqlSession.close();
    }
}
