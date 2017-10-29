package net.nanquanyuhao.cloud.config;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * 全局配置超时时间，单个命令并未配置超时时间
 */
public class PropertyMain {

	public static void main(String[] args) {
		ConfigurationManager
		.getConfigInstance()
		.setProperty(
				"hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds",
				2000);
		PropertyCommand c = new PropertyCommand();
		String result = c.execute();
		System.out.println(result);
	}

	static class PropertyCommand extends HystrixCommand<String> {
		public PropertyCommand() {
		    super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup")));
		}

		@Override
		protected String run() throws Exception {
			Thread.sleep(3500);
			return "success";
		}

		@Override
		protected String getFallback() {
			return "fallback";
		}
		
	}
}
