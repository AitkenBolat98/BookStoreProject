package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.orders.OrderCreationDtoRequest;
import com.example.BookStoreProject.module.Orders;

import java.util.List;

public interface OrderDetailService {

    void create(List<OrderCreationDtoRequest> requests, Orders orders);

    Double totalPrice(List<OrderCreationDtoRequest> requests);
}
