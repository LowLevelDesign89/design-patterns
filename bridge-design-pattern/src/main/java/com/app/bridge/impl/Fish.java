package com.app.bridge.impl;

import com.app.bridge.BreatheImplementor;
import com.app.bridge.LivingThings;

public class Fish extends LivingThings {
    private BreatheImplementor breatheImplementor;

    public Fish(BreatheImplementor breatheImplementor) {
        super(breatheImplementor);
    }

    @Override
    public void breatheProcess() {
        super.breatheProcess();
    }
}
