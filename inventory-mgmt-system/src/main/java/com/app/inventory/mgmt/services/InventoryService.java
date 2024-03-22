package com.app.inventory.mgmt.services;

import com.app.inventory.mgmt.models.entities.Inventory;
import com.app.inventory.mgmt.models.entities.Product;
import com.app.inventory.mgmt.models.entities.Warehouse;
import com.app.inventory.mgmt.repositories.WarehouseRepository;

public class InventoryService {
    private WarehouseRepository warehouseRepository;

    public void updateInventory(Product product, String warehouseId, Integer quantity) {
        Warehouse warehouse = warehouseRepository.findById(warehouseId);
        Inventory inventory = warehouseRepository.findByWarehouse(warehouse);
        inventory.updateProductCategoryMap(product);
        inventory.updateProductQuantityMap(product, quantity);
        warehouseRepository.updateInventory(warehouse, inventory);
    }
}
