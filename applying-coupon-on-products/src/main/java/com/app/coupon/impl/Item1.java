package com.app.coupon.impl;

import com.app.coupon.Product;
import com.app.coupon.ProductType;

public class Item1 extends Product {
    public Item1(String name, double price, ProductType productType) {
        super(name, price, productType);
    }

    @Override
    public double getPrice() {
        return price;
    }
}
