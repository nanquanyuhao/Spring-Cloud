package net.nanquanyuhao.cloud.feign;

import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.HystrixCommandKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nanquanyuhao on 2017/10/31.
 */
@RestController
public class FeignController {

    @Autowired
    private HelloClient helloClient;

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String hello(){
       return helloClient.hello();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/toHello")
    public String toHello(){
        String result = helloClient.toHello();

        // 获取指定客户端方法（HelloClient#toHello()）的断路器
        // 此外，默认GroupKey为客户端名称此处即 spring-hy-member
        HystrixCircuitBreaker breaker = HystrixCircuitBreaker.Factory
                .getInstance(HystrixCommandKey.Factory
                        .asKey("HelloClient#toHello()"));
        System.out.println("断路器状态：" + breaker.isOpen());

        return result;
    }
}
