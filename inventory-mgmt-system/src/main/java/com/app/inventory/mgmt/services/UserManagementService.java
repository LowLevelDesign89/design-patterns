package com.app.inventory.mgmt.services;

import com.app.inventory.mgmt.models.dtos.UserCreationRequestDTO;
import com.app.inventory.mgmt.models.entities.Cart;
import com.app.inventory.mgmt.models.entities.User;
import com.app.inventory.mgmt.repositories.UserManagementRepository;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class UserManagementService {
    private UserManagementRepository userManagementRepository;

    public User addUser(UserCreationRequestDTO userCreationRequestDTO) {
        User user = new User();
        user.setName(userCreationRequestDTO.getName());
        user.setEmail(userCreationRequestDTO.getEmail());
        user.setPhoneNumber(userCreationRequestDTO.getPhoneNumber());
        user.setDeliveryAddresses(new ArrayList<>());
        user.getDeliveryAddresses().add(userCreationRequestDTO.getAddress());
        user.setCart(new Cart());
        return userManagementRepository.save(user);
    }
}
