package com.app.bridge;

import com.app.bridge.impl.Fish;
import com.app.bridge.impl.Tree;
import com.app.bridge.impl.TreeBreatheImplementor;
import com.app.bridge.impl.WaterBreatheImplementor;

public class Client {
    public static void main(String[] args) {
        LivingThings tree = new Tree(new TreeBreatheImplementor());
        tree.breatheProcess();

        LivingThings fish = new Fish(new WaterBreatheImplementor());
        fish.breatheProcess();
    }
}
