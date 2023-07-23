package com.example.BookStoreProject.dto.request.manager.book;

import lombok.Getter;

@Getter
public class BookUpdateLanguageDtoRequest {
    private Long bookId;
    private String newLanguage;
}
