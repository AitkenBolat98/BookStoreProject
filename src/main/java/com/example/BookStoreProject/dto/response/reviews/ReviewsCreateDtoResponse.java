package com.example.BookStoreProject.dto.response.reviews;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewsCreateDtoResponse {

    private String description;
    private Long bookId;
}
