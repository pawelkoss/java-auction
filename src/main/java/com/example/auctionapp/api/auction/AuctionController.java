package com.example.auctionapp.api.auction;


import com.example.auctionapp.domain.auction.AuctionFacade;
import com.example.auctionapp.domain.auction.AuctionRequestDTO;
import com.example.auctionapp.domain.auction.AuctionResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/auctions")
@RequiredArgsConstructor
class AuctionController {

    private final AuctionFacade auctionFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAuction(@Valid @RequestBody AuctionRequest auctionRequest) {
        AuctionRequestDTO auctionRequestDTO = AuctionRequestDTO.builder()
                .ownerId(auctionRequest.getOwnerId())
                .ownerAccountId(auctionRequest.getOwnerAccountId())
                .title(auctionRequest.getTitle())
                .description(auctionRequest.getDescription())
                .quantity(auctionRequest.getQuantity())
                .price(auctionRequest.getPrice())
                .days(auctionRequest.getDays())
                .build();
        auctionFacade.createAuction(auctionRequestDTO);
    }

    @GetMapping
    public ResponseEntity<List<AuctionResponseDTO>> getAllAuctions(){
        return ResponseEntity.ok(auctionFacade.getAllAuctions());
    }


}
