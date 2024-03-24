package com.app.coupon.impl;

import com.app.coupon.Coupon;
import com.app.coupon.Product;
import com.app.coupon.ProductType;

import java.util.ArrayList;
import java.util.List;

public class TypeCouponDecorator extends Coupon {
    protected Product product;
    protected double discountPercentage;
    protected ProductType productType;
    static List<ProductType> productTypeList = new ArrayList<>();

    static {
        productTypeList.add(ProductType.ELECTRONIC_GOODS);
        productTypeList.add(ProductType.FURNITURE_GOODS);
    }

    public TypeCouponDecorator(Product product, double discountPercentage, ProductType productType) {
        this.product = product;
        this.discountPercentage = discountPercentage;
        this.productType = productType;
    }

    @Override
    public double getPrice() {
        double finalPrice = product.getPrice();
        if(productTypeList.contains(product.getProductType())) {
            finalPrice = finalPrice - (finalPrice * discountPercentage) / 100;
        }
        return finalPrice;
    }
}
