package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.ReviewsDtoRequest;
import com.example.BookStoreProject.dto.response.ReviewsDtoResponse;
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
    public ReviewsDtoResponse create(ReviewsDtoRequest request, Principal principal) {
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
        return ReviewsDtoResponse.builder()
                .bookId(review.getBook().getId())
                .description(review.getDescription())
                .build();
    }
}
