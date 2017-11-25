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
public class EncryptMain {

    public static void main(String[] args) throws Exception{

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://localhost:8888/encrypt");

        // 传入待加密字符串
        HttpEntity entity = new StringEntity("crazyit", Consts.UTF_8);
        post.setEntity(entity);

        HttpResponse respose = client.execute(post);
        System.out.println(EntityUtils.toString(respose.getEntity()));
    }
}
