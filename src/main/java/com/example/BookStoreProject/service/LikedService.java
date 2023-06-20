package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.LikedDtoRequest;
import com.example.BookStoreProject.dto.response.LikedDtoResponse;

import java.security.Principal;

public interface LikedService {

    LikedDtoResponse liked(LikedDtoRequest request, Principal principal);
}
