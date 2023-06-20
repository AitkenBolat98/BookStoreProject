package com.example.BookStoreProject.controller;

import com.example.BookStoreProject.dto.request.OrderDtoRequest;
import com.example.BookStoreProject.dto.response.OrderDtoResponse;
import com.example.BookStoreProject.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<OrderDtoResponse> create(@RequestBody List<OrderDtoRequest> requests, Principal principal){

        return ResponseEntity.ok(orderService.create(requests,principal));
    }
}
