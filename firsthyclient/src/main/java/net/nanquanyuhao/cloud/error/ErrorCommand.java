package net.nanquanyuhao.cloud.error;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Created by nanquanyuhao on 2017/10/29.
 */
public class ErrorCommand extends HystrixCommand<String> {

    public ErrorCommand(){
        super(HystrixCommandGroupKey.Factory.asKey("TestGroup"));
    }

    protected String run() throws Exception {
        String url = "http://localhost:8080/errorHello";

        HttpGet httpget = new HttpGet(url);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpResponse response = httpclient.execute(httpget);
        return EntityUtils.toString(response.getEntity());
    }

    /**
     * run()方法超时之后，用此方法代替进行返回，实现容错逻辑，默认超时时间为1s
     * @return
     */
    protected String getFallback(){
        System.out.println("fall back method");
        return "fall back hello";
    }
}
