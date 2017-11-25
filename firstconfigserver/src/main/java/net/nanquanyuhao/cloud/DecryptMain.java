package net.nanquanyuhao.cloud;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Created by nanquanyuhao on 2017/11/25.
 */
public class DecryptMain {

    public static void main(String[] args) throws Exception{

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://localhost:8888/decrypt");

        // 验证解密字符串
        // HttpEntity entity = new StringEntity("2ede1896c44b06b14e09075bf943107064166b017c193b007a41f249742be1d1", Consts.UTF_8);

        String passwd = "AIBeJCIKj3C51c0/+syuQpYOf7qS/YfRgK1agD4U2pyMoh48UCnT4Iqq2bmwDURz0Z4Rn7KhkZyApW7uBfOcnQtHoAzR1bpvO0Kjhh5pc7iW1ZApghaqF0K7P4HxqkePTuOOkqUKb6oRdCGsmMgAAfWu4FkIfuuuyarO32HTeYy7+f9Y5+3wOq3x1fOQGXjDWj8ckxkP7gTP1c8jmnlzA+w6";
        // 验证解密字符串
        HttpEntity entity = new StringEntity(passwd, Consts.UTF_8);
        post.setEntity(entity);

        HttpResponse respose = client.execute(post);
        System.out.println(EntityUtils.toString(respose.getEntity()));
    }
}
