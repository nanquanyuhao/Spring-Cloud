package net.nanquanyuhao.cloud.controller;

import net.nanquanyuhao.cloud.entity.Person;
import net.nanquanyuhao.cloud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> name(@PathVariable String name){
        return personService.name(name);
    }

    @RequestMapping(value = "/na/{name}/{age}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> name(@PathVariable String name, @PathVariable int age){
        return personService.nameAndAge(name, age);
    }

    @RequestMapping(value = "/alt/{age}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> alt(@PathVariable int age){
        return personService.ageLessThan(age);
    }

    @RequestMapping(value = "/pn/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> pn(@PathVariable String  name){
        return personService.findPersonName(name);
    }

    @RequestMapping(value = "/nn/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> nn(@PathVariable String  name){
        return personService.findNativeName(name);
    }
}
