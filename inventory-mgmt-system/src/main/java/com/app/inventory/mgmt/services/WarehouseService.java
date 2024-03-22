package com.app.inventory.mgmt.services;

import com.app.inventory.mgmt.models.entities.Warehouse;
import com.app.inventory.mgmt.repositories.WarehouseRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WarehouseService {
    private WarehouseRepository warehouseRepository;
    public Warehouse createWarehouse(Warehouse warehouse) {
        return warehouseRepository.createWareHouse(warehouse);
    }
}
