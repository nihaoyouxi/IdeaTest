package WeiBiinMyBatisTest;

import WeiBiinMyBatisTest.bean.Student;
import WeiBiinMyBatisTest.dao.StudentDao;
import WeiBiinMyBatisTest.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author WeiBin
 * @Create 2020-11-14 10:05
 */
public class TestBatis {
    @Test
    public void testInsertStudent() throws IOException {
        SqlSession sqlSession= MyBatisUtil.getSqlSession();
        String sqlId="WeiBiinMyBatisTest.dao.StudentDao"+"."+"insertStudent";
        int res=sqlSession.insert(sqlId,new Student(3,"香风智乃"));
        System.out.println(res);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void TestThrendsProxyGetStudents(){
        SqlSession session =MyBatisUtil.getSqlSession();
        StudentDao dao=session.getMapper(StudentDao.class);
        List<Student> list=dao.selectStudentes();
        list.forEach(stu->{
            System.out.println(stu);
        });
    }

    @Test
    public void TestThrendsProxyGetStudentById(){
        SqlSession session =MyBatisUtil.getSqlSession();
        StudentDao dao=session.getMapper(StudentDao.class);
        Student stu=dao.selectStudentById(12);
        System.out.println(stu);
    }

    @Test
    public void testGetSrudentBySidAndCid(){
        SqlSession session=MyBatisUtil.getSqlSession();
        StudentDao dao=session.getMapper(StudentDao.class);
        List<Student> list= dao.selectStudentByStuIdAndClaId(12,2);
        list.forEach(stu->{
            System.out.println(stu);
        });
    }

    @Test
    public void testSelect(){
        SqlSession session=MyBatisUtil.getSqlSession();
        StudentDao dao=session.getMapper(StudentDao.class);
        List<Student> list= dao.testSelect("乃");
        list.forEach(stu->{
            System.out.println(stu);
        });
    }

}
