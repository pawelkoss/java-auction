package com.example.auctionapp.domain.order;

import java.util.List;
import java.util.Optional;

public interface OrderRetrieval {

    List<Order> getOrdersByStatus(Status status);

}
