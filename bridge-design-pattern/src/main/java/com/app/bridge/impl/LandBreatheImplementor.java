package com.app.bridge.impl;

import com.app.bridge.BreatheImplementor;

public class LandBreatheImplementor implements BreatheImplementor {
    @Override
    public void breath() {
        System.out.println("Breathe through nose");
        System.out.println("Inhale oxygen");
        System.out.println("Release Carbob Di-Oxide");
    }
}
