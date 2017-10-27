package net.nanquanyuhao.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Scanner;

/**
 * Created by nanquanyuhao on 2017/10/22.
 */
@SpringBootApplication
public class ServiceApp {

    public static void main (String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        String port = scan.nextLine();

        new SpringApplicationBuilder(ServiceApp.class).properties("server.port=" + port).run(args);
    }
}
