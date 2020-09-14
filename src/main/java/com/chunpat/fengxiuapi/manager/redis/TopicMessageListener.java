package com.chunpat.fengxiuapi.manager.redis;


import com.chunpat.fengxiuapi.bo.OrderMessageBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class TopicMessageListener implements MessageListener {

    private static ApplicationEventPublisher publisher;

    @Autowired
    public void setPublisher(ApplicationEventPublisher publisher){
        TopicMessageListener.publisher = publisher;
    }

    @Override
    public void onMessage(Message message, byte[] bytes) {
        byte[] body = message.getBody();
        byte[] channel = message.getChannel();

        String expiredKey = new String(body);
        String topic = new String(channel);
        System.out.println(expiredKey);
        System.out.println(topic);
        //发起监听
        TopicMessageListener.publisher.publishEvent(new OrderMessageBO(expiredKey));

    }
}
