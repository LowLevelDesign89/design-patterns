package com.app.coupon.impl;

import com.app.coupon.Coupon;
import com.app.coupon.Product;

public class PercentageCouponDecorator extends Coupon {
    protected Product product;
    protected double discountPercentage;

    public PercentageCouponDecorator(Product product, double discountPercentage) {
        this.product = product;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getPrice() {
        return product.getPrice() - (product.getPrice() * discountPercentage) / 100;
    }
}
