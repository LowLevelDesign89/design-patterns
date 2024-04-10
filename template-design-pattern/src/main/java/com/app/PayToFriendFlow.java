package com.app;

public class PayToFriendFlow extends PaymentFlow{
    @Override
    public void validateRequest() {
        System.out.println("Validating request for PayToFriend");
    }

    @Override
    public void debitAmount() {
        System.out.println("Debit amount for PayToFriend");
    }

    @Override
    public void calculateFees() {
        System.out.println("Calculating Fees for PayToFriend");
    }

    @Override
    public void creditAmount() {
        System.out.println("Credit amount for PayToFriend");
    }
}
