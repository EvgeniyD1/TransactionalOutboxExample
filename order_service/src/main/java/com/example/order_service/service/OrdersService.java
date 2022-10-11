package com.example.order_service.service;

import com.example.order_service.domain.CustomerOrder;
import com.example.order_service.domain.Outbox;
import com.example.order_service.repository.OrdersRepository;
import com.example.order_service.repository.OutboxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final OutboxRepository outboxRepository;

    @Transactional
    public Map<String,Object> createOrder(Map<String,Object> orderMap) {

        CustomerOrder order = new CustomerOrder();
        order.setName(orderMap.get("name").toString());
        order.setQuantity(Integer.parseInt(String.valueOf(orderMap.get("quantity"))));
        ordersRepository.save(order);

        Outbox outbox = new Outbox();

        outbox.setEvent("order_created");
        outbox.setEventId(order.getId());

        outbox.setPayload(orderMap);

        outbox.setCreatedAt(LocalDateTime.now());

        System.out.println(outbox);
        outboxRepository.save(outbox);

        //delete immediately - still the entry will be picked up from the logs as there was an insert
        //in the previous line

        outboxRepository.delete(outbox);

        return Map.of("orderId",order.getId());
    }
}
