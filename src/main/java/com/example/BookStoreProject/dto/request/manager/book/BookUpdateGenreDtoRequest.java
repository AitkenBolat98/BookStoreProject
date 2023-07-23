package com.example.BookStoreProject.dto.request.manager.book;

import lombok.Getter;

@Getter
public class BookUpdateGenreDtoRequest {
    private Long bookId;
    private String newGenre;
}
