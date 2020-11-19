package WeiBiinMyBatisTest.util;

/**
 * @author WeiBin
 * @Create 2020-11-18 11:47
 */
public class ServiceFactory {

    public static Object getService(Object service){
        return new TransactionInvocationHandler(service).getProxy();
    }

}
