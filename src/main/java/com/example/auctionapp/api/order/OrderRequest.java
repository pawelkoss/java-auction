package com.example.auctionapp.api.order;

import com.example.auctionapp.domain.order.Status;
import lombok.NonNull;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Value
class OrderRequest {

    private final long ownerId;
    private final long ownerAccountId;
    private final long auctionId;
    private final long clientId;
    @NotNull
    private final String clientAccountNumber;
    private final int quantity;
    @NotNull
    private final BigDecimal unitPrice;
    private final Status status;

}
