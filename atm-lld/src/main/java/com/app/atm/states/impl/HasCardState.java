package com.app.atm.states.impl;

import com.app.atm.models.ATM;
import com.app.atm.models.Card;
import com.app.atm.states.ATMState;

public class HasCardState extends ATMState {
    public void insertPIN(ATM atm, Card card, int pinNumber) {
        if(card.authenticatePin(pinNumber)) {
            // set the next state
            atm.setAtmState(new SelectOperationState());
        } else {
            System.out.println("Incorrect PIN number");
            exit(atm);
        }
    }

    public void exit(ATM atm) {
        returnCard();
        System.out.println("Exiting ....");
        atm.setAtmState(new IdleState());
    }

    public void returnCard() {
        System.out.println("Please collect your card");
    }

}
