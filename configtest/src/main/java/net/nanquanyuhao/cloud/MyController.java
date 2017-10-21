package net.nanquanyuhao.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by nanquanyuhao on 2017/10/21.
 */
@Controller
public class MyController {

    @Autowired
    private ApplicationContext ctx;

    @GetMapping("/prop")
    @ResponseBody
    public String getName() {
        System.out.println("hello world");
        return ctx.getEnvironment().getProperty("test.user.name");
    }
}
