package net.nanquanyuhao.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * Created by nanquanyuhao on 2017/10/21.
 *
 * 需要绑定一个消费者的接口类
 */
@SpringBootApplication
@EnableEurekaClient
@EnableBinding(ReceiveService.class)
public class ConsumerApp {

    public static void main(String[] args){
        new SpringApplicationBuilder(ConsumerApp.class).web(true).run(args);
    }

    @StreamListener("myInput")
    public void onReceive(byte[] msg){
        System.out.println("消费者1，接收即时消息：" + new String(msg));
    }
}
