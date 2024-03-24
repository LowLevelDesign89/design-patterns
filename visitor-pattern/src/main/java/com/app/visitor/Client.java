package com.app.visitor;

import com.app.visitor.impl.*;

public class Client {
    public static void main(String[] args) {
        RoomElement singleRoom = new SingleRoom();
        RoomElement doubleRoom = new DoubleRoom();
        RoomElement deluxeRoom = new DeluxeRoom();

        RoompricingVisitor roompricingVisitor = new RoompricingVisitor();
        singleRoom.accept(roompricingVisitor);
        doubleRoom.accept(roompricingVisitor);
        deluxeRoom.accept(roompricingVisitor);

        System.out.println("Single room price : " + ((SingleRoom)singleRoom).getPrice());
        System.out.println("Double room price : " + ((DoubleRoom)doubleRoom).getPrice());
        System.out.println("Deluxe room price : " + ((DeluxeRoom)deluxeRoom).getPrice());

        RoomMaintenanceVisitor roomMaintenanceVisitor = new RoomMaintenanceVisitor();
        singleRoom.accept(roomMaintenanceVisitor);
        doubleRoom.accept(roomMaintenanceVisitor);
        deluxeRoom.accept(roomMaintenanceVisitor);

    }
}
