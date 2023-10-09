package com.jitendra.orderservice.kafka;

import com.jitendra.basedomains.dto.OrderEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private static final Logger logger= LoggerFactory.getLogger(OrderProducer.class);
    @Autowired
    private NewTopic topic;
    @Autowired
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;


    public void sendMessage(OrderEvent orderEvent){
        logger.info(String.format("Order event -> %s", orderEvent.toString()));

        Message<OrderEvent>message= MessageBuilder.withPayload(orderEvent).setHeader(KafkaHeaders.TOPIC,topic.name()).build();

        kafkaTemplate.send(message);
    }
}
