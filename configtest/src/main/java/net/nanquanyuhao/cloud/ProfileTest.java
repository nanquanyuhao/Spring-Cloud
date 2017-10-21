package net.nanquanyuhao.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by nanquanyuhao on 2017/10/21.
 */
@SpringBootApplication
public class ProfileTest {

    public static void main(String[] args){
        new SpringApplicationBuilder(ProfileTest.class).properties("spring.profiles.active=windows", "server.port=9999").run(args);
    }
}
