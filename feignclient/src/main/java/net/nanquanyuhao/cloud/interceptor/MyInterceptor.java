package net.nanquanyuhao.cloud.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * Created by nanquanyuhao on 2017/10/27.
 */
public class MyInterceptor implements RequestInterceptor {

    public void apply(RequestTemplate requestTemplate) {

        // 统一设置请求头，即不用在定义接口时定义头
        requestTemplate.header("Content-Type", "application/json");
        System.out.println("这是自定义请求拦截器");
    }
}
