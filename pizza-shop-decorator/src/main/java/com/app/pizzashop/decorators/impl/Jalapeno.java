package com.app.pizzashop.decorators.impl;

import com.app.pizzashop.decorators.BasePizza;
import com.app.pizzashop.decorators.ToppingDecorator;

public class Jalapeno extends ToppingDecorator {
    BasePizza basePizza;

    public Jalapeno(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 20;
    }
}
