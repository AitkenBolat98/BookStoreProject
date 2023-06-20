package com.example.BookStoreProject.controller;

import com.example.BookStoreProject.dto.request.ReviewsDtoRequest;
import com.example.BookStoreProject.dto.response.ReviewsDtoResponse;
import com.example.BookStoreProject.service.ReviewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/books/reviews")
@RequiredArgsConstructor
public class ReviewsController {

    private final ReviewsService reviewsService;
    @PostMapping("/create")
    public ResponseEntity<ReviewsDtoResponse> create(@RequestBody ReviewsDtoRequest request, Principal principal){
        return ResponseEntity.ok(reviewsService.create(request,principal));
    }

}
