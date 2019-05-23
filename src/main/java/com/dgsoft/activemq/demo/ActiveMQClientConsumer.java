package com.dgsoft.activemq.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQClientConsumer {

    @JmsListener(destination = "${activemq.topic1}", containerFactory = "topicListenerFactory")
    public void receiveTopic1(String msg) {
        System.out.println("收到的消息topic1->" + msg);
    }
 
    @JmsListener(destination = "${activemq.topic2}", containerFactory = "topicListenerFactory")
    public void receiveTopic2(String msg) {
        System.out.println("收到的消息topic2->" + msg);
    }
 
    @JmsListener(destination = "${activemq.queue1}", containerFactory = "queueListenerFactory")
    public void receiveQueue1(String msg) {
        System.out.println("收到的消息queue1->" + msg);
    }
 
    @JmsListener(destination = "${activemq.queue2}", containerFactory = "queueListenerFactory")
    public void receiveQueue2(String msg) {
        System.out.println("收到的消息queue2->" + msg);
    }
 
}
