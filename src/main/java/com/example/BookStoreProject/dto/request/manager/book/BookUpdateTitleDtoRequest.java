package com.example.BookStoreProject.dto.request.manager.book;

import lombok.Getter;
import lombok.extern.java.Log;

@Getter
public class BookUpdateTitleDtoRequest {
    private Long bookId;
    private String newTitle;
}