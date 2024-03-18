package com.app.vm.state.impl;

import com.app.vm.models.Coin;
import com.app.vm.models.Item;
import com.app.vm.models.VendingMachine;
import com.app.vm.state.State;

import java.util.List;

public class SelectionState implements State {
    public SelectionState() {
        System.out.println("Currently the vending machine is in SelectionState");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("You can't click on Insert Coin button at this state");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        return;
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("You can't insert coin at this state");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int itemCode) throws Exception {
        Item item = vendingMachine.getInventory().getItem(itemCode);

       List<Coin> coinsPaidByUser = vendingMachine.getCoinList();
       int totalAmountPaid = 0;
       for(Coin coin: coinsPaidByUser) {
           totalAmountPaid += coin.getValue();
       }

       if(item.getPrice() > totalAmountPaid) {
           System.out.println("Insufficient Amount: product you selected for " + totalAmountPaid + " has actual price of " + item.getPrice());
           refundFullMoney(vendingMachine);
           throw new Exception("Insufficient Amount: Product price : " + item.getPrice() + " <-> You paid : " + totalAmountPaid);
       } else if(totalAmountPaid >= item.getPrice()) {
            if(totalAmountPaid > item.getPrice()) {
                getChange(totalAmountPaid - item.getPrice());
            }
           vendingMachine.setVendingMachineState(new DispenseState(vendingMachine, itemCode));
       }
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        List<Coin> coins = vendingMachine.getCoinList();
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return coins;
    }

    @Override
    public Item dispenseItem(VendingMachine vendingMachine, int itemCode) throws Exception {
        throw new Exception("Dispense Item is not possible at this state");
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception {
        throw new Exception("Update inventory is not possible at this state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        System.out.println("Change that needs to be returned : " + returnChangeMoney);
        return returnChangeMoney;
    }
}
