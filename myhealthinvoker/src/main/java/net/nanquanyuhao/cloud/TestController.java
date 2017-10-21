package net.nanquanyuhao.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by nanquanyuhao on 2017/10/21.
 */
@Controller
@Configuration
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/router")
    @ResponseBody
    public String router() {
        RestTemplate tpl = getRestTemplate();
        String json = tpl.getForObject("http://my-health-provider/call/1", String.class);
        return json;
    }

    @GetMapping("/list")
    @ResponseBody
    private String serviceCount(){
        List<String> names = discoveryClient.getServices();
        for(String serviceId : names) {
            List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
            System.out.println(serviceId + ": " + instances.size());
        }
        return "";
    }
}
