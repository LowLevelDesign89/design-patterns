package com.app.visitor.impl;

import com.app.visitor.RoomElement;
import com.app.visitor.RoomVisitor;

public class RoompricingVisitor implements RoomVisitor {
    @Override
    public void visit(SingleRoom singleRoom) {
        singleRoom.setPrice(100);
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
        doubleRoom.setPrice(200);
    }

    @Override
    public void visit(DeluxeRoom deluxeRoom) {
        deluxeRoom.setPrice(300);
    }
}
