package com.app.auction;

public interface AuctionMediator {
    void addBidder(Colleague colleague);

    void placeBid(Colleague bidder, int amount);
}
