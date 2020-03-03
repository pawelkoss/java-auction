package com.example.auctionapp.domain.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderFacade {

    private final CreateOrder createOrder;
    private final OrderRetrieval orderRetrieval;

    public void createOrder(OrderRequestDTO orderRequestDTO){

        createOrder.createOrderInt(Order.create(orderRequestDTO));
    }

    public List<OrderResponseDTO> getOrdersByStatus(Status status){
        return orderRetrieval.getOrdersByStatus(status)
                .stream()
                .map(Order.OrderMapper::mapToDto)
                .collect(Collectors.toList());
    }


}
