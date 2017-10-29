package net.nanquanyuhao.cloud.cb;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

/**
 * Created by nanquanyuhao on 2017/10/29.
 */
public class FallbackMain {
    public static void main(String[] args){
        FallbackCommand c = new FallbackCommand();
        String result = c.execute();
        System.out.println(result);
    }

    static class FallbackCommand extends HystrixCommand<String> {

        public FallbackCommand(){
            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                    .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                            // 命令初始化即开启断路器
                            .withCircuitBreakerForceOpen(true)));
        }

        protected String run() throws Exception {
            return "success";
        }

        /**
         * 由于断路器被打开，总会执行失败的回退方法
         * @return
         */
        protected String getFallback(){
            return "fallback";
        }
    }
}
