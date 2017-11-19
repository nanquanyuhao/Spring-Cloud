package net.nanquanyuhao.cloud;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommandProperties.ExecutionIsolationStrategy;

/**
 * 1.同步启动全部任务，每个任务异步执行
 * 2.先启动的三个任务处于等待状态，导致隔离策略满载，会导致接下来的失败
 * 3.后三个任务失败直接执行失败方法所以最先输出执行回退方法
 */
public class SemaphoreMain {

	public static void main(String[] args) throws Exception {

		// 设置执行隔离的策略为 SEMAPHORE ，默认为 THREAD
		ConfigurationManager.getConfigInstance().setProperty(
				"hystrix.command.default.execution.isolation.strategy", ExecutionIsolationStrategy.SEMAPHORE);
		// 最大并发数调整为3，默认为10
		ConfigurationManager.getConfigInstance().setProperty(
				"hystrix.command.default.execution.isolation.semaphore.maxConcurrentRequests", 3);
		for(int i = 0; i < 6; i++) {
			final int index = i;
			Thread t = new Thread() {
				public void run() {
					MyCommand c = new MyCommand(index);
					c.execute();
				}
			};
			t.start();
		}
		Thread.sleep(5000);
	}

}
