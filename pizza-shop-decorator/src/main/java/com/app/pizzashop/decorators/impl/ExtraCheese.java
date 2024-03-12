package com.app.pizzashop.decorators.impl;

import com.app.pizzashop.decorators.BasePizza;
import com.app.pizzashop.decorators.ToppingDecorator;

public class ExtraCheese extends ToppingDecorator {
    BasePizza basePizza;

    public ExtraCheese(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 10;
    }
}
