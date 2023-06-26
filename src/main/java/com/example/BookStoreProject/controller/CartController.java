package com.example.BookStoreProject.controller;

import com.example.BookStoreProject.dto.request.CartAddDtoRequest;
import com.example.BookStoreProject.dto.response.CartAddDtoResponse;
import com.example.BookStoreProject.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFromCart(@PathVariable(name = "id") Long bookId,Principal principal){
        cartService.deleteFromCart(bookId,principal);
        return new ResponseEntity(HttpStatus.OK);
    }
}
