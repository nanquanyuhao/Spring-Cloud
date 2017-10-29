package net.nanquanyuhao.cloud;

import net.nanquanyuhao.cloud.contract.MyUrl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 使用 @FeignClient 注解表明此接口为Feign接口，并需要指明调用的服务名
 * Created by nanquanyuhao on 2017/10/27.
 */
@FeignClient("spring-feign-provider")
public interface HelloClient {

    // 此处使用了且只能使用Spring的注解，说明了Spring实现了Spring使用时的注解翻译器，以其翻译器来翻译此注解
    // Spring的此注解翻译器共翻译了 @RequestMapping、@PathVariable、@RequestParam、@RequestHeader 四个注解
    @RequestMapping(method = RequestMethod.GET, value = "/hello/{name}")
    String hello(@PathVariable("name") String name);

    @RequestMapping(method = RequestMethod.GET, value = "/call/{id}")
    Police getPolice(@PathVariable("id") int id);

    // 使用自定义注解 @MyUrl ，注意两属性的使用
    @MyUrl(url = "hellowd", method = "GET")
    String myHello();
}
