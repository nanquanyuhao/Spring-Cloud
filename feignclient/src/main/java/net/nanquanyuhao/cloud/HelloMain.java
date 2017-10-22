package net.nanquanyuhao.cloud;

import feign.Feign;

/**
 * Created by nanquanyuhao on 2017/10/22.
 */
public class HelloMain {

    public static void main(String[] args){

        HelloClient client = Feign.builder().target(HelloClient.class,
                "http://localhost:8080");
        String result = client.hello();
        System.out.println(result);
    }
}
