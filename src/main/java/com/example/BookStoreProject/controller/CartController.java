package com.example.BookStoreProject.controller;

import com.example.BookStoreProject.dto.request.CartAddDtoRequest;
import com.example.BookStoreProject.dto.response.CartAddDtoResponse;
import com.example.BookStoreProject.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<CartAddDtoResponse> addToCart(@RequestBody CartAddDtoRequest request,Principal principal){
        return ResponseEntity.ok(cartService.addToCart(request,principal));

    }
}
