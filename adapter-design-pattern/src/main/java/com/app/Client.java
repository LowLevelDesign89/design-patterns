package com.app;

import com.app.adaptee.WeightMachine;
import com.app.adaptee.WeightMachineForBabies;
import com.app.adapter.WeightMachineAdapter;
import com.app.adapter.WeightMachineAdapterImpl;

public class Client {
    public static void main(String[] args) {
        WeightMachine weightMachine = new WeightMachineForBabies();
        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(weightMachine);

        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}
