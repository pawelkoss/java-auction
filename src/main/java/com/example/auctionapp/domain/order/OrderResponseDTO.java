package com.example.auctionapp.domain.order;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;

@Builder
@Getter
public class OrderResponseDTO {

    @NonNull
    private final long ownerId;
    @NonNull
    private final long ownerAccountId;
    @NonNull
    private final String clientAccountNumber;
    @NonNull
    private final BigDecimal totalPrice;


}
