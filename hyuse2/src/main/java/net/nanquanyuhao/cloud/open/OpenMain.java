package net.nanquanyuhao.cloud.open;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

/**
 * Created by nanquanyuhao on 2017/10/29.
 */
public class OpenMain {

    public static void main(String[] args){
        // 10秒内大于10次请求，满足第一个条件，默认20
        ConfigurationManager
                .getConfigInstance()
                .setProperty(
                        "hystrix.command.default.circuitBreaker.requestVolumeThreshold",
                        10);

        for(int i = 0; i < 15; i++) {
            ErrorCommand c = new ErrorCommand();
            c.execute();
            // 输出断路器状态
            System.out.println(c.isCircuitBreakerOpen());
        }
    }

    static class ErrorCommand extends HystrixCommand<String> {

        public ErrorCommand() {
            super(Setter.withGroupKey(
                    HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                    .andCommandPropertiesDefaults(
                            HystrixCommandProperties.Setter()
                                    // run() 500毫秒未执行完毕即执行回退方法
                                    .withExecutionTimeoutInMilliseconds(500)));
        }

        @Override
        protected String run() throws Exception {
            // 800毫秒大于命令断路器开启条件，所以均会执行回退方法
            Thread.sleep(800);
            return "";
        }

        protected String getFallback() {
            return "fallback";
        }
    }
}
