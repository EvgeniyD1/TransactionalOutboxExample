package com.example.order_service.repository;

import com.example.order_service.domain.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<CustomerOrder, Long> {
}
