package com.app.vm;

import com.app.vm.models.*;
import com.app.vm.state.State;

public class VendingMachineTest {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        try {
            System.out.println("|");
            System.out.println("Filling Up the Inventory");
            System.out.println("|");
            fillupInventory(vendingMachine);
            displayInventory(vendingMachine);

            System.out.println("|");
            System.out.println("Clicking on insert coin button");
            System.out.println("|");

            State vendingMachineState = vendingMachine.getVendingMachineState();
            vendingMachineState.clickOnInsertCoinButton(vendingMachine);

            vendingMachineState = vendingMachine.getVendingMachineState();
            vendingMachineState.insertCoin(vendingMachine, Coin.NICKEL);
            vendingMachineState.insertCoin(vendingMachine, Coin.QUARTER);

            System.out.println("|");
            System.out.println("Clicking on ProductSelectionButton");
            System.out.println("|");
            vendingMachineState.clickOnStartProductSelectionButton(vendingMachine);

            vendingMachineState = vendingMachine.getVendingMachineState();
            vendingMachineState.selectProduct(vendingMachine, 102);

            displayInventory(vendingMachine);

        } catch (Exception exception) {
            displayInventory(vendingMachine);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine) {
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for(int i = 0; i < slots.length; i++) {
            System.out.println("CodeNumber: " + slots[i].getItemCode() +
                    " Item: " + slots[i].getItem().getItemType().name() +
                    " Price: " + slots[i].getItem().getPrice() +
                    " Available: " + !slots[i].isSoldOut());
        }
    }

    private static void fillupInventory(VendingMachine vendingMachine) {
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for(int i = 0; i < slots.length; i++) {
            Item newItem = new Item();
            if(i >= 0 && i < 3) {
                newItem.setItemType(ItemType.COKE);
                newItem.setPrice(12);
            } else if(i >= 3 && i < 5) {
                newItem.setItemType(ItemType.PEPSI);
                newItem.setPrice(9);
            } else if(i >= 5 && i < 7) {
                newItem.setItemType(ItemType.JUICE);
                newItem.setPrice(13);
            } else if(i >= 7 && i < 10) {
                newItem.setItemType(ItemType.SODA);
                newItem.setPrice(7);
            }
            slots[i].setItem(newItem);
            slots[i].setSoldOut(false);
        }
    }
}
