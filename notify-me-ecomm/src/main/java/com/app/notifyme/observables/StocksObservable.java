package com.app.notifyme.observables;

import com.app.notifyme.observers.NotificationAlertObserver;

public interface StocksObservable {
    void add(NotificationAlertObserver observer);
    void remove(NotificationAlertObserver observer);
    void notifyObservers();
    void updateStocks(int newStocksAdded);
    int getStocksCount();
}
