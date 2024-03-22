package com.app.inventory.mgmt.models.dtos;

import com.app.inventory.mgmt.models.entities.Address;
import com.app.inventory.mgmt.models.enums.PaymentMethod;
import lombok.Data;

@Data
public class OrderRequestDTO {
    private String userId;
    private String warehouseId;
    private PaymentMethod paymentMethod;
    private Address address;
    private String paymentAccountId;
}
