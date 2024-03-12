package com.app.pizzashop.decorators.impl;

import com.app.pizzashop.decorators.BasePizza;

public class Margherita extends BasePizza {
    @Override
    public int cost() {
        return 120;
    }
}
