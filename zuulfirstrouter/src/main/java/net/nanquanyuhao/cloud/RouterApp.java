package net.nanquanyuhao.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 开启zuul代理
 * Created by nanquanyuhao on 2017/10/31.
 */
@SpringBootApplication
@EnableZuulProxy
public class RouterApp {

    public static void main(String[] args){
        SpringApplication.run(RouterApp.class, args);
    }
}
