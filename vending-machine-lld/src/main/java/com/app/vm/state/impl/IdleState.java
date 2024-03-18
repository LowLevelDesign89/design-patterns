package com.app.vm.state.impl;

import com.app.vm.models.Coin;
import com.app.vm.models.Item;
import com.app.vm.models.VendingMachine;
import com.app.vm.state.State;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements State {
    public IdleState() {
        System.out.println("Currently Vending machine is in Idle state");
    }

    public IdleState(VendingMachine vendingMachine) {
        System.out.println("Currently Vending machine is in Idle state");
        vendingMachine.setCoinList(new ArrayList<>());
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("You can't start product selection at Idle state");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("You can't insert coin at Idle state");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int itemCode) throws Exception {
        throw new Exception("You can't select product at Idle state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        throw new Exception("You can't refund money at Idle state");
    }

    @Override
    public Item dispenseItem(VendingMachine vendingMachine, int itemCode) throws Exception {
       throw new Exception("You can't dispense item at Idle state");
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception {
        vendingMachine.getInventory().addItem(item, codeNumber);
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("You can't get change at this state");
    }
}
