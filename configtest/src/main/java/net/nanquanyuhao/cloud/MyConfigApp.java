package net.nanquanyuhao.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by nanquanyuhao on 2017/10/21.
 */
@SpringBootApplication
public class MyConfigApp {

    public static void main(String[] args){
        new SpringApplicationBuilder(MyConfigApp.class).properties("spring.config.location=classpath:/abc.properties").run(args);
    }
}
