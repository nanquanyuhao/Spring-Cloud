package net.nanquanyuhao.cloud;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;

/**
 * Created by nanquanyuhao on 2017/10/22.
 */
public class MyConfig {

    @Bean
    public IRule grtRule(){
        return new MyRule();
    }
}
