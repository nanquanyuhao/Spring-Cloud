package net.nanquanyuhao.cloud.contract;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by nanquanyuhao on 2017/10/29.
 */
// 使用自动配置类完成配置
@Configuration
public class MyConfig {

    /**
     * 自定义注解翻译器的实例化
     * @return
     */
    @Bean
    public Contract feignContract() {
        return new MyContract();
    }
}
