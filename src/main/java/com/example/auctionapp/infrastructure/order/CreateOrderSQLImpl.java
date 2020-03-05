package com.example.auctionapp.infrastructure.order;

import com.example.auctionapp.domain.order.CreateOrder;
import com.example.auctionapp.domain.order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CreateOrderSQLImpl implements CreateOrder {

    private final OrderRepository orderRepository;

    @Override
    public void createOrderInt(Order order) {

        //todo byc moze w try catch
        orderRepository.save(order);
        //todo request do banku o oplacenie zamowienia
        
    }
}
