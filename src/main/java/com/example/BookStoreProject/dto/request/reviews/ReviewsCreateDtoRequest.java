package com.example.BookStoreProject.dto.request.reviews;

import lombok.Data;

@Data
public class ReviewsCreateDtoRequest {

    private Long bookId;

    private String description;
}
