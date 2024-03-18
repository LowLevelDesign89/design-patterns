package com.app.atm.models;

public class UserBankAccount {
    private int balance;

    public void withDrawAmount(int amount) {
        balance = balance - amount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
