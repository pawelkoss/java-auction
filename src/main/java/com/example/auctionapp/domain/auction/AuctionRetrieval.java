package com.example.auctionapp.domain.auction;

import java.util.List;

public interface AuctionRetrieval {
    List<Auction> getAllAuctions();

    Auction getAuctionById(long auctionId);
}
