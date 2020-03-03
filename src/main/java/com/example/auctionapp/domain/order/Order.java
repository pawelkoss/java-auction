package com.example.auctionapp.domain.order;

import com.example.auctionapp.domain.auction.Auction;
import com.example.auctionapp.domain.auction.AuctionResponseDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Setter
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long ownerId;
    private long ownerAccountId;
    private long auctionId;
    private long clientId;
    private String clientAccountNumber;
    private int quantity;
    private BigDecimal unitPrice;
    @Enumerated(EnumType.STRING)
    private Status status;

    BigDecimal getTotalPrice() {
        BigDecimal totalPrice = unitPrice.multiply(new BigDecimal(quantity));
        return totalPrice;
    }

    static Order create(OrderRequestDTO orderRequestDTO) {
        Order order = new Order();
        order.setOwnerId(orderRequestDTO.getOwnerId());
        order.setOwnerAccountId(orderRequestDTO.getOwnerAccountId());
        order.setAuctionId(orderRequestDTO.getAuctionId());
        order.setClientId(orderRequestDTO.getClientId());
        order.setClientAccountNumber(orderRequestDTO.getClientAccountNumber());
        order.setQuantity(orderRequestDTO.getQuantity());
        order.setUnitPrice(orderRequestDTO.getUnitPrice());
        order.setStatus(orderRequestDTO.getStatus());
        return order;
    }

    static class OrderMapper {
        static OrderResponseDTO mapToDto(Order order) {
            return OrderResponseDTO.builder()
                    .ownerId(order.getOwnerId())
                    .ownerAccountId(order.getOwnerAccountId())
                    .clientAccountNumber(order.getClientAccountNumber())
                    .totalPrice(order.getTotalPrice())
                    .build();

        }
    }
}