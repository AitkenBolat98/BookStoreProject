package com.example.BookStoreProject.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewsDtoResponse {

    private String description;
    private Long bookId;
}
