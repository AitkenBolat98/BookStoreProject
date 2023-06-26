package com.example.BookStoreProject.dto.request.reviews;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewsUpdateDtoRequest {
    private Long bookId;
    private String description;
}
