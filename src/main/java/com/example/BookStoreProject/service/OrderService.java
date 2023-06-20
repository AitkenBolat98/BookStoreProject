package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.OrderDtoRequest;
import com.example.BookStoreProject.dto.response.OrderDtoResponse;

import java.security.Principal;
import java.util.List;

public interface OrderService {

    OrderDtoResponse create(List<OrderDtoRequest> requests, Principal principal);
}
