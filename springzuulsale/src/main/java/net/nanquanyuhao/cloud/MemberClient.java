package net.nanquanyuhao.cloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("spring-zuul-member")
public interface MemberClient {

	@RequestMapping(value = "/member/{id}", method = RequestMethod.GET)
	Member getMember(@PathVariable("id") int id);
}
