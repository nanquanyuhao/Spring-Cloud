package net.nanquanyuhao.cloud.net.nanquanyuhao.cloud.controller;

import net.nanquanyuhao.cloud.net.nanquanyuhao.cloud.entity.Person;
import net.nanquanyuhao.cloud.net.nanquanyuhao.cloud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nanquanyuhao on 2017/11/26.
 */
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/persons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> persons(){
        return personService.getPersons();
    }

    @RequestMapping(value = "/mq", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> myQuery(){
        return personService.myQuery();
    }
}
