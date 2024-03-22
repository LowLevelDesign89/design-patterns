package com.app.inventory.mgmt.models.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode
public class Product {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private ProductCategory productCategory;
}
