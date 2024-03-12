package com.app.pizzashop.decorators.impl;

import com.app.pizzashop.decorators.BasePizza;

public class Farmhouse extends BasePizza {
    @Override
    public int cost() {
        return 200;
    }
}
