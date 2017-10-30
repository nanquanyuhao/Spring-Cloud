package net.nanquanyuhao.cloud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@RequestMapping(value = "/normalHello", method = RequestMethod.GET)
	public String normalHello() {
		return "Hello World";
	}

	@RequestMapping(value = "/errorHello", method = RequestMethod.GET)
	public String errorHello() throws Exception {
		Thread.sleep(10000);
		return "Error Hello World";
	}
}
