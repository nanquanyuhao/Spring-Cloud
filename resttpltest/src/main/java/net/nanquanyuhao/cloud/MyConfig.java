package net.nanquanyuhao.cloud;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

/**
 * Created by nanquanyuhao on 2017/10/22.
 *
 * 第二步：全部使用 @MyLoadBalanced 注解的 RestTemplate 均会添加至 tpls 集合中，并在Spring容器初始化时按照afterSingletonsInstantiated()方法添加拦截器
 */
@Configuration
public class MyConfig {

    @Autowired(required = false)
    @MyLoadBalanced
    private List<RestTemplate> tpls = Collections.emptyList();

    @Bean
    public SmartInitializingSingleton lbInitializing(){
        return new SmartInitializingSingleton(){
            public void afterSingletonsInstantiated() {

                for(RestTemplate tpl : tpls){
                    List<ClientHttpRequestInterceptor> interceptors = tpl.getInterceptors();
                    interceptors.add(new MyInterceptor());
                    tpl.setInterceptors(interceptors);
                }
            }
        };
    }
}
