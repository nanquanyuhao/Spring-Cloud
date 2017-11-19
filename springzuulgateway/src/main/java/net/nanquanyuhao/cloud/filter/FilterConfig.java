package net.nanquanyuhao.cloud.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by nanquanyuhao on 2017/11/4.
 */
@Configuration
public class FilterConfig {

    @Bean
    public MyFilter myFilter(){
        return new MyFilter();
    }
}
