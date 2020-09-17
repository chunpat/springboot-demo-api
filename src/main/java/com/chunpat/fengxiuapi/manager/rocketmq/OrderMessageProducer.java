package com.chunpat.fengxiuapi.manager.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class OrderMessageProducer {
    // Instantiate a producer to send scheduled messages
    DefaultMQProducer producer;

    @Value("${rocketmq.name-server}")
    private String nameServer;

    @Value("${rocketmq.producer.group}")
    private String group;

    @Value("${rocketmq.producer.topic}")
    private String topic;

    public OrderMessageProducer() {}

    //注入的变量是在构造函数后赋值的，所以利用PostConstruct这个注解，作用是在构造函数后调用
    @PostConstruct
    private void initConsumer() {
        // Instantiate a producer to send scheduled messages
        if (this.producer == null) {
            this.producer = new DefaultMQProducer(this.group);
            this.producer.setNamesrvAddr(this.nameServer);
        }

        try {
            this.producer.start();
            System.out.println("------start producer--------");
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    public String send(String topic, String msg) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        Message message = new Message(topic, msg.getBytes());
        // This message will be delivered to consumer 10 seconds later.
//        messageDelayLevel=1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
        message.setDelayTimeLevel(3);
        // Send the message
        SendResult sendResult;

        sendResult = this.producer.send(message);
        System.out.println(sendResult.getMsgId());
        System.out.println(sendResult.getSendStatus());
        return sendResult.getMsgId();

        // Shutdown producer after use.
//        this.producer.shutdown();
    }
}
