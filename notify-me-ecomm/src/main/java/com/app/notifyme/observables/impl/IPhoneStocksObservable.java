package com.app.notifyme.observables.impl;

import com.app.notifyme.observables.StocksObservable;
import com.app.notifyme.observers.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IPhoneStocksObservable implements StocksObservable {
    private List<NotificationAlertObserver> observers;
    private int currentStocksCount = 0;

    public IPhoneStocksObservable() {
        this.observers = new ArrayList<>();
    }


    @Override
    public void add(NotificationAlertObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(NotificationAlertObserver observer: observers) {
            observer.update();
        }
    }

    @Override
    public void updateStocks(int newStocksAdded) {
        if(currentStocksCount == 0) {
            notifyObservers();
        }
        currentStocksCount = currentStocksCount + newStocksAdded;
    }

    @Override
    public int getStocksCount() {
        return currentStocksCount;
    }
}
