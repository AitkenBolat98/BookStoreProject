package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.orders.OrderCreationDtoRequest;
import com.example.BookStoreProject.dto.response.orders.OrderCreationDtoResponse;
import com.example.BookStoreProject.module.Orders;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

public interface OrderService {

    OrderCreationDtoResponse createOrder(List<OrderCreationDtoRequest> requests, Principal principal);
    void deleteOrder(Long orderId,Principal principal);
    Optional<Orders> getById(Long id);

}
