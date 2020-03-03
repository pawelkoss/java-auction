package com.example.auctionapp.domain.order;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Builder
@Getter
public class OrderRequestDTO {

    private final long ownerId;
    private final long ownerAccountId;
    private final long auctionId;
    private final long clientId;
    @NonNull
    private final String clientAccountNumber;
    private final int quantity;
    @NotNull
    private final BigDecimal unitPrice;
    private final Status status;
}
