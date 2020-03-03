package com.example.auctionapp.domain.auction;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;
@Builder
@Getter
public class AuctionResponseDTO {


        @NonNull
        private final long ownerId;
        private final long ownerAccountId;
        @NonNull
        private final String title;
        @NonNull
        private final String description;
        @NonNull
        private final int quantity;
        @NonNull
        private final BigDecimal price;
        @NonNull
        private final int days;


}
