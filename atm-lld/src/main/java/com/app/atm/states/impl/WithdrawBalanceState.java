package com.app.atm.states.impl;

import com.app.atm.models.ATM;
import com.app.atm.models.Card;
import com.app.atm.services.CashWithDrawalProcessor;
import com.app.atm.services.FiveHundredCashWithDrawalProcessor;
import com.app.atm.services.OneHundredWithDrawalProcessor;
import com.app.atm.services.TwoThousandCashWithDrawalProcessor;
import com.app.atm.states.ATMState;

public class WithdrawBalanceState extends ATMState {
    public void cashWithDrawal(ATM atm, Card card, int amount) {
        if(amount > atm.getAtmBalance()) {
            System.out.println("Insufficient Balance in the ATM");
            exit(atm);
        } else if(amount > card.getBalance()) {
            System.out.println("Insufficient Balance in the card");
            exit(atm);
        } else {
            atm.deductAtmBalance(amount);
            card.deductBalance(amount);

            CashWithDrawalProcessor withDrawalProcessor = new TwoThousandCashWithDrawalProcessor(
                    new FiveHundredCashWithDrawalProcessor(
                            new OneHundredWithDrawalProcessor(null)));
            withDrawalProcessor.withDraw(atm, amount);
        }
    }

    public void returnCard() {
        System.out.println("Please take your card");
    }

    public void exit(ATM atm) {
        returnCard();
        System.out.println("Exiting...");
        atm.setAtmState(new IdleState());
    }

}
