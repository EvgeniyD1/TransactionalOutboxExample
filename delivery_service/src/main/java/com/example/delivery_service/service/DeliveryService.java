package com.example.delivery_service.service;

import com.example.delivery_service.domain.KafkaMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @KafkaListener(topics = "orders_server.orders.outbox")
    public void receive(KafkaMessage message) {

        System.out.println(message);
    }
}
