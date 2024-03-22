package com.app.inventory.mgmt.models.dtos;

import com.app.inventory.mgmt.models.entities.Address;
import lombok.Data;

@Data
public class UserCreationRequestDTO {
    private String name;
    private String email;
    private String phoneNumber;
    private Address address;
}
