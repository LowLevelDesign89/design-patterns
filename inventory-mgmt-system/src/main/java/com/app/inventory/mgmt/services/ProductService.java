package com.app.inventory.mgmt.services;

import com.app.inventory.mgmt.models.dtos.ProductRequestDTO;
import com.app.inventory.mgmt.models.entities.Product;
import com.app.inventory.mgmt.models.entities.ProductCategory;
import com.app.inventory.mgmt.models.entities.Warehouse;
import com.app.inventory.mgmt.repositories.ProductCategoryRepository;
import com.app.inventory.mgmt.repositories.ProductRepository;
import com.app.inventory.mgmt.repositories.WarehouseRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;
    private ProductCategoryRepository productCategoryRepository;
    private InventoryService inventoryService;

    public Product addProduct(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        ProductCategory productCategory = productRequestDTO.getProductCategory();
        if(productCategory.getId() == null) {
            productCategory = productCategoryRepository.save(productCategory);
        }

        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setProductCategory(productCategory);
        Product createdProduct = productRepository.save(product);

        inventoryService.updateInventory(createdProduct, productRequestDTO.getWareHouseId(),
                productRequestDTO.getQuantity());
        return createdProduct;
    }

}
