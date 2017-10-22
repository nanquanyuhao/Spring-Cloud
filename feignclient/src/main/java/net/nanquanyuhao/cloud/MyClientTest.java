package net.nanquanyuhao.cloud;

import feign.Feign;

/**
 * Created by nanquanyuhao on 2017/10/22.
 */
public class MyClientTest {

    public static void main(String[] args){

        // client() 方法配置自定义的客户端实现类型，默认使用HttpUrlConnection
        HelloClient client = Feign.builder().client(new MyClient()).target(HelloClient.class,
                "http://localhost:8080");
        String result = client.hello();
        System.out.println(result);
    }
}
