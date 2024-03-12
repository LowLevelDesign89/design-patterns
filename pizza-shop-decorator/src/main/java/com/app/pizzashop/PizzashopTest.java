package com.app.pizzashop;

import com.app.pizzashop.decorators.BasePizza;
import com.app.pizzashop.decorators.impl.ExtraCheese;
import com.app.pizzashop.decorators.impl.Farmhouse;
import com.app.pizzashop.decorators.impl.Jalapeno;

public class PizzashopTest {
    public static void main(String[] args) {
        BasePizza pizza = new Jalapeno(new ExtraCheese(new Farmhouse()));

        System.out.println(pizza.cost());

    }
}
