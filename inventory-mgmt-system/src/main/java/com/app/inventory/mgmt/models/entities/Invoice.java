package com.app.inventory.mgmt.models.entities;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Invoice {
    private BigDecimal itemPrice;
    private BigDecimal tax;
    private BigDecimal finalPrice;
}
