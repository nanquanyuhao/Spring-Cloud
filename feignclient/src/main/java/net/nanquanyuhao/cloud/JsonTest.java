package net.nanquanyuhao.cloud;

import feign.Feign;
import feign.gson.GsonEncoder;

/**
 * Created by nanquanyuhao on 2017/10/22.
 */
public class JsonTest {

    public static void main(String[] args){

        HelloClient client = Feign.builder().encoder(new GsonEncoder()).target(HelloClient.class,
                "http://localhost:8080");

        Person p = new Person();
        p.setAge(27);
        p.setId(1);
        p.setName("nanquanyuhao");

        String result = client.createPerson(p);
        System.out.println(result);
    }
}
