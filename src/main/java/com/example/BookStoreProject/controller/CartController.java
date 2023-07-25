package com.example.BookStoreProject.controller;

import com.example.BookStoreProject.dto.request.CartAddDtoRequest;
import com.example.BookStoreProject.dto.response.CartAddDtoResponse;
import com.example.BookStoreProject.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("api/v1/cart")
@RequiredArgsConstructor
@PreAuthorize("hasRole('USER')")
public class CartController {

    private final CartService cartService;

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('user:create')")
    public ResponseEntity<CartAddDtoResponse> addToCart(@RequestBody @Valid CartAddDtoRequest request, Principal principal){
        return ResponseEntity.ok(cartService.addToCart(request,principal));

    }
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('user:delete')")
    public ResponseEntity<HttpStatus> deleteFromCart(@PathVariable(name = "id") Long bookId,Principal principal){
        cartService.deleteFromCart(bookId,principal);
        return new ResponseEntity(HttpStatus.OK);
    }
}
