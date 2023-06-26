package com.example.BookStoreProject.controller;

import com.example.BookStoreProject.dto.request.orders.OrderCreationDtoRequest;
import com.example.BookStoreProject.dto.response.orders.OrderCreationDtoResponse;
import com.example.BookStoreProject.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/v1/cart/")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<OrderCreationDtoResponse> create(@RequestBody List<OrderCreationDtoRequest> requests, Principal principal){

        return ResponseEntity.ok(orderService.create(requests,principal));
    }
}
