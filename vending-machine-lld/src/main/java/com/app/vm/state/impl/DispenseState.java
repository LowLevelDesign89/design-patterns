package com.app.vm.state.impl;

import com.app.vm.models.Coin;
import com.app.vm.models.Item;
import com.app.vm.models.VendingMachine;
import com.app.vm.state.State;

import java.util.List;

public class DispenseState implements State {
    public DispenseState(VendingMachine vendingMachine, int codeNumber) throws Exception {
        System.out.println("Currently the vending machine is in Dispense State");
        dispenseItem(vendingMachine, codeNumber);
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("You can't click on Insert Coin button at this stage");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("You can't click on start product selection at this stage");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("You can't insert coin at this stage");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int itemCode) throws Exception {
        throw new Exception("You can't select product at this stage");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        throw new Exception("You can't refund full money at this stage");
    }

    @Override
    public Item dispenseItem(VendingMachine vendingMachine, int itemCode) throws Exception {
        Item item = vendingMachine.getInventory().getItem(itemCode);
        vendingMachine.getInventory().updateSoldOutItem(itemCode);
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return item;
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception {
        throw new Exception("You can't update inventory at this stage");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("You can't get change at this stage");
    }
}
