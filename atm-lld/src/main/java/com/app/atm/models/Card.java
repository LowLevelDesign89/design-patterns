package com.app.atm.models;

import java.util.Date;

public class Card {
    private String holderName;
    private int cardNumber;
    private int cardPin = 121121;
    private int cvv;
    private Date expiryDate;
    private UserBankAccount userBankAccount;

    public Card() {

    }

    public Card(String holderName, int cardNumber, int cvv, Date expiryDate, UserBankAccount userBankAccount) {
        this.cardNumber = cardNumber;
        this.holderName = holderName;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
        this.userBankAccount = userBankAccount;
    }

    public void setUserBankAccount(UserBankAccount userBankAccount) {
        this.userBankAccount = userBankAccount;
    }

    public boolean authenticatePin(int inputPin) {
        return inputPin == cardPin;
    }

    public void deductBalance(int amount) {
        userBankAccount.withDrawAmount(amount);
    }

    public int getBalance() {
        return userBankAccount.getBalance();
    }
}
