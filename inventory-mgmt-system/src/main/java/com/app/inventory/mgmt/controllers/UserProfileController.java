package com.app.inventory.mgmt.controllers;

import com.app.inventory.mgmt.models.dtos.CartItemRequestDTO;
import com.app.inventory.mgmt.models.entities.User;
import com.app.inventory.mgmt.services.UserProfileService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserProfileController {
    private UserProfileService userProfileService;

    public User addOrUpdateItemToCart(CartItemRequestDTO cartItemRequestDTO) {
        return userProfileService.addOrUpdateItemToCart(cartItemRequestDTO);
    }
}
