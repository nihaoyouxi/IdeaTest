package WeiBiinMyBatisTest.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author WeiBin
 * @Create 2020-11-14 11:11
 */
public class MyBatisUtil {

    private static SqlSessionFactory factory=null;
    private static ThreadLocal<SqlSession> t=new ThreadLocal<SqlSession>();

    static{
        String config="mybatis.xml";
        try {
            InputStream in= Resources.getResourceAsStream(config);
            factory=new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private MyBatisUtil(){}

    public static SqlSession getSqlSession(){
        SqlSession session=t.get();
        if(session==null){
            session=factory.openSession();
            t.set(session);
        }
        return session;
    }

    public static void close(SqlSession session){
        if(session!=null){
            session.close();
            t.remove();
        }
    }

}
