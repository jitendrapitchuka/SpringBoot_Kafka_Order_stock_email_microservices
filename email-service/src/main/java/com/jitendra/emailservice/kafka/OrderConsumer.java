package com.jitendra.emailservice.kafka;

import com.jitendra.basedomains.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    private static final Logger logger= LoggerFactory.getLogger(OrderConsumer.class);
    @KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent event){

    logger.info(String.format("order event received -> %s",event.toString()));

    }
}
