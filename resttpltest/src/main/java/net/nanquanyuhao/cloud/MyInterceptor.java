package net.nanquanyuhao.cloud;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

/**
 * 第三步：添加自定义拦截器的实际拦截改变内容
 */
public class MyInterceptor implements ClientHttpRequestInterceptor {

	public ClientHttpResponse intercept(HttpRequest request, byte[] body,
			ClientHttpRequestExecution execution) throws IOException {
		System.out.println("===============  这是自定义拦截器");
		System.out.println("         旧的uri：" + request.getURI());
		
		HttpRequest newRequest = new MyRequest(request);
		System.out.println("         新的uri:" + newRequest.getURI());
		
		return execution.execute(newRequest, body);
	}

}
