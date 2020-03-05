package com.example.auctionapp.domain.auction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderAuction {
    private final AuctionRetrieval auctionRetrieval;


    void verifyAuctionAndDecreaseQuantity(long auctionId, int quantity) {

        Auction auction = auctionRetrieval.getAuctionById(auctionId);
        auction.checkDate();
        verifyAvailableQuantity(auction, quantity);

        auction.decreaseQuantity(quantity);
    }


    void verifyAvailableQuantity(Auction auction, int quantity) {

        if (auction.getQuantity() < quantity || quantity <= 0) {
            String message = String.format("Wrong auction quantity [auction quantity = %d], [order quantity = %d",
                    auction.getQuantity(),
                    quantity);
            throw new IllegalArgumentException(message);
        }
    }


}