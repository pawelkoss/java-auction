package com.example.auctionapp.infrastructure.order;

import com.example.auctionapp.domain.order.Order;
import com.example.auctionapp.domain.order.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByStatus(Status status);
}
