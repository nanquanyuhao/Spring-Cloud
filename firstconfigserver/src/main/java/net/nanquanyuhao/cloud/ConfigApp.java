package net.nanquanyuhao.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by nanquanyuhao on 2017/11/19.
 *
 * 开启配置服务器的功能
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigApp {

    public static void main(String[] args){
        new SpringApplicationBuilder(ConfigApp.class).run(args);
    }
}
