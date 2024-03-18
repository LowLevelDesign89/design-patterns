package com.app.vm.models;

import com.app.vm.models.Coin;
import com.app.vm.models.Inventory;
import com.app.vm.state.State;
import com.app.vm.state.impl.IdleState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    State vendingMachineState;
    Inventory inventory;
    List<Coin> coinList;

    public VendingMachine() {
        vendingMachineState = new IdleState();
        inventory = new Inventory(10);
        coinList = new ArrayList<>();
    }
    public State getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(State vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }
}
