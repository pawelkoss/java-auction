package com.example.auctionapp.domain.auction;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;

@Builder
@Getter
public class AuctionRequestDTO {

    private final long ownerId;
    private final long ownerAccountId;
    @NonNull
    private final String title;
    @NonNull
    private final String description;
    private final int quantity;
    @NonNull
    private final BigDecimal price;
    private final int days;
}
