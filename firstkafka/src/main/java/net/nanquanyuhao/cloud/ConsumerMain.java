package net.nanquanyuhao.cloud;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * Created by nanquanyuhao on 2017/11/5.
 */
public class ConsumerMain {

    public static void main(String[] args) {
        // 配置信息，配置虚拟机地址
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.235.104:9092");
        // 必须指定消费者组
        props.put("group.id", "test");
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        // 订阅 my-topic 的消息
        consumer.subscribe(Arrays.asList("my-topic"));
        // 到服务器中读取记录
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("这是消费者A，key: " + record.key() + ", value: " + record.value());
            }
        }
    }
}
