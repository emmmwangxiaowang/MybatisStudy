import com.wang.dao.TeacherMapper;
import com.wang.pojo.Teacher;
import com.wang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2021/8/16 0016
 */
public class MyTest
{
    public static void main(String[] args)
    {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper    mapper     = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);

        sqlSession.close();

    }
}
