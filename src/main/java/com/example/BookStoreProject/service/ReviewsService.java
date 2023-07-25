package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.reviews.ReviewsCreateDtoRequest;
import com.example.BookStoreProject.dto.request.reviews.ReviewsUpdateDtoRequest;
import com.example.BookStoreProject.dto.response.reviews.ReviewsCreateDtoResponse;
import com.example.BookStoreProject.dto.response.reviews.ReviewsUpdateDtoResponse;

import java.security.Principal;

public interface ReviewsService {

    ReviewsCreateDtoResponse create(ReviewsCreateDtoRequest request, Principal principal);

    void deleteReview(Long bookId,Principal principal);
    ReviewsUpdateDtoResponse update(ReviewsUpdateDtoRequest request,Principal principal);
}
