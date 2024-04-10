package com.app;

public class PayToMerchantFlow extends PaymentFlow{
    @Override
    public void validateRequest() {
        System.out.println("Validating Request for PayToMerchant");
    }

    @Override
    public void debitAmount() {
        System.out.println("Debit amount for PayToMerchant");
    }

    @Override
    public void calculateFees() {
        System.out.println("Calculating fee for PayToMerchant");
    }

    @Override
    public void creditAmount() {
        System.out.println("Credit amount for PayToMerchant");
    }
}
