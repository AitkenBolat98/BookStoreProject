package com.example.BookStoreProject.dto.response.reviews;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ReviewsUpdateDtoResponse {
    private Long bookId;
    private String description;
}
