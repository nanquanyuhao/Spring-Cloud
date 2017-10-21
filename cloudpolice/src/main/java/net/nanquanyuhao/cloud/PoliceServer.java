package net.nanquanyuhao.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

/**
 * Created by nanquanyuhao on 2017/10/21.
 */
@SpringBootApplication
@EnableEurekaClient
public class PoliceServer {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        // 获取控制台的端口输入
        String port = scan.nextLine();

        new SpringApplicationBuilder(PoliceServer.class).properties("server.port=" + port).run(args);
    }
}
