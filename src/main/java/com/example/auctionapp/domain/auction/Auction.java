package com.example.auctionapp.domain.auction;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Setter
@Table(name = "AUCTIONS")
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private  long ownerId;
    private  long ownerAccountId;
    private  String title;
    private  String description;
    private int quantity;
    private  BigDecimal price;
    private  LocalDateTime startDate;
    private  LocalDateTime endDate;
    private int days;
    private boolean activ;


    BigDecimal calculatePrice(int quantity){
        return this.price.multiply(BigDecimal.valueOf(quantity));
    }
    void decreaseQuantity(int quantity){
        this.quantity = this.quantity - quantity;
    }


    static Auction create(AuctionRequestDTO auctionRequestDTO){
        Auction auction = new Auction();
        auction.setOwnerId(auctionRequestDTO.getOwnerId());
        auction.setOwnerAccountId(auctionRequestDTO.getOwnerAccountId());
        auction.setTitle(auctionRequestDTO.getTitle());
        auction.setDescription(auctionRequestDTO.getDescription());
        auction.setQuantity(auctionRequestDTO.getQuantity());
        auction.setPrice(auctionRequestDTO.getPrice());
        auction.setDays(auctionRequestDTO.getDays());

        return auction;

    }

    static class AuctionMapper{
        static AuctionResponseDTO mapToDto(Auction auction){
            return AuctionResponseDTO.builder()
                    .ownerId(auction.getOwnerId())
                    .ownerAccountId(auction.getOwnerAccountId())
                    .title(auction.getTitle())
                    .description(auction.getDescription())
                    .quantity(auction.getQuantity())
                    .price(auction.getPrice())
                    .days(auction.getDays())
                    .build();

        }
    }

}
