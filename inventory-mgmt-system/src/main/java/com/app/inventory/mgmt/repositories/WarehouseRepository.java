package com.app.inventory.mgmt.repositories;

import com.app.inventory.mgmt.models.entities.Inventory;
import com.app.inventory.mgmt.models.entities.Warehouse;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class WarehouseRepository {
    private Map<Warehouse, Inventory> inventoryMap = new HashMap<>();
    private Map<String, Warehouse> warehouseMap = new HashMap<>();

    public Warehouse createWareHouse(Warehouse warehouse) {
        warehouse.setId(UUID.randomUUID().toString());
        warehouseMap.put(warehouse.getId(), warehouse);
        inventoryMap.put(warehouse, new Inventory());
        return warehouse;
    }

    public Warehouse findById(String wareHouseId) {
        return warehouseMap.get(wareHouseId);
    }

    public Inventory findByWarehouse(Warehouse warehouse) {
        return inventoryMap.get(warehouse);
    }

    public Inventory updateInventory(Warehouse warehouse, Inventory inventory) {
        inventoryMap.put(warehouse, inventory);
        return inventory;
    }

}
