package net.nanquanyuhao.cloud.contract;

import feign.Feign;
import feign.jaxrs.JAXRSContract;
import net.nanquanyuhao.cloud.jaxrs.RsClient;

/**
 * Created by nanquanyuhao on 2017/10/27.
 */
public class ContractMain {

    public static void main(String[] args) {
        ContractClient client = Feign.builder()
                // 指定注解翻译器，Feign框架本身不理解 RsClient 类中的注解含义，需要指定翻译器进行翻译
                .contract(new MyContract())
                .target(ContractClient.class,
                        "http://localhost:8080");
        String result = client.hello();
        System.out.println(result);
    }
}
