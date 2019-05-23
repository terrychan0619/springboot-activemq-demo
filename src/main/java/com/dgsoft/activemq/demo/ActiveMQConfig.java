package com.dgsoft.activemq.demo;

import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQConfig {
    @Value("${spring.activemq.broker-url}")
    String brokerUrl;
    @Value("${spring.activemq.user}")
    String username;
    @Value("${spring.activemq.password}")
    String password;
    @Value("${activemq.topic1}")
    public String TOPIC1;
    @Value("${activemq.topic2}")
    public String TOPIC2;
    @Value("${activemq.queue1}")
    public String QUEUE1;
    @Value("${activemq.queue2}")
    public String QUEUE2;
 
    @Bean
    public Topic topic1() {
        return new ActiveMQTopic(TOPIC1);
    }
 
    @Bean
    public Topic topic2() {
        return new ActiveMQTopic(TOPIC2);
    }
 
    @Bean
    public Queue queue1() {
        return new ActiveMQQueue(QUEUE1);
    }
 
    @Bean
    public Queue queue2() {
        return new ActiveMQQueue(QUEUE2);
    }
 
    /**
     * topic模式的ListenerContainer
     *
     * @return
     */
    @Bean
    public JmsListenerContainerFactory<?> topicListenerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        ActiveMQConnectionFactory connectionFactor = new ActiveMQConnectionFactory();
        connectionFactor.setBrokerURL(brokerUrl);
        connectionFactor.setUserName(username);
        connectionFactor.setPassword(password);
        factory.setPubSubDomain(true);//topic模式
        factory.setConnectionFactory(connectionFactor);
        return factory;
    }
 
    /**
     * queue模式的ListenerContainer
     *
     * @return
     */
    @Bean
    public JmsListenerContainerFactory<?> queueListenerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        ActiveMQConnectionFactory connectionFactor = new ActiveMQConnectionFactory();
        connectionFactor.setBrokerURL(brokerUrl);
        connectionFactor.setUserName(username);
        connectionFactor.setPassword(password);
        factory.setPubSubDomain(false);//默认就是false
        factory.setConnectionFactory(connectionFactor);
        return factory;
    }

 
}
