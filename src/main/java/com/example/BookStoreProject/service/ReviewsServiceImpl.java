package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.reviews.ReviewsCreateDtoRequest;
import com.example.BookStoreProject.dto.request.reviews.ReviewsUpdateDtoRequest;
import com.example.BookStoreProject.dto.response.reviews.ReviewsCreateDtoResponse;
import com.example.BookStoreProject.dto.response.reviews.ReviewsUpdateDtoResponse;
import com.example.BookStoreProject.module.Books;
import com.example.BookStoreProject.module.Reviews;
import com.example.BookStoreProject.module.Users;
import com.example.BookStoreProject.repository.ReviewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;

@Service
@Log4j2
@RequiredArgsConstructor
public class ReviewsServiceImpl implements ReviewsService{

    private final ReviewsRepository reviewsRepository;
    private final BookService bookService;

    private final UserService userService;

    public Reviews save(Reviews review){
        return reviewsRepository.save(review);
    }

    @Override
    public ReviewsCreateDtoResponse create(ReviewsCreateDtoRequest request, Principal principal) {
        Reviews review = new Reviews();
        try {
            String email = principal.getName();
            Users user = userService.getByUserEmail(email).orElseThrow();
            Books book = bookService.getById(request.getBookId()).orElseThrow();
            LocalDateTime createdAt = LocalDateTime.now();
            review.setBook(book);
            review.setUser(user);
            review.setCreatedAt(createdAt);
            review.setDescription(request.getDescription());
            this.save(review);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Review Creation Exception");
        }
        return ReviewsCreateDtoResponse.builder()
                .bookId(review.getBook().getId())
                .description(review.getDescription())
                .build();
    }

    @Override
    public void deleteReview(Long bookId, Principal principal) {
        Users user = userService.getByUserEmail(principal.getName()).orElseThrow();
        Books book = bookService.getById(bookId).orElseThrow();
        try {
            reviewsRepository.deleteReviewById(book.getId(),user.getId());
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("delete review exception");
        }

    }

    @Override
    public ReviewsUpdateDtoResponse update(ReviewsUpdateDtoRequest request, Principal principal) {
        Users user = userService.getByUserEmail(principal.getName()).orElseThrow();
        Books book = bookService.getById(request.getBookId()).orElseThrow();
        Reviews review = reviewsRepository.updateReview(book.getId(),user.getId());
        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            review.setDescription(request.getDescription());
            review.setCreatedAt(localDateTime);
            this.save(review);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Review update exception");
        }
       return ReviewsUpdateDtoResponse.builder()
               .bookId(review.getBook().getId())
               .description(review.getDescription())
               .build();
    }
}
