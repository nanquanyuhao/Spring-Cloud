package net.nanquanyuhao.cloud;

import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义路由
 */
//@Configuration
public class MyConfig {

	/**
	 * 访问网关的 /sale/**，将会被路由到 spring-zuul-sale 服务进行处理
	 */
	@Bean
	public PatternServiceRouteMapper patternServiceRouteMapper() {
		return new PatternServiceRouteMapper(
				"(spring)-(zuul)-(?<module>.+)", "${module}/**");
	}
}
