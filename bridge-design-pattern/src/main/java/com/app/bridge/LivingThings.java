package com.app.bridge;

public abstract class LivingThings {
    private BreatheImplementor breatheImplementor;

    public LivingThings(BreatheImplementor breatheImplementor) {
        this.breatheImplementor = breatheImplementor;
    }

    public void breatheProcess() {
        breatheImplementor.breath();
    }
}
