package com.app.atm.services;

import com.app.atm.models.ATM;

public class FiveHundredCashWithDrawalProcessor extends CashWithDrawalProcessor{
    public FiveHundredCashWithDrawalProcessor(CashWithDrawalProcessor next) {
        super(next);
    }

    public void withDraw(ATM atm, int amount) {
        int required = amount / 500;
        int balance = amount % 500;

        if(required <= atm.getNoOfFiveHundredNotes()) {
            atm.deductFiveHundredNotes(required);
        } else if(required > atm.getNoOfFiveHundredNotes()) {
            balance += (required - atm.getNoOfFiveHundredNotes()) * 500;
            atm.deductFiveHundredNotes(atm.getNoOfFiveHundredNotes());
        }

        if(balance != 0) {
            super.withDraw(atm, balance);
        }
    }
}
