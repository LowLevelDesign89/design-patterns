package com.app.atm.models;

public class User {
    private UserBankAccount userBankAccount;
    private Card card;

    public User() {

    }

    public User(UserBankAccount userBankAccount) {
        this.userBankAccount = userBankAccount;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
