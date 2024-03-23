package com.app.auction;

import com.app.auction.impl.Auction;
import com.app.auction.impl.Bidder;

public class Client {
    public static void main(String[] args) {
        AuctionMediator mediator = new Auction();
        Colleague bidder1 = new Bidder("Bidder1", mediator);
        Colleague bidder2 = new Bidder("Bidder2", mediator);

        bidder1.placeBid(100);
    }
}
