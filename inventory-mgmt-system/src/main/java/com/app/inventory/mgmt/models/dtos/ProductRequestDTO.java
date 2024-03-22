package com.app.inventory.mgmt.models.dtos;

import com.app.inventory.mgmt.models.entities.ProductCategory;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequestDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private ProductCategory productCategory;
    private String wareHouseId;
    private Integer quantity;
}
