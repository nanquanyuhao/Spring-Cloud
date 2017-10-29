package net.nanquanyuhao.cloud.contract;

import feign.Contract;
import feign.MethodMetadata;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 1.在类 MyUrl 中，@Target(ElementType.METHOD)表明为方法级注解，只实现 processAnnotationOnMethod 即可
 * 2.直接继承SpringMvcContract，自带Spring的四种注解
 * Created by nanquanyuhao on 2017/10/29.
 */
public class MyContract extends SpringMvcContract {

    /**
     * 翻译器实现：方法级别的注解
     * @param methodMetadata
     * @param annotation
     * @param method
     */
    protected void processAnnotationOnMethod(MethodMetadata methodMetadata, Annotation annotation, Method method) {

        // 确保父类方法正常执行
        super.processAnnotationOnMethod(methodMetadata, annotation, method);

        // 首先判断注解类 annotation 类型为MyUrl才会处理
        if (MyUrl.class.isInstance(annotation)) {

            System.out.println("##### 这是自定义注解翻译器");
            // 读取注解中配置
            MyUrl myUrl = method.getAnnotation(MyUrl.class);
            String url = myUrl.url();
            String httpMethod = myUrl.method();

            // 将读取的配置设置到模板内
            methodMetadata.template().method(httpMethod);
            methodMetadata.template().append(url);
        }
    }
}
