package com.app.atm.states.impl;

import com.app.atm.models.ATM;
import com.app.atm.models.Card;
import com.app.atm.states.ATMState;

public class CheckBalanceState extends ATMState {
    public void checkBalance(ATM atm, Card card) {
        System.out.println("Your current balance is : " + card.getBalance());
        exit(atm);
    }

    public void exit(ATM atm) {
        returnCard();
        System.out.println("Exiting...");
        atm.setAtmState(new IdleState());
    }

    public void returnCard() {
        System.out.println("Please take your card");
    }
}
