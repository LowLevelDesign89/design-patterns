package com.app.coupon;

import com.app.coupon.impl.Item1;
import com.app.coupon.impl.Item2;

public class Client {
    public static void main(String[] args) {
        Item1 item1 = new Item1("FAN", 200, ProductType.ELECTRONIC_GOODS);
        Item2  item2 = new Item2("SOFA", 400, ProductType.FURNITURE_GOODS);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProductToCart(item1);
        shoppingCart.addProductToCart(item2);

        double finalPrice = shoppingCart.getTotalPrice();

        System.out.println("Final Price - " + finalPrice);
    }
}
