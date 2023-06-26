package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.CartAddDtoRequest;
import com.example.BookStoreProject.dto.response.CartAddDtoResponse;
import org.springframework.security.core.parameters.P;

import java.security.Principal;

public interface CartService {

    CartAddDtoResponse addToCart(CartAddDtoRequest request, Principal principal);
    void deleteFromCart(Long bookId, Principal principal);
}
