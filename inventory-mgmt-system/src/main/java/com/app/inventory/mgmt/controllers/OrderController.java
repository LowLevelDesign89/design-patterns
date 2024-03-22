package com.app.inventory.mgmt.controllers;

import com.app.inventory.mgmt.models.dtos.OrderRequestDTO;
import com.app.inventory.mgmt.models.entities.Order;
import com.app.inventory.mgmt.services.OrderService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderController {
    private OrderService orderService;

    public Order createOrder(OrderRequestDTO orderRequestDTO) {
        return orderService.createOrder(orderRequestDTO);
    }
}
