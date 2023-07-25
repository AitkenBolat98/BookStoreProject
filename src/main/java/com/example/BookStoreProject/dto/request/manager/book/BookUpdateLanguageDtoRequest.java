package com.example.BookStoreProject.dto.request.manager.book;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class BookUpdateLanguageDtoRequest {
    @NotBlank(message = "the book ID field can not be blank")
    private Long bookId;
    @NotBlank(message = "the new language field can not be blank")
    private String newLanguage;
}
