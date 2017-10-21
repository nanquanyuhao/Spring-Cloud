package net.nanquanyuhao.cloud;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nanquanyuhao on 2017/10/21.
 */
@RestController
public class PoliceController {

    @RequestMapping(value = "/call/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Police call(@PathVariable int id) {
        Police p = new Police();
        p.setId(id);
        p.setName("nanquanyuhao");
        return p;
    }
}
