package net.nanquanyuhao.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by nanquanyuhao on 2017/10/31.
 */
@FeignClient(name = "spring-hy-member", fallback = HelloClientFallback.class)
public interface HelloClient {

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    String hello();

    @RequestMapping(method = RequestMethod.GET, value = "/toHello")
    String toHello();
}
