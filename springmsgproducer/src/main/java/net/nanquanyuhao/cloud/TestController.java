package net.nanquanyuhao.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nanquanyuhao on 2017/10/21.
 */
@RestController
public class TestController {

    @Autowired
    private SendService sendService;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String send() {

        Message msg = MessageBuilder.withPayload("Hello World 2".getBytes()).build();
        sendService.sendOrder().send(msg);
        return "success";
    }
}
