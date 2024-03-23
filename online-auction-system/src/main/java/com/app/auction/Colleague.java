package com.app.auction;

public interface Colleague {
    void placeBid(int amount);
    void receiveBidNotification(int amount);

    String getName();
}
