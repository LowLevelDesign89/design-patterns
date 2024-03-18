package com.app.vm.state;

import com.app.vm.models.Coin;
import com.app.vm.models.Item;
import com.app.vm.models.VendingMachine;

import java.util.List;

public interface State {
    void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception;
    void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception;
    void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception;
    void selectProduct(VendingMachine vendingMachine, int itemCode) throws Exception;
    List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception;
    Item dispenseItem(VendingMachine vendingMachine, int itemCode) throws Exception;
    void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception;
    int getChange(int returnChangeMoney) throws Exception;
}
