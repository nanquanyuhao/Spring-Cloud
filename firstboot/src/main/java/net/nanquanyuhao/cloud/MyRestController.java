package net.nanquanyuhao.cloud;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

/**
 * Created by nanquanyuhao on 2017/10/21.
 */
@RestController
public class MyRestController {

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getPerson(@PathVariable int id) {
        Person p = new Person();
        p.setId(id);
        p.setName("angus");
        p.setAge(30);
        return p;
    }
}
