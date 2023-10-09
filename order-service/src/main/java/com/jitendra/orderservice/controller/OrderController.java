package com.jitendra.orderservice.controller;

import com.jitendra.basedomains.dto.Order;
import com.jitendra.basedomains.dto.OrderEvent;
import com.jitendra.orderservice.kafka.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    @Autowired
    private OrderProducer orderProducer;
    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order){

        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent=new OrderEvent();
        orderEvent.setStatus("pending");
        orderEvent.setMessage("status is pending");
        orderEvent.setOrder(order);

        orderProducer.sendMessage(orderEvent);

        return "order places success";

    }

}
