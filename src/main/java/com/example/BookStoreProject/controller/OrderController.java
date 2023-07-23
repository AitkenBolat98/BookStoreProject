package com.example.BookStoreProject.controller;

import com.example.BookStoreProject.dto.request.orders.OrderCreationDtoRequest;
import com.example.BookStoreProject.dto.response.orders.OrderCreationDtoResponse;
import com.example.BookStoreProject.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/v1/cart")
@RequiredArgsConstructor
@PreAuthorize("hasRole('USER')")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order/create")
    @PreAuthorize("hasAuthority('user:create')")
    public ResponseEntity<OrderCreationDtoResponse> createOrder(@RequestBody List<OrderCreationDtoRequest> requests, Principal principal){

        return ResponseEntity.ok(orderService.createOrder(requests,principal));
    }

    @DeleteMapping("/order/delete/{id}")
    @PreAuthorize("hasAuthority('user:delete')")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable(name = "id") Long orderId,Principal principal){
        orderService.deleteOrder(orderId,principal);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
