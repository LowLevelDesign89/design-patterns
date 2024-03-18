package com.app.atm.services;

import com.app.atm.models.ATM;

public class TwoThousandCashWithDrawalProcessor extends CashWithDrawalProcessor{
    public TwoThousandCashWithDrawalProcessor(CashWithDrawalProcessor next) {
        super(next);
    }

    public void withDraw(ATM atm, int amount) {
        int required = amount / 2000;
        int balance = amount % 2000;

        if(required <= atm.getNoOfTwoThousandNotes()) {
            atm.deductTwoThousandNotes(required);
        } else if(required > atm.getNoOfTwoThousandNotes()) {
            balance = balance + (required - atm.getNoOfTwoThousandNotes()) * 2000;
            atm.deductTwoThousandNotes(atm.getNoOfTwoThousandNotes());
        }

        if(balance != 0) {
            super.withDraw(atm, balance);
        }
    }
}
