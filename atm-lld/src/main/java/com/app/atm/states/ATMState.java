package com.app.atm.states;

import com.app.atm.models.ATM;
import com.app.atm.models.Card;
import com.app.atm.models.TransactionType;

public abstract class ATMState {
    public void insertCard(ATM atm) {
        System.out.println("Sorry ! you can't perform this operation at this state");
    }

    public void insertPIN(ATM atm, Card card, int pinNumber) {
        System.out.println("Sorry ! you can't perform this operation at this state");
    }

    public void selectOption(ATM atm, Card card, TransactionType txnType) {
        System.out.println("Sorry ! you can't perform this operation at this state");
    }

    public void cashWithDrawal(ATM atm, Card card, int amount) {
        System.out.println("Sorry ! you can't perform this operation at this state");
    }

    public void checkBalance(ATM atm, Card card) {
        System.out.println("Sorry ! you can't perform this operation at this state");
    }

    public void returnCard() {
        System.out.println("Sorry ! you can't perform this operation at this state");
    }

    public void exit(ATM atm) {
        System.out.println("Sorry ! you can't perform this operation at this state");
    }
}
