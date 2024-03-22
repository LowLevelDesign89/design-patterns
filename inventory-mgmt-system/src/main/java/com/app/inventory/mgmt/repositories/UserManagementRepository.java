package com.app.inventory.mgmt.repositories;

import com.app.inventory.mgmt.models.entities.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserManagementRepository {
    private Map<String, User> users = new HashMap<>();

    public User save(User user) {
        if(user.getId() == null) {
            user.setId(UUID.randomUUID().toString());
        }
        users.put(user.getId(), user);
        return user;
    }

    public User findById(String userId) {
        return users.get(userId);
    }
}
