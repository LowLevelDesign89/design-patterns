package com.app.inventory.mgmt.services;

import com.app.inventory.mgmt.models.dtos.CartItemRequestDTO;
import com.app.inventory.mgmt.models.entities.Product;
import com.app.inventory.mgmt.models.entities.User;
import com.app.inventory.mgmt.repositories.ProductRepository;
import com.app.inventory.mgmt.repositories.UserManagementRepository;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class UserProfileService {
    private UserManagementRepository userManagementRepository;
    private ProductRepository productRepository;
    public User addOrUpdateItemToCart(CartItemRequestDTO cartItemRequestDTO) {
        User user = userManagementRepository.findById(cartItemRequestDTO.getUserId());
        Product product = productRepository.findById(cartItemRequestDTO.getProductId());
        Map<Product, Integer> cartItem = user.getCart().getCartItems();
        cartItem.put(product, cartItemRequestDTO.getQuantity());
        user.getCart().setCartItems(cartItem);
        return userManagementRepository.save(user);
    }

    public User emptyCart(User user) {
        user.getCart().setCartItems(new HashMap<>());
        userManagementRepository.save(user);
        return user;
    }
}

