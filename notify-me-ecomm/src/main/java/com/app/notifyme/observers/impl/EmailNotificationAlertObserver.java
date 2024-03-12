package com.app.notifyme.observers.impl;

import com.app.notifyme.observables.StocksObservable;
import com.app.notifyme.observers.NotificationAlertObserver;

public class EmailNotificationAlertObserver implements NotificationAlertObserver {
    private String email;
    private StocksObservable stocksObservable;

    public EmailNotificationAlertObserver(String email, StocksObservable stocksObservable) {
        this.email = email;
        this.stocksObservable = stocksObservable;
    }

    @Override
    public void update() {
        sendEmail();
    }

    private void sendEmail() {
        System.out.println("Sending email to " + email + " for new stock update");
    }
}
