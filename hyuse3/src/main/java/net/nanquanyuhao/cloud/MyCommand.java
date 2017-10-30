package net.nanquanyuhao.cloud;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Created by nanquanyuhao on 2017/10/30.
 */
public class MyCommand extends HystrixCommand<String>{

    private int index;

    public MyCommand(int index){
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory
                .asKey("TestGroupKey")));
        this.index = index;
    }

    @Override
    protected String run() throws Exception {
        Thread.sleep(500);
        System.out.println("执行方法，当前索引：" + index);
        return "";
    }

    @Override
    protected String getFallback() {
        System.out.println("执行回退，当前索引：" + index);
        return "";
    }
}
