package com.app.visitor.impl;

import com.app.visitor.RoomElement;
import com.app.visitor.RoomVisitor;

public class DeluxeRoom implements RoomElement {
    private double price = 0;

    @Override
    public void accept(RoomVisitor roomVisitor) {
        roomVisitor.visit(this);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
