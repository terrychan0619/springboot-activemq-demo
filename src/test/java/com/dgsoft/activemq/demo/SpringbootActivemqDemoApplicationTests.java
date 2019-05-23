package com.dgsoft.activemq.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootActivemqDemoApplicationTests {

    @Autowired
    ActiveMQClientProducer activeMQClientProducer;
 
    @Test
    public void testProduce() throws Exception {
        for (int i = 0; i < 5; i++) {
            activeMQClientProducer.topic1Produce("發送消息 topic1 hi" + i);
        }
        for (int i = 0; i < 5; i++) {
            activeMQClientProducer.topic2Produce("發送消息 topic2 hello" + i);
        }
        for (int i = 0; i < 5; i++) {
            activeMQClientProducer.queue1Produce("發送消息 queue1 你好" + i);
        }
        for (int i = 0; i < 5; i++) {
            activeMQClientProducer.queue2Produce("發送消息 queue2 hei" + i);
        }
    }
 

}
