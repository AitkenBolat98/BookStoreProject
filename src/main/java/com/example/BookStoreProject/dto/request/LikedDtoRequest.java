package com.example.BookStoreProject.dto.request;

import com.example.BookStoreProject.module.Books;
import lombok.Data;

@Data
public class LikedDtoRequest {
    private Long bookId;
}
