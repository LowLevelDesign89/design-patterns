package com.app.inventory.mgmt.repositories;

import com.app.inventory.mgmt.models.entities.ProductCategory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProductCategoryRepository {
    private Map<String, ProductCategory> productCategories = new HashMap<>();

    public ProductCategory save(ProductCategory productCategory) {
        if(productCategory.getId() == null) {
            productCategory.setId(UUID.randomUUID().toString());
        }
        productCategories.put(productCategory.getId(), productCategory);
        return productCategory;
    }
}
