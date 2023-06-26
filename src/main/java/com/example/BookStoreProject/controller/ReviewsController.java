package com.example.BookStoreProject.controller;

import com.example.BookStoreProject.dto.request.reviews.ReviewsCreateDtoRequest;
import com.example.BookStoreProject.dto.request.reviews.ReviewsUpdateDtoRequest;
import com.example.BookStoreProject.dto.response.reviews.ReviewsCreateDtoResponse;
import com.example.BookStoreProject.dto.response.reviews.ReviewsUpdateDtoResponse;
import com.example.BookStoreProject.service.ReviewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/books/reviews")
@RequiredArgsConstructor
public class ReviewsController {

    private final ReviewsService reviewsService;
    @PostMapping("/create")
    public ResponseEntity<ReviewsCreateDtoResponse> createReview(@RequestBody ReviewsCreateDtoRequest request, Principal principal){
        return ResponseEntity.ok(reviewsService.create(request,principal));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteReview(@PathVariable(name = "id") Long bookId,Principal principal){
        reviewsService.deleteReview(bookId,principal);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<ReviewsUpdateDtoResponse> updateReview(@RequestBody ReviewsUpdateDtoRequest request,Principal principal){
        return ResponseEntity.ok(reviewsService.update(request,principal));
    }

}
