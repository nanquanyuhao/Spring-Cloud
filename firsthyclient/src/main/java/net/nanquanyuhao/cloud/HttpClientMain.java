package net.nanquanyuhao.cloud;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientMain {

	public static void main(String[] args) throws Exception {
		String url = "http://localhost:8080/normalHello";

		HttpGet httpget = new HttpGet(url);		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpResponse response = httpclient.execute(httpget);
		System.out.println(EntityUtils.toString(response.getEntity()));
	}

}
