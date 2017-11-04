package net.nanquanyuhao.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * Created by nanquanyuhao on 2017/11/4.
 */
public class MyFilter extends ZuulFilter{

    /**
     * 路由阶段执行
     * @return
     */
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

    public int filterOrder() {
        // 在路由阶段优先级最高的过滤器
        return 1;
    }

    /**
     * 是否执行此过滤器
     * @return
     */
    public boolean shouldFilter() {
        return true;
    }

    public Object run() {
        System.out.println("执行MyFilter 过滤器");
        return null;
    }
}
