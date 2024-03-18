package com.app.atm.services;

import com.app.atm.models.ATM;

public class CashWithDrawalProcessor {
    private CashWithDrawalProcessor next;

    public CashWithDrawalProcessor(CashWithDrawalProcessor next) {
        this.next = next;
    }

    public void withDraw(ATM atm, int amount) {
        if(next != null) {
            next.withDraw(atm, amount);
        }
    }
}
