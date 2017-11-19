package net.nanquanyuhao.cloud.config;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

/**
 * Created by nanquanyuhao on 2017/10/29.
 */
public class TimeoutCommand extends HystrixCommand<String>{

    public TimeoutCommand(){
        // 初始化时配置超时时间
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionTimeoutInMilliseconds(2000)));
    }

    @Override
    protected String run() throws Exception {
        Thread.sleep(3000);
        System.out.println("执行命令");
        return "success";
    }

    @Override
    protected String getFallback() {
        System.out.println("执行回退方法");
        return "fallback";
    }
}
