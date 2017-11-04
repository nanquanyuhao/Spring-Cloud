package net.nanquanyuhao.cloud;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nanquanyuhao on 2017/11/4.
 */
@RestController
public class TestController {

    @RequestMapping(value = "/source/hello/{name}", method = RequestMethod.GET)
    public String receive(@PathVariable("name") String name){
        return "hello" + name;
    }
}
