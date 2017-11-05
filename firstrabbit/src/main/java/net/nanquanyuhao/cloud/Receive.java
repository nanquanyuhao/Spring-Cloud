package net.nanquanyuhao.cloud;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by nanquanyuhao on 2017/11/5.
 */
public class Receive {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        // 使用虚拟机运行容器化的Rabbit
        // 服务
        factory.setHost("192.168.235.104");
        Connection conn = factory.newConnection();
        Channel channel = conn.createChannel();

        String queueName = "hello";
        // 声明队列
        channel.queueDeclare(queueName, false, false, false, null);

        Consumer consumer = new DefaultConsumer(channel) {

            // @Override 未能解决，始终不走这个重写的方法，eclipse 中实验可以，应该是设置问题以后解决！
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "UTF-8");
                System.out.println("接收到的消息：" + msg);
            }
        };

        channel.basicConsume(queueName, consumer);
    }
}
