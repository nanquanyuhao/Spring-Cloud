package net.nanquanyuhao.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nanquanyuhao on 2017/11/19.
 */
@RestController
public class BootController {

    @Autowired
    private ApplicationContext ctx;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){

        System.out.println("#####   ");
        Environment env = ctx.getEnvironment();
        // 顺序读取父类上下文的 bootstrap.yml 属性，再次读取自身上下文的 application.yml 属性
        System.out.println(env.getProperty("test.user.name"));
        return "";
    }
}
