package net.nanquanyuhao.cloud.open;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandMetrics;
import com.netflix.hystrix.HystrixCommandProperties;

/**
 * Created by nanquanyuhao on 2017/10/29.
 */
public class CloseMain {

    public static void main(String[] args) throws Exception {
        // 10秒内大于3次请求，满足第一个条件，默认20
        ConfigurationManager
                .getConfigInstance()
                .setProperty(
                        "hystrix.command.default.circuitBreaker.requestVolumeThreshold",
                        3);

        boolean isTimeout = true;
        for(int i = 0; i < 10; i++) {
            TestCommand c = new TestCommand(isTimeout);
            c.execute();

            HystrixCommandMetrics.HealthCounts hc = c.getMetrics().getHealthCounts();
            System.out.println("断路器状态：" + c.isCircuitBreakerOpen() + ", 请求总数：" + hc.getTotalRequests());
            if(c.isCircuitBreakerOpen()) {
                isTimeout = false;
                System.out.println("============  断路器打开了，等待休眠期结束");
                Thread.sleep(6000);
            }
        }
    }

    static class TestCommand extends HystrixCommand<String> {

        private boolean isTimeout;

        public TestCommand(boolean isTimeout) {
            super(Setter.withGroupKey(
                    HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                    .andCommandPropertiesDefaults(
                            HystrixCommandProperties.Setter()
                                    // run() 500毫秒未执行完毕即执行回退方法
                                    .withExecutionTimeoutInMilliseconds(500)));
            this.isTimeout = isTimeout;
        }

        @Override
        protected String run() throws Exception {
            if(isTimeout) {
                Thread.sleep(800);
            } else {
                Thread.sleep(200);
            }
            return "";
        }

        @Override
        protected String getFallback() {
            return "fallback";
        }
    }
}
