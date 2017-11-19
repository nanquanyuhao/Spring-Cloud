package net.nanquanyuhao.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 使
 * Created by nanquanyuhao on 2017/10/31.
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DashboardApp {

    public static void main(String[] args){
        new SpringApplicationBuilder(DashboardApp.class).properties("server.port=8082").run(args);
    }
}
