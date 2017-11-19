package net.nanquanyuhao.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by nanquanyuhao on 2017/11/19.
 */
@SpringBootApplication
public class ClientApp {

    public static void main(String[] args){
        new SpringApplicationBuilder(ClientApp.class).run(args);
    }
}
