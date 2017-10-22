package net.nanquanyuhao.cloud;

import feign.Client;
import feign.Request;
import feign.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by nanquanyuhao on 2017/10/22.
 */
public class MyClient implements Client {

    public Response execute(Request request, Request.Options options) throws IOException {

        System.out.println("this is my client");

        try {
            // 创建一个默认客户端
            CloseableHttpClient httpClient = HttpClients.createDefault();
            // 获取调用的Http方法
            final String method = request.method();
            // 创建一个HttpClient的HttpRequest
            HttpRequestBase httpRequest = new HttpRequestBase() {
                @Override
                public String getMethod() {
                    return method;
                }
            };

            // 设置请求地址
            httpRequest.setURI(new URI(request.url()));
            //执行请求，获取响应
            HttpResponse httpResponse = httpClient.execute(httpRequest);
            // 获取响应的主体内容
            byte[] body = EntityUtils.toByteArray(httpResponse.getEntity());
            // 将HttpClient的响应对象转化为 Frign 的Response
            Response response = Response.builder()
                    .body(body).headers(new HashMap<String, Collection<String>>())
                    .status(httpResponse.getStatusLine().getStatusCode()).build();

            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
