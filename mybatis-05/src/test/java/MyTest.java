import com.wang.dao.StudentMapper;
import com.wang.dao.TeacherMapper;
import com.wang.pojo.Student;
import com.wang.pojo.Teacher;
import com.wang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;

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

    @Test
    public void getStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper  = sqlSession.getMapper(StudentMapper.class);
        List <Student> student = mapper.getStudent();

        for (Student student1 : student)
        {
            System.out.println(student1);
        }

        sqlSession.close();
    }

    @Test
    public void getStudent2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper  = sqlSession.getMapper(StudentMapper.class);
        List <Student> student = mapper.getStudent2();

        for (Student student1 : student)
        {
            System.out.println(student1);
        }

        sqlSession.close();
    }
}
