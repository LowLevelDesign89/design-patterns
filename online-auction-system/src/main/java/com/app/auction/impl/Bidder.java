package com.app.auction.impl;

import com.app.auction.AuctionMediator;
import com.app.auction.Colleague;

public class Bidder implements Colleague {
    private String name;
    private AuctionMediator auctionMediator;

    public Bidder(String name, AuctionMediator auctionMediator) {
        this.name = name;
        this.auctionMediator = auctionMediator;
        this.auctionMediator.addBidder(this);
    }

    @Override
    public void placeBid(int amount) {
        auctionMediator.placeBid(this, amount);
    }

    @Override
    public void receiveBidNotification(int amount) {
        System.out.println("another bidder has bidding with amount : " + amount);
    }

    @Override
    public String getName() {
        return name;
    }

}
