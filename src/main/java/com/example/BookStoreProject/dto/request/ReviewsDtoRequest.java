package com.example.BookStoreProject.dto.request;

import lombok.Data;

@Data
public class ReviewsDtoRequest {

    private Long bookId;

    private String description;
}
