package net.nanquanyuhao.cloud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration
public class MyController {

	// 添加 @MyLoadBalanced 注解，确保会将 RestTemplate 实例化后走 MyConfig 类，进行拦截器的添加
	@Bean
	@MyLoadBalanced
	public RestTemplate tplA() {
		return new RestTemplate();
	}
	
	@RequestMapping(value = "/call", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String call() {
		RestTemplate tpl = tplA();
		String json = tpl.getForObject("http://hello-servie/call", String.class);
		return json;
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "Hello World";
	}

}
