package net.nanquanyuhao.cloud.web;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by nanquanyuhao on 2017/10/30.
 */
// 注解为一个 Filter，拦截全部请求
@WebFilter(urlPatterns = "/*", filterName = "hystrixFilter")
public class MyFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 为确保在同一个请求内使用Hystrix缓存，就采用拦截器完成，获取请求上下文并最终关闭
        HystrixRequestContext ctx = HystrixRequestContext.initializeContext();
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {

        } finally {
            ctx.shutdown();
        }
    }

    public void destroy() {

    }
}
