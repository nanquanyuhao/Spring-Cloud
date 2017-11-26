package net.nanquanyuhao.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by nanquanyuhao on 2017/10/21.
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientApp {

    public static void main(String[] args){
        new SpringApplicationBuilder(ConfigClientApp.class).run(args);
    }
}
