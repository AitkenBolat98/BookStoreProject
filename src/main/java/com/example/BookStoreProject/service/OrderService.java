package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.orders.OrderCreationDtoRequest;
import com.example.BookStoreProject.dto.response.orders.OrderCreationDtoResponse;
import com.example.BookStoreProject.module.Orders;

import java.security.Principal;
import java.util.List;

public interface OrderService {

    OrderCreationDtoResponse create(List<OrderCreationDtoRequest> requests, Principal principal);

}
