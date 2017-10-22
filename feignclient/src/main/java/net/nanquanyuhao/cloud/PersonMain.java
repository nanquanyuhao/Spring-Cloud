package net.nanquanyuhao.cloud;

import feign.Feign;
import feign.gson.GsonDecoder;

public class PersonMain {

	public static void main(String[] args) {
		HelloClient client = Feign.builder()
				.decoder(new GsonDecoder())
				.target(HelloClient.class,
				"http://localhost:8080");
		Person p = client.getPerson(1);
		System.out.println(p.getId());
		System.out.println(p.getName());
		System.out.println(p.getAge());
	}

}
