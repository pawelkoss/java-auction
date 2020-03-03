package com.example.auctionapp.infrastructure.auction;

import com.example.auctionapp.domain.auction.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepository extends JpaRepository<Auction, Long> {

}
