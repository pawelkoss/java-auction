package com.example.auctionapp.infrastructure.auction;

import com.example.auctionapp.domain.auction.Auction;
import com.example.auctionapp.domain.auction.AuctionRetrieval;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class AuctionRetrievalSQLImpl implements AuctionRetrieval {

    private final AuctionRepository auctionRepository;


    @Override
    public List<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }

    @Override
    public Auction getAuctionById(long auctionId) {

        return auctionRepository.getOne(auctionId);

    }


}
