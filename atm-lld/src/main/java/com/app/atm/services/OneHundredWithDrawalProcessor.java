package com.app.atm.services;

import com.app.atm.models.ATM;

public class OneHundredWithDrawalProcessor extends CashWithDrawalProcessor {
    public OneHundredWithDrawalProcessor(CashWithDrawalProcessor next) {
        super(next);
    }

    public void withDraw(ATM atm, int amount) {
        int required = amount / 100;
        int balance = amount % 100;

        if(required <= atm.getNoOfHundredNotes()) {
            atm.deductHundredNotes(required);
        } else if(required > atm.getNoOfHundredNotes()) {
            balance += (required - atm.getNoOfHundredNotes()) * 100;
            atm.deductHundredNotes(atm.getNoOfHundredNotes());
        }

        if(balance != 0) {
            System.out.println("Something went wrong");
        }
    }
}
