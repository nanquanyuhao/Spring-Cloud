package net.nanquanyuhao.cloud;

import com.netflix.config.ConfigurationManager;

/**
 * 1.同步启动全部任务，每个任务异步执行
 * 2.先启动的三个任务处于等待状态，导致隔离策略满载，会导致接下来的失败
 * 3.后三个任务失败直接执行失败方法所以最先输出执行回退方法
 * Created by nanquanyuhao on 2017/10/30.
 */
public class ThreadMain {

    public static void main(String[] args) throws Exception {
        // 设置线程池中线程数3个，默认为10
        ConfigurationManager.getConfigInstance().setProperty(
                "hystrix.threadpool.default.coreSize", 3);
        for(int i = 0; i < 6; i++) {
            MyCommand c = new MyCommand(i);
            c.queue();
        }

        // 等待5s确保执行完成
        Thread.sleep(5000);
    }
}
