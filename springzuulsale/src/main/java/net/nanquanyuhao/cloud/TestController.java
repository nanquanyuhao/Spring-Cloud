package net.nanquanyuhao.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nanquanyuhao on 2017/10/21.
 */
@RestController
@Configuration
public class TestController {

    @Autowired
    private MemberClient memberClient;

    @RequestMapping(value = "/food-sale/{memberId}", method = RequestMethod.GET)
    public String foodSale(@PathVariable int memberId) {
        Member m = memberClient.getMember(memberId);
        System.out.println(m.getId() + "---" + m.getName());
        return "success";
    }
}
