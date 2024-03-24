package com.app.visitor.impl;

import com.app.visitor.RoomVisitor;

public class RoomMaintenanceVisitor implements RoomVisitor {
    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println("Doing cleaning for single room");
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
        System.out.println("Doing cleaning for double room");
    }

    @Override
    public void visit(DeluxeRoom deluxeRoom) {
        System.out.println("Doing cleaning for deluxe room");
    }
}
