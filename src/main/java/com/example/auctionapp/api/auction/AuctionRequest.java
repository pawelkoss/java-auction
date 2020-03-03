package com.example.auctionapp.api.auction;

import lombok.Value;

import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
@Value
class AuctionRequest {


    private final long ownerId;
    private final long ownerAccountId;
    @NotNull
    private final String title;
    @NotNull
    private final String description;
    private final int quantity;
    @NotNull
    private final BigDecimal price;
    private final int days;

}


