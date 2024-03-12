package com.app.notifyme;

import com.app.notifyme.observables.StocksObservable;
import com.app.notifyme.observables.impl.IPhoneStocksObservable;
import com.app.notifyme.observers.impl.EmailNotificationAlertObserver;
import com.app.notifyme.observers.impl.SMSNotificationAlertObserver;


public class NotifiyMeTester {
    public static void main(String[] args) {

        StocksObservable stocksObservable = new IPhoneStocksObservable();
        stocksObservable.add(new EmailNotificationAlertObserver("xyz1@gmail.com", stocksObservable));
        stocksObservable.add(new EmailNotificationAlertObserver("xyz2@gmail.com", stocksObservable));
        stocksObservable.add(new SMSNotificationAlertObserver("1234678990", stocksObservable));

        stocksObservable.updateStocks(10);
        stocksObservable.updateStocks(100);
    }
}
