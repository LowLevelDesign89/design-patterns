package com.app.inventory.mgmt.models.dtos;

import lombok.Data;

@Data
public class CartItemRequestDTO {
    private String userId;
    private String productId;
    private Integer quantity;
}
