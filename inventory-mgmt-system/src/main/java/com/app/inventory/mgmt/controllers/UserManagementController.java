package com.app.inventory.mgmt.controllers;

import com.app.inventory.mgmt.models.dtos.UserCreationRequestDTO;
import com.app.inventory.mgmt.models.entities.User;
import com.app.inventory.mgmt.services.UserManagementService;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserManagementController {
    private UserManagementService userManagementService;

    public User addUser(UserCreationRequestDTO userCreationRequestDTO) {
        return userManagementService.addUser(userCreationRequestDTO);
    }
}
