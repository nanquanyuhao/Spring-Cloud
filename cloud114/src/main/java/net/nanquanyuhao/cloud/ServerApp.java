package net.nanquanyuhao.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.Scanner;

/**
 * Created by nanquanyuhao on 2017/10/21.
 */
@SpringBootApplication
@EnableEurekaServer
public class ServerApp {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        String profiles = scan.nextLine();

        new SpringApplicationBuilder(ServerApp.class).profiles(profiles).run(args);
    }
}
