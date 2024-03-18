package com.app.vm.state.impl;

import com.app.vm.models.Coin;
import com.app.vm.models.Item;
import com.app.vm.models.VendingMachine;
import com.app.vm.state.State;

import java.util.List;

public class HasMoneyState implements State {
    public HasMoneyState() {
        System.out.println("Currently the vending machine is in HasMoneyState");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        return;
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        vendingMachine.getCoinList().add(coin);
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int itemCode) throws Exception {
        throw new Exception("You can't select product at this state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        List<Coin> coins = vendingMachine.getCoinList();
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return coins;
    }

    @Override
    public Item dispenseItem(VendingMachine vendingMachine, int itemCode) throws Exception {
        throw new Exception("You can't dispense item at this state");
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception {
        throw new Exception("You can't update inventory at this state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("You can't get change at this state");
    }
}
