package com.app.inventory.mgmt.repositories;

import com.app.inventory.mgmt.models.entities.Order;
import com.app.inventory.mgmt.models.enums.OrderStatus;

import java.util.*;

public class OrderRepository {
    private Map<String, Order> orders = new HashMap<>();
    private Map<String, List<Order>> userToOrdersMap = new HashMap<>();

    public Order save(Order order) {
        if(order.getId() == null) {
            order.setId(UUID.randomUUID().toString());
        }
        orders.put(order.getId(), order);
        if(order.getOrderStatus() == OrderStatus.ORDERED) {
            String userId = order.getUser().getId();
            if(!userToOrdersMap.containsKey(userId)) {
                userToOrdersMap.put(userId, new ArrayList<>());
            }
            userToOrdersMap.get(userId).add(order);
        }
        return order;
    }
}
