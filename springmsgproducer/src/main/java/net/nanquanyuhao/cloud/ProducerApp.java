package net.nanquanyuhao.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * Created by nanquanyuhao on 2017/10/21.
 *
 * 需要绑定一个生产者的接口类
 */
@SpringBootApplication
@EnableEurekaClient
@EnableBinding(SendService.class)
public class ProducerApp {

    public static void main(String[] args){
        new SpringApplicationBuilder(ProducerApp.class).run(args);
    }
}
