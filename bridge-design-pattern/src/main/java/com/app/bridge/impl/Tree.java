package com.app.bridge.impl;

import com.app.bridge.BreatheImplementor;
import com.app.bridge.LivingThings;

public class Tree extends LivingThings {
    private BreatheImplementor breatheImplementor;

    public Tree(BreatheImplementor breatheImplementor) {
        super(breatheImplementor);
    }

    @Override
    public void breatheProcess() {
        super.breatheProcess();
    }
}
