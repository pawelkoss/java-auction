package com.example.auctionapp.api.order;

import lombok.Value;
import javax.validation.constraints.NotNull;

@Value
class OrderRequest {

    private final long auctionId;
    private final long clientId;
    @NotNull
    private final String clientAccountNumber;
    private final int quantity;

}
