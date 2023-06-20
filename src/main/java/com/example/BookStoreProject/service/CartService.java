package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.CartAddDtoRequest;
import com.example.BookStoreProject.dto.response.CartAddDtoResponse;

import java.security.Principal;

public interface CartService {

    CartAddDtoResponse addToCart(CartAddDtoRequest request, Principal principal);
}
