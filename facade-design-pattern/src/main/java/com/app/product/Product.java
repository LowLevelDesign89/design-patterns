package com.app.product;

import java.math.BigDecimal;

public class Product {
    private int id;
    private String name;
    private String description;
    private BigDecimal price;

    public Product() {
        this.id = 121;
        this.name = "IPhone";
        this.description = "Best IPhone ever";
        this.price = BigDecimal.valueOf(100);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
