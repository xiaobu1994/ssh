package com.example.cxfClient;

import com.example.entity.Book;
import com.example.server.interceptor.ClientLoginInterceptor;
import com.example.base.util.EntityUtils;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author xiaobu
 * @version JDK1.8.0_171
 * @date on  2018/11/23 10:45
 * @description V1.0 webservice客户端调用
 */
public class TestDemo {
    private static final String WSDL_URL = "http://localhost:8877/services/demoService?wsdl";
    private static final String USER_NAME = "admin";
    private static final String PASS_WORD = "1";
    private static JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
    private static Client client = dcf.createClient(WSDL_URL);

    public static void main(String[] args) {
        method1();
    }

    /**
     * @author xiaobu
     * @date 2018/11/23 14:29
     * @return void
     * @descprition  //动态调用
     * @version 1.0
     */
    @SuppressWarnings("all")
    private static void method1() {
        // 需要密码的情况需要加上用户名和密码
         client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,PASS_WORD));
        Object[] objects = new Object[0];
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("getBookById", 1);
            List list = Arrays.asList(objects);
            //这里的Book对象
            List<Book> books = EntityUtils.copyList(list,Book.class,new String[]{});
            System.out.println("books=======>>"+books);
            Book book = EntityUtils.convertBean(objects[0], Book.class);
            System.out.println("book======>>"+book);
            Book book2 = EntityUtils.copy(objects[0], Book.class, new String[]{});
            System.out.println("book2======>>"+book2);
            Map map = EntityUtils.objectToMap(book);
            System.out.println("Map:" + map);
            Book book1 = EntityUtils.mapToObject(map,Book.class);
            System.out.println("book1======>>"+book1);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

}
