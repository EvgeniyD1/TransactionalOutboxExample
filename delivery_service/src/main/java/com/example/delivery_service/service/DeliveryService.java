package com.example.delivery_service.service;

import com.example.delivery_service.domain.KafkaMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @KafkaListener(topics = "__logical.name_.public.outbox")
    public void receive(KafkaMessage message) {

        System.out.println(message);
    }
}
