package com.app.inventory.mgmt.models.entities;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Inventory {
    private Map<Product, Integer> productQuantityMap = new HashMap<>();
    private Map<ProductCategory, List<Product>> productCategoryMap = new HashMap<>();

    public void updateProductQuantityMap(Product product, Integer quantity) {

    }

    public void updateProductCategoryMap(Product product) {

    }
}
