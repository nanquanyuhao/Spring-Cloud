package net.nanquanyuhao.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 需要开启使用Feign的开关
 * Created by nanquanyuhao on 2017/10/21.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class InvokerApp {

    public static void main(String[] args){
        new SpringApplicationBuilder(InvokerApp.class).web(true).run(args);
    }
}
