package com.example.auctionapp.domain.auction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuctionFacade {

    private final AuctionRetrieval auctionRetrieval;
    private final CreateAuction createAuction;

    public void createAuction(AuctionRequestDTO auctionRequestDTO){

        createAuction.createAuctionInt(Auction.create(auctionRequestDTO));
    }

    public List<AuctionResponseDTO> getAllAuctions(){
        return auctionRetrieval.getAllAuctions()
                .stream()
                .map(Auction.AuctionMapper::mapToDto)
                .collect(Collectors.toList());
    }

}
