package com.example.order_service.controller;

import com.example.order_service.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;

    @PostMapping("/order")
    public Map<String,Object> createOrder(@RequestBody Map<String,Object> order) {
        return ordersService.createOrder(order);
    }
}
