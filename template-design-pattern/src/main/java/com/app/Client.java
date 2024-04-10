package com.app;

public class Client {
    public static void main(String[] args) {
        PaymentFlow paymentFlow = new PayToFriendFlow();
        paymentFlow.sendMoney();
    }
}
