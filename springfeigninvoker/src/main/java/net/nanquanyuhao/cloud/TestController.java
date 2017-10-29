package net.nanquanyuhao.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.awt.*;

/**
 * Created by nanquanyuhao on 2017/10/21.
 */
@RestController
public class TestController {

    @Autowired
    private HelloClient helloClient;

    @RequestMapping(method = RequestMethod.GET, value = "/router")
    public String router() {
        String result = helloClient.hello("nanquanyuhao");
        return result;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/police", produces = MediaType.APPLICATION_JSON_VALUE)
    public Police getPolice(){
        Police p = helloClient.getPolice(1);
        return p;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/myhello")
    public String myHello(){
        return helloClient.myHello();
    }
}
