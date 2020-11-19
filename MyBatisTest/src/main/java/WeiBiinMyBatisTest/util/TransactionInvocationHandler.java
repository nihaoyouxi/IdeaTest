package WeiBiinMyBatisTest.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author WeiBin
 * @Create 2020-11-18 11:17
 */
public class TransactionInvocationHandler implements InvocationHandler {

    private Object target;

    public TransactionInvocationHandler(){}

    public TransactionInvocationHandler(Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        SqlSession session=null;
        Object res=null;

        try{
            session=MyBatisUtil.getSqlSession();
            res=method.invoke(target,args);
            session.commit();
        }catch(Exception e){
            e.printStackTrace();
            session.rollback();
        }finally{
            MyBatisUtil.close(session);
        }

        return res;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

}
