package com.example.auctionapp.api.order;

import com.example.auctionapp.domain.auction.AuctionFacade;
import com.example.auctionapp.domain.order.OrderFacade;
import com.example.auctionapp.domain.order.OrderRequestDTO;
import com.example.auctionapp.domain.order.OrderResponseDTO;
import com.example.auctionapp.domain.order.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequiredArgsConstructor
class OrderController {

    private final OrderFacade orderFacade;
    private final AuctionFacade auctionFacade;


    @PostMapping(path = "/auctions/{auctionId}/order")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@Valid @RequestBody OrderRequest orderRequest, @PathVariable long auctionId) {

        // veryfi auction and or create order
        auctionFacade.verifyAuction(auctionId, orderRequest.getQuantity());

        OrderRequestDTO orderRequestDTO = OrderRequestDTO.builder()
                .ownerId(auctionFacade.getAuctionById(auctionId).getOwnerId())
                .ownerAccountId(auctionFacade.getAuctionById(auctionId).getOwnerAccountId())
                .auctionId(orderRequest.getAuctionId())
                .clientId(orderRequest.getClientId())
                .clientAccountNumber(orderRequest.getClientAccountNumber())
                .unitPrice(auctionFacade.getAuctionById(auctionId).getPrice())
                .quantity(orderRequest.getQuantity())
                .status(Status.PENDING)
                .build();
        orderFacade.createOrder(orderRequestDTO);
    }



    //orders?status=PENDING
    @GetMapping(path = "/orders")
    public ResponseEntity <List<OrderResponseDTO>> getOrdersByStatus(@PathParam(value = "status") Status status) {
        try {
            List<OrderResponseDTO> orderResponseDTO = orderFacade.getOrdersByStatus(status);
            return ResponseEntity.ok(orderResponseDTO);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    //todo oczekiwanie na feedback z banku ze zamowienie zostalo oplacone; update orders status=paid




}
