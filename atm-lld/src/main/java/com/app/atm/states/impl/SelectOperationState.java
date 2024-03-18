package com.app.atm.states.impl;

import com.app.atm.models.ATM;
import com.app.atm.models.Card;
import com.app.atm.models.TransactionType;
import com.app.atm.states.ATMState;

public class SelectOperationState extends ATMState {
    public SelectOperationState() {
        showOperations();
    }

    public void selectOption(ATM atm, Card card, TransactionType txnType) {
        switch (txnType) {
            case TransactionType.CHECK_BALANCE:
                atm.setAtmState(new CheckBalanceState()); // check balance state
                return;
            case TransactionType.WITHDRAWAL_BALANCE:
                atm.setAtmState(new WithdrawBalanceState()); // withdrawal balance state
                return;
            default:
                System.out.println("Invalid operation");
                exit(atm);
        }
    }

    public void exit(ATM atm) {
        returnCard();
        System.out.println("Exiting....");
        atm.setAtmState(new IdleState());
    }

    public void returnCard() {
        System.out.println("Please collect your card");
    }

    private void showOperations() {
        TransactionType.showAllTransactions();
    }
}
