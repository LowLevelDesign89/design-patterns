package com.app.product;

public class Payment {
    public void makePayment() {
        System.out.println("Initiating Payment");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {

        }
        System.out.println("Payment successful");
    }
}
