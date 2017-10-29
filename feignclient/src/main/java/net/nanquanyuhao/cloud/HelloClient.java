package net.nanquanyuhao.cloud;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface HelloClient {

	// @RequestLine 为Feign自带的注解，还可以使用JavaEE规范的注解
	@RequestLine("GET /hello")
	String hello();
	
	@RequestLine("GET /person/{id}")
	Person getPerson(@Param("id") Integer id);

	@RequestLine("POST /person/create")
	@Headers("Content-Type: application/json")
	String createPerson(Person p);

	@RequestLine("POST /person/createXML")
	@Headers("Content-Type: application/xml")
	Result createPersonXML(Person p);
}
