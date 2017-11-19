package net.nanquanyuhao.cloud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 * 消费者
 * @author 杨恩雄
 *
 */
public class ConsumerMainB {

	public static void main(String[] args) {
		// 配置信息
		Properties props = new Properties();
		props.put("bootstrap.servers", "192.168.235.104:9092");
		// 指定了不同的消费者组，消息会被广播到所有的消费者实例
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
				System.out.println("这是消费者B，key: " + record.key() + ", value: " + record.value());
			}
		}
	}
}
