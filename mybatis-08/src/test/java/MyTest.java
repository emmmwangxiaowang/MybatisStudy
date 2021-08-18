import com.wang.dao.BlogMapper;
import com.wang.pojo.Blog;
import com.wang.utils.IDutils;
import com.wang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.*;

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2021/8/17 0017
 */
public class MyTest
{
    @Test
    public void addBlogTest()
    {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper     = sqlSession.getMapper(BlogMapper.class);
        Blog       blog       = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("Mybatis");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Java");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Spring");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("微服务");
        mapper.addBlog(blog);

        sqlSession.close();
    }

    @Test
    public void queryBlogIf(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper           mapper = sqlSession.getMapper(BlogMapper.class);
        Map <String, Object> map    = new HashMap <>();
        //map.put("title","mybatis");
        map.put("author","狂神说");
        //map.put("views",9999);
        List <Blog> blogs = mapper.queryBlogIf(map);
        for (Blog blog : blogs)
        {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper           mapper = sqlSession.getMapper(BlogMapper.class);
        Map <String, Object> map    = new HashMap <>();
        map.put("title","Mybatis");
        //map.put("author","狂神说2");
        //map.put("views",4399);
        map.put("id","46a69e26e9f84164ac09b0dcd86c6762");
        mapper.updateBlog(map);

        sqlSession.close();
    }

    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper           mapper = sqlSession.getMapper(BlogMapper.class);
        Map <String, Object> map    = new HashMap <>();
        ArrayList <Integer> ids = new ArrayList <>();
        ids.add(1);
        ids.add(2);

        /*map键值对   如果有多个对象就用m*/
        map.put("ids",ids);
        List <Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs)
        {
            System.out.println(blog);
        }

        sqlSession.close();
    }
}
