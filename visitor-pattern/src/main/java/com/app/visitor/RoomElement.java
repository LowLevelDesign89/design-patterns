package com.app.visitor;

public interface RoomElement {
    void accept(RoomVisitor roomVisitor);
}
