package com.app.inventory.mgmt.controllers;

import com.app.inventory.mgmt.models.entities.Warehouse;
import com.app.inventory.mgmt.services.WarehouseService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WarehouseController {
    private WarehouseService warehouseService;
    public Warehouse createWarehouse(Warehouse warehouse) {
        return warehouseService.createWarehouse(warehouse);
    }
}
