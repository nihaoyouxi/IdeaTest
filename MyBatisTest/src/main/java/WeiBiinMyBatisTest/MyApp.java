package WeiBiinMyBatisTest;

import WeiBiinMyBatisTest.bean.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author WeiBin
 * @Create 2020-11-13 21:03
 */
public class MyApp {

    public static void main(String[] args) throws IOException {
        String config="mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        SqlSession sqlSession=factory.openSession();
        //String sqlId="WeiBiinMyBatisTest.dao.StudentDao"+"."+"selectStudentes";
        String sqlId="a.b";
        List<Student> studentes=sqlSession.selectList(sqlId);
        System.out.println(studentes);
        studentes.forEach(stu->{
            System.out.println(stu.getClassId()+"班 "+stu.getName());
        });
        sqlSession.close();
    }

}
