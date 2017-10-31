package net.nanquanyuhao.cloud.feign;

import org.springframework.stereotype.Component;

/**
 * Created by nanquanyuhao on 2017/10/31.
 */
@Component
public class HelloClientFallback implements HelloClient {

    public String hello() {
        return "fallback hello";
    }

    public String toHello() {
        return "fallback timeout hello";
    }
}
