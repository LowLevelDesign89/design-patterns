package com.app.bridge.impl;

import com.app.bridge.BreatheImplementor;

public class WaterBreatheImplementor implements BreatheImplementor {
    @Override
    public void breath() {
        System.out.println("Breathe through GILLs");
        System.out.println("Absorb oxygen from water");
        System.out.println("Release Carbon Di-Oxide");
    }
}
