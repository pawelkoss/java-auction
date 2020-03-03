package com.example.auctionapp.infrastructure.auction;

import com.example.auctionapp.domain.auction.Auction;
import com.example.auctionapp.domain.auction.CreateAuction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CreateAuctionSQLImpl implements CreateAuction {

    private final AuctionRepository auctionRepository;

    @Override
    public void createAuctionInt(Auction auction) {

        auctionRepository.save(auction);
    }


}
