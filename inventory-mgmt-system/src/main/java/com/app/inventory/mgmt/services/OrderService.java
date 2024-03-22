package com.app.inventory.mgmt.services;

import com.app.inventory.mgmt.models.dtos.OrderRequestDTO;
import com.app.inventory.mgmt.models.entities.*;
import com.app.inventory.mgmt.models.enums.OrderStatus;
import com.app.inventory.mgmt.repositories.OrderRepository;
import com.app.inventory.mgmt.repositories.UserManagementRepository;
import com.app.inventory.mgmt.repositories.WarehouseRepository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class OrderService {
    private UserManagementRepository userManagementRepository;
    private WarehouseRepository warehouseRepository;

    private OrderRepository orderRepository;
    private PaymentService paymentService;

    private UserProfileService userProfileService;

    private static final BigDecimal tax = BigDecimal.valueOf(0.18);
    public Order createOrder(OrderRequestDTO orderRequestDTO) {
        Order order = new Order();
        User user = userManagementRepository.findById(orderRequestDTO.getUserId());
        Map<Product, Integer> cartMap = user.getCart().getCartItems();
        BigDecimal totalPrice = calculateTotalPrice(cartMap);
        BigDecimal finalPrice = totalPrice.add(totalPrice.multiply(tax));
        Invoice invoice = new Invoice();
        invoice.setItemPrice(totalPrice);
        invoice.setTax(tax);
        invoice.setFinalPrice(finalPrice);

        Warehouse warehouse = warehouseRepository.findById(orderRequestDTO.getWarehouseId());

        order.setUser(user);
        order.setCartMap(cartMap);
        order.setInvoice(invoice);
        order.setOrderStatus(OrderStatus.INITIATED);
        order.setWarehouse(warehouse);
        order.setAddress(orderRequestDTO.getAddress());
        orderRepository.save(order);

        try {
            Payment payment = paymentService.initiatePayment(orderRequestDTO);
            order.setPayment(payment);
            order.setOrderStatus(OrderStatus.ORDERED);
            orderRepository.save(order);
            userProfileService.emptyCart(user);
        } catch (Exception exception) {
            order.setOrderStatus(OrderStatus.FAILED);
            orderRepository.save(order);
        }

        return order;
    }

    private BigDecimal calculateTotalPrice(Map<Product, Integer> cartMap) {
        BigDecimal finalPrice = BigDecimal.ZERO;
        for(Map.Entry<Product, Integer> entry: cartMap.entrySet()) {
            BigDecimal currentPrice = entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue()));
            finalPrice = finalPrice.add(currentPrice);
        }
        return finalPrice;
    }
}
