package com.app.inventory.mgmt.repositories;

import com.app.inventory.mgmt.models.entities.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProductRepository {
    private Map<String, Product> products = new HashMap<>();

    public Product save(Product product) {
        if(product.getId() == null) {
            product.setId(UUID.randomUUID().toString());
        }
        products.put(product.getId(), product);
        return product;
    }

    public Product findById(String productId) {
        return products.get(productId);
    }

}
