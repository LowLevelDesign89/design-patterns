package com.app.inventory.mgmt.models.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Warehouse {
    private String id;
    private String name;
    private Address address;
}
