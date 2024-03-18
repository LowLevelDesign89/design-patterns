package com.app.atm.models;

import com.app.atm.states.ATMState;
import com.app.atm.states.impl.IdleState;

public class ATM {
    private static ATM instance = new ATM();

    private int noOfTwoThousandNotes;
    private int noOfFiveHundredNotes;
    private int noOfHundredNotes;
    private int atmBalance;
    private ATMState atmState;

    private ATM() {

    }

    public static ATM getInstance() {
        instance.setAtmState(new IdleState());
        return instance;
    }

    public void setAtmBalance(int atmBalance, int noOfTwoThousandNotes, int noOfFiveHundredNotes, int noOfHundredNotes) {
        this.atmBalance = atmBalance;
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfHundredNotes = noOfHundredNotes;
    }

    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public int getNoOfHundredNotes() {
        return noOfHundredNotes;
    }

    public void deductAtmBalance(int amount) {
        atmBalance -= amount;
    }

    public void deductTwoThousandNotes(int number) {
        noOfTwoThousandNotes -= number;
    }

    public void deductFiveHundredNotes(int number) {
        noOfFiveHundredNotes -= number;
    }

    public void deductHundredNotes(int number) {
        noOfHundredNotes -= number;
    }

    public ATMState getAtmState() {
        return atmState;
    }

    public void setAtmState(ATMState atmState) {
        this.atmState = atmState;
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void printAtmBalance() {
        System.out.println("Balance: " + atmBalance);
        System.out.println("No. of Two Thousand Notes: " + noOfTwoThousandNotes);
        System.out.println("No. of Five Hundred Notes: " + noOfFiveHundredNotes);
        System.out.println("No. of Hundred Notes: " + noOfHundredNotes);
    }
}
