package com.app.visitor;

import com.app.visitor.impl.DeluxeRoom;
import com.app.visitor.impl.DoubleRoom;
import com.app.visitor.impl.SingleRoom;

public interface RoomVisitor {
    void visit(SingleRoom singleRoom);
    void visit(DoubleRoom doubleRoom);
    void visit(DeluxeRoom deluxeRoom);
}
