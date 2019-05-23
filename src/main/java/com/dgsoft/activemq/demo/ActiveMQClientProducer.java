package com.dgsoft.activemq.demo;

import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQClientProducer {
    @Autowired
    JmsTemplate jmsTemplate;
    
    @Autowired
    Topic topic1;
    
    @Autowired
    Topic topic2;
    
    @Autowired
    Queue queue1;
    @Autowired
    Queue queue2;
    
    public void topic1Produce(String msg) {
        this.jmsTemplate.convertAndSend(this.topic1, msg);
    }
    public void topic2Produce(String msg) {
        this.jmsTemplate.convertAndSend(this.topic2, msg);
    }
    public void queue1Produce(String msg) {
        this.jmsTemplate.convertAndSend(this.queue1, msg);
    }
    public void queue2Produce(String msg) {
        this.jmsTemplate.convertAndSend(this.queue2, msg);
    }
    
}
