package net.nanquanyuhao.cloud;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * Created by nanquanyuhao on 2017/11/5.
 */
public class ProducerMain {

    public static void main(String[] args) throws Exception {
        // 配置信息，在虚拟机中
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.235.104:9092");
        // 设置数据key的序列化处理类
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        // 设置数据value的序列化处理类
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        // 创建生产者实例
        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        // 创建一条新的记录，第一个参数为Topic名称
        ProducerRecord record = new ProducerRecord<String, String>("my-topic", "userName", "nanquanyuhao");
        // 发送记录
        producer.send(record);
        producer.close();
    }
}
