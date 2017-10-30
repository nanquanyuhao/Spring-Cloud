package net.nanquanyuhao.cloud.cache;

import net.nanquanyuhao.cloud.Member;
import net.nanquanyuhao.cloud.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nanquanyuhao on 2017/10/30.
 */
@RestController
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @RequestMapping(value = "/cache", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String cache() {
        for(int i = 0; i < 3; i++) {
            // 此处注意，参数会决定是否走缓存方法，参数不一样就不会走缓存需要重新执行
            cacheService.cacheMember(1);
        }
        return "";
    }

    @RequestMapping(value = "/rc", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String testRemoveCache() {
        cacheService.getCache(1);
        cacheService.getCache(1);

        cacheService.removeCache(1);
        System.out.println("#########  分隔线   ###########");
        cacheService.getCache(1);
        return "";
    }
}
