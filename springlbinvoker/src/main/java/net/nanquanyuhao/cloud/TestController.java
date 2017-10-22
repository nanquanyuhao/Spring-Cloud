package net.nanquanyuhao.cloud;

import com.netflix.loadbalancer.ZoneAwareLoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by nanquanyuhao on 2017/10/21.
 */
@RestController
@Configuration
public class TestController {

    @Autowired
    private LoadBalancerClient client;

    @Autowired
    private SpringClientFactory factory;

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/router")
    @ResponseBody
    public String router() {
        RestTemplate tpl = getRestTemplate();

        // 即调用服务为 spring-lb-provider 的时候，如果 MyClient 配置了此服务的规则，就会启用
        String json = tpl.getForObject("http://spring-lb-provider/call/1", String.class);
        return json;
    }

    @RequestMapping(value = "/lb", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceInstance lb() {
        ServiceInstance si = client.choose("spring-lb-provider");
        return si;
    }

    @RequestMapping(value = "/fa", method = RequestMethod.GET)
    public String factory() {

        ZoneAwareLoadBalancer lb = (ZoneAwareLoadBalancer)factory.getLoadBalancer("default");
        System.out.println(lb.getRule().getClass().getName());

        ZoneAwareLoadBalancer lb2 = (ZoneAwareLoadBalancer)factory.getLoadBalancer("spring-lb-provider");
        System.out.println(lb2.getRule().getClass().getName());

        return "";
    }
}
