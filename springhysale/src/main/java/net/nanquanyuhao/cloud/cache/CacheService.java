package net.nanquanyuhao.cloud.cache;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import net.nanquanyuhao.cloud.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by nanquanyuhao on 2017/10/30.
 */
@Service
public class CacheService {

    @Autowired
    private RestTemplate restTpl;

    /**
     * 1.@CacheResult 需要配合@HystrixCommand 一起使用
     * @param id
     * @return
     */
    @CacheResult
    @HystrixCommand
    public Member cacheMember(int id){

        System.out.println("调用 cacheMember 方法");
        // Member member = restTpl.getForObject("http://spring-hy-member/member/{id}", Member.class, id);
        return null;
    }

    /**
     * 调用getCache方法会形成指定commandKey的缓存
     * @param id
     * @return
     */
    @CacheResult
    @HystrixCommand(commandKey = "cacheKey")
    public String getCache(Integer id) {
        System.out.println("执行查询方法");
        return null;
    }

    /**
     * 1.调用 removeCache 方法会删除指定commandKey的缓存
     * 2.
     * @param id
     */
    @CacheRemove(commandKey = "cacheKey")
    @HystrixCommand
    public void removeCache(Integer id) {
        System.out.println("删除缓存方法");
    }
}
