package com.example.BookStoreProject.dto.request.manager.book;

import lombok.Getter;

@Getter
public class BookUpdateDescriptionDtoRequest {
    private Long bookId;
    private String newDescription;
}
