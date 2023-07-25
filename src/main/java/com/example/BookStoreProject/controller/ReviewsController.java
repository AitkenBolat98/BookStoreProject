package com.example.BookStoreProject.controller;

import com.example.BookStoreProject.dto.request.reviews.ReviewsCreateDtoRequest;
import com.example.BookStoreProject.dto.request.reviews.ReviewsUpdateDtoRequest;
import com.example.BookStoreProject.dto.response.reviews.ReviewsCreateDtoResponse;
import com.example.BookStoreProject.dto.response.reviews.ReviewsUpdateDtoResponse;
import com.example.BookStoreProject.service.ReviewsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/books/reviews")
@RequiredArgsConstructor
@PreAuthorize("hasRole('USER')")
public class ReviewsController {

    private final ReviewsService reviewsService;
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('user:create')")
    public ResponseEntity<ReviewsCreateDtoResponse> createReview(@RequestBody @Valid ReviewsCreateDtoRequest request, Principal principal){
        return ResponseEntity.ok(reviewsService.create(request,principal));
    }
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('user:delete')")
    public ResponseEntity<HttpStatus> deleteReview(@PathVariable(name = "id") Long bookId,Principal principal){
        reviewsService.deleteReview(bookId,principal);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('user:update')")
    public ResponseEntity<ReviewsUpdateDtoResponse> updateReview(@RequestBody @Valid ReviewsUpdateDtoRequest request,Principal principal){
        return ResponseEntity.ok(reviewsService.update(request,principal));
    }

}
