package net.nanquanyuhao.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by nanquanyuhao on 2017/11/26.
 */
@SpringBootApplication
public class JpaApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(JpaApp.class).run(args);
    }
}
