package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.OrderDtoRequest;
import com.example.BookStoreProject.module.Orders;

import java.util.List;

public interface OrderDetailService {

    void create(List<OrderDtoRequest> requests, Orders orders);

    Double totalPrice(List<OrderDtoRequest> requests);
}
