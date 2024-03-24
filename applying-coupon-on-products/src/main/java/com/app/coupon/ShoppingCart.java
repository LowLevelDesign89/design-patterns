package com.app.coupon;

import com.app.coupon.impl.PercentageCouponDecorator;
import com.app.coupon.impl.TypeCouponDecorator;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> productList;

    public ShoppingCart() {
        productList = new ArrayList<>();
    }

    public void addProductToCart(Product product) {
        Product finalProduct = new TypeCouponDecorator(
                new PercentageCouponDecorator(product, 10),
                3,
                product.getProductType());
        productList.add(finalProduct);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for(Product product: productList) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
