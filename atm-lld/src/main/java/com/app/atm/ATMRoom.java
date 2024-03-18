package com.app.atm;

import com.app.atm.models.*;

public class ATMRoom {
    private static ATM atm;
    private static User user;
    public static void main(String[] args) {
        initialize();
        atm.printAtmBalance();
        atm.getAtmState().insertCard(atm);
        atm.getAtmState().insertPIN(atm, user.getCard(), 112211);
        atm.getAtmState().selectOption(atm, user.getCard(), TransactionType.WITHDRAWAL_BALANCE);
        atm.getAtmState().cashWithDrawal(atm, user.getCard(), 2700);
        atm.printAtmBalance();



    }

    private static void initialize() {

        //create ATM
        atm = ATM.getInstance();
        atm.setAtmBalance(3500, 1,2,5);

        //create User
        user = createUser();
    }

    private static User createUser(){

        User user = new User();
        user.setCard(createCard());
        return user;
    }

    private static Card createCard(){

        Card card = new Card();
        card.setUserBankAccount(createBankAccount());
        return card;
    }

    private static UserBankAccount createBankAccount() {

        UserBankAccount bankAccount = new UserBankAccount();
        bankAccount.setBalance(3000);

        return bankAccount;

    }

}
