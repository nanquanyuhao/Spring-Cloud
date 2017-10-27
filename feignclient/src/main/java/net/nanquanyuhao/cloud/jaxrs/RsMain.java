package net.nanquanyuhao.cloud.jaxrs;

import feign.Feign;
import feign.jaxrs.JAXRSContract;

public class RsMain {

	public static void main(String[] args) {
		RsClient client = Feign.builder()
				// 指定注解翻译器，Feign框架本身不理解 RsClient 类中的注解含义，需要指定翻译器进行翻译
				.contract(new JAXRSContract())
				.target(RsClient.class,
				"http://localhost:8080");
		String result = client.hello();
		System.out.println(result);
	}

}
