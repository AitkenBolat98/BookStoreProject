package com.example.BookStoreProject.dto.request.manager.book;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class BookUpdateTitleDtoRequest {
    @NotBlank(message = "the book ID field can not be blank")
    private Long bookId;
    @NotBlank(message = "the new title field can not be blank")
    private String newTitle;
}
