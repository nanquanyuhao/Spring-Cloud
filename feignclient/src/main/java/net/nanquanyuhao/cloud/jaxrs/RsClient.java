package net.nanquanyuhao.cloud.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

public interface RsClient {

	/**
	 * 1.使用GET方式发送请求
	 * 2.@Path注解用来声明路径
	 * @return
	 */
	@GET
	@Path("/hello")
	String hello();
}
