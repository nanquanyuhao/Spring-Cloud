package net.nanquanyuhao.cloud.config;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixThreadPoolKey;

/**
 * 超时方法执行情况：超时等失败情况、断路器打开、线程池满载
 * Created by nanquanyuhao on 2017/10/29.
 */
public class KeyCommand extends HystrixCommand<String>{

    public KeyCommand(){
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("TestGroupKey"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("CommandKey"))
                .andThreadPoolKey(
                        HystrixThreadPoolKey.Factory.asKey("PoolKey")));
    }

    protected String run() throws Exception {
        return null;
    }
}
