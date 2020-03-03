package com.example.auctionapp.infrastructure.order;

import com.example.auctionapp.domain.order.Order;
import com.example.auctionapp.domain.order.OrderRetrieval;
import com.example.auctionapp.domain.order.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
class OrderRetrievalSQLImpl implements OrderRetrieval {

    private final OrderRepository orderRepository;

    @Override
    public List<Order> getOrdersByStatus(Status status) {

        return orderRepository.findByStatus(status);
    }
}
