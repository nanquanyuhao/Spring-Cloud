package net.nanquanyuhao.cloud;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by nanquanyuhao on 2017/11/5.
 */
public class Send {

    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        // 使用虚拟机运行容器化的Rabbit服务
        factory.setHost("192.168.235.104");
        Connection conn = factory.newConnection();
        Channel channel = conn.createChannel();

        String queueName = "hello";
        // 声明队列
        channel.queueDeclare(queueName, false, false, false, null);

        String message = "Hello world 2!";
        // 使用对应通道发布消息
        channel.basicPublish("", queueName, null, message.getBytes());
        channel.close();
        conn.close();
    }
}
