package com.app.auction.impl;

import com.app.auction.AuctionMediator;
import com.app.auction.Colleague;

import java.util.ArrayList;
import java.util.List;

public class Auction implements AuctionMediator {
    private List<Colleague> colleagueList = new ArrayList<>();

    @Override
    public void addBidder(Colleague colleague) {
        colleagueList.add(colleague);
    }

    @Override
    public void placeBid(Colleague bidder, int amount) {
        for(Colleague colleague: colleagueList) {
            if(!bidder.getName().equals(colleague.getName())) {
                colleague.receiveBidNotification(amount);
            }
        }
    }
}
