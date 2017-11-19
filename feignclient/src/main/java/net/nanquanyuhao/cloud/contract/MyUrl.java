package net.nanquanyuhao.cloud.contract;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * 1.只能修饰方法，即方法级的注解
 * 2.运行时解析
 * Created by nanquanyuhao on 2017/10/27.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyUrl {

    String url();
    String method();
}
