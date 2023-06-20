package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.ReviewsDtoRequest;
import com.example.BookStoreProject.dto.response.ReviewsDtoResponse;

import java.security.Principal;

public interface ReviewsService {

    ReviewsDtoResponse create(ReviewsDtoRequest request, Principal principal);
}
