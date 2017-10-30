package net.nanquanyuhao.cloud;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by nanquanyuhao on 2017/10/30.
 */
@Service
//@DefaultProperties(defaultFallback = "getMemberFallback")
public class MemberService {

    @Autowired
    private RestTemplate restTpl;

    // @HystrixCommand 为 Hystrix 提供的注解，用于方法的注解
    @HystrixCommand(fallbackMethod = "getMemberFallback", groupKey = "MemberGroup", commandKey = "MemberCommandKey",
            // 超时时间设置为1秒
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")},
            // 设置线程池中线程数2个，默认为10
            threadPoolProperties = {@HystrixProperty(name = "coreSize", value = "2")})
    public Member getMember(int id){
        // 执行时间必定大于2s，必然触发失败方法
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }

        Member member = restTpl.getForObject("http://spring-hy-member/member/{id}", Member.class, id);
        return member;
    }

    public Member getMemberFallback(int id){
        Member m = new Member();
        m.setId(id);
        m.setName("error member");
        return m;
    }
}
