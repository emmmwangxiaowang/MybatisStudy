import com.wang.dao.TeacherMapper;
import com.wang.pojo.Teacher;
import com.wang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2021/8/17 0017
 */
public class myTest
{
    @Test
    public void getTeacher(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper  = sqlSession.getMapper(TeacherMapper.class);
        List <Teacher> teacher = mapper.getTeacher();

        for (Teacher teacher1 : teacher)
        {
            System.out.println(teacher1);
        }

        sqlSession.close();
    }

    @Test
    public void getTeacherInfo(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper  = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacherInfo   = mapper.getTeacherInfo(1);
        System.out.println(teacherInfo);

        sqlSession.close();
    }

    @Test
    public void getTeacherInfo2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper  = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacherInfo2  = mapper.getTeacherInfo2(1);
        System.out.println(teacherInfo2);
        sqlSession.close();
    }
}
