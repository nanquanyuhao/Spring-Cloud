package net.nanquanyuhao.cloud.collapser;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import net.nanquanyuhao.cloud.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by nanquanyuhao on 2017/10/30.
 */
@Service
public class CollService {

    /**
     * 1.使用@HystrixCollapser 请求收集器注解，batchMethod配置处理的方法
     * 2.据配置收集1s内调用 getMember 方法的ID，交由getMembers统计执行查询
     * 3.只做了参数收集，不实际调用，参数供 getMembers 使用
     * @param id 一定要保证参数类型与getMembers参数集合内的类型一致，统一使用Integer，int不行
     * @return
     */
    @HystrixCollapser(batchMethod = "getMembers", collapserProperties = {
            @HystrixProperty(name = "timerDelayInMilliseconds", value = "1000")
    })
    public Future<Member> getMember(Integer id){
        System.out.println("执行单个查询的方法");
        return null;
    }

    @HystrixCommand
    public List<Member> getMembers(List<Integer> ids){

        List<Member> mems = new ArrayList<Member>();
        for(int id : ids){
            System.out.println(id);
            Member m = new Member();
            m.setId(id);
            m.setName("nanquanyuhao");
            mems.add(m);
        }
        return mems;
    }
}
