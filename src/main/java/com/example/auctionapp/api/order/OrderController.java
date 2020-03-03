package com.example.auctionapp.api.order;

import com.example.auctionapp.domain.order.OrderFacade;
import com.example.auctionapp.domain.order.OrderRequestDTO;
import com.example.auctionapp.domain.order.OrderResponseDTO;
import com.example.auctionapp.domain.order.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
class OrderController {

    private final OrderFacade orderFacade;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@Valid @RequestBody OrderRequest orderRequest) {
        OrderRequestDTO orderRequestDTO = OrderRequestDTO.builder()
                .ownerId(orderRequest.getOwnerId())
                .ownerAccountId(orderRequest.getOwnerAccountId())
                .auctionId(orderRequest.getAuctionId())
                .clientId(orderRequest.getClientId())
                .clientAccountNumber(orderRequest.getClientAccountNumber())
                .unitPrice(orderRequest.getUnitPrice())
                .quantity(orderRequest.getQuantity())
                .status(orderRequest.getStatus())
                .build();
        orderFacade.createOrder(orderRequestDTO);
    }

    //orders?status=PENDING
    @GetMapping
    public ResponseEntity <List<OrderResponseDTO>> getOrdersByStatus(@PathParam(value = "status") Status status) {
        try {
            List<OrderResponseDTO> orderResponseDTO = orderFacade.getOrdersByStatus(status);
            return ResponseEntity.ok(orderResponseDTO);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
