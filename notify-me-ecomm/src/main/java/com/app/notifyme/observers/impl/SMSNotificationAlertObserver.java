package com.app.notifyme.observers.impl;

import com.app.notifyme.observables.StocksObservable;
import com.app.notifyme.observers.NotificationAlertObserver;

public class SMSNotificationAlertObserver implements NotificationAlertObserver {
    private String phoneNumber;
    private StocksObservable stocksObservable;

    public SMSNotificationAlertObserver(String phoneNumber, StocksObservable stocksObservable) {
        this.phoneNumber = phoneNumber;
        this.stocksObservable = stocksObservable;
    }

    @Override
    public void update() {
        sendSms();
    }

    private void sendSms() {
        System.out.println("Sending SMS to " + phoneNumber + " for new stock update");
    }
}
