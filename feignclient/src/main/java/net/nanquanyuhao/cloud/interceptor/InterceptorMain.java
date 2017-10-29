package net.nanquanyuhao.cloud.interceptor;

import feign.Feign;
import net.nanquanyuhao.cloud.HelloClient;
import net.nanquanyuhao.cloud.contract.ContractClient;
import net.nanquanyuhao.cloud.contract.MyContract;

/**
 * Created by nanquanyuhao on 2017/10/27.
 */
public class InterceptorMain {

    public static void main(String[] args) {
        HelloClient client = Feign.builder()
                // 设置使用自定义拦截器
                .requestInterceptor(new MyInterceptor())
                .target(HelloClient.class,
                "http://localhost:8080");
        String result = client.hello();
        System.out.println(result);
    }
}
