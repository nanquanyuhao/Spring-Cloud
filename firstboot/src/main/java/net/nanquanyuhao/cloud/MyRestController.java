package net.nanquanyuhao.cloud;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;

/**
 * Created by nanquanyuhao on 2017/10/21.
 */
@RestController
public class MyRestController {

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getPerson(@PathVariable int id, HttpServletRequest request) {
        Person p = new Person();
        p.setId(id);
        p.setName("angus");
        p.setAge(30);
        p.setMessage(request.getRequestURL().toString());

        return p;
    }

    @RequestMapping(value = "/person/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createPerson(@RequestBody Person p) {
        System.out.println(p.getName() + "---" + p.getAge());
        return "sucess, id=" + p.getId();
    }

    /**
     * 参数与返回值均为XML
     * @param person
     * @return
     */
    @RequestMapping(value = "/person/createXML", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public String createXMLPerson(@RequestBody Person person) {
        System.out.println(person.getName() + "-" + person.getId());
        return "<result><message>success</message></result>";
    }
}
