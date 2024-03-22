package com.app.inventory.mgmt.controllers;

import com.app.inventory.mgmt.models.dtos.ProductRequestDTO;
import com.app.inventory.mgmt.models.entities.Product;
import com.app.inventory.mgmt.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    public Product addProduct(ProductRequestDTO productRequestDTO) {
        return productService.addProduct(productRequestDTO);
    }
}
