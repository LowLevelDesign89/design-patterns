package com.app.atm.models;

public enum TransactionType {
    CHECK_BALANCE,
    WITHDRAWAL_BALANCE;

    public static void showAllTransactions() {
        for(TransactionType txnType: TransactionType.values()) {
            System.out.println(txnType.name());
        }
    }
}
