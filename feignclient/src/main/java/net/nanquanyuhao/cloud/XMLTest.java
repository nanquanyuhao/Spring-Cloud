package net.nanquanyuhao.cloud;

import feign.Feign;
import feign.jaxb.JAXBContextFactory;
import feign.jaxb.JAXBDecoder;
import feign.jaxb.JAXBEncoder;

/**
 * Created by nanquanyuhao on 2017/10/22.
 */
public class XMLTest {

    public static void main(String[] args){

        JAXBContextFactory jaxbFactory = new JAXBContextFactory.Builder().build();
        // 获取服务接口
        HelloClient client = Feign.builder()
                .encoder(new JAXBEncoder(jaxbFactory))
                .decoder(new JAXBDecoder(jaxbFactory))
                .target(HelloClient.class, "http://localhost:8080/");

        Person p = new Person();
        p.setId(1);
        p.setName("nanquanyuhao");
        p.setAge(27);

        Result result = client.createPersonXML(p);
        System.out.println(result.getMessage());
    }
}
