package net.nanquanyuhao.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Scanner;

/**
 * Created by nanquanyuhao on 2017/10/21.
 */
@SpringBootApplication
public class FirstApp {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String port = scan.nextLine();

        new SpringApplicationBuilder(FirstApp.class).properties("server.port=" + port).run(args);
    }
}
