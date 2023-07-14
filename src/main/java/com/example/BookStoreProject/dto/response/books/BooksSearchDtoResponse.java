package com.example.BookStoreProject.dto.response.books;

import com.example.BookStoreProject.module.Books;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class BooksSearchDtoResponse {
    private Set<Books> foundBooks;
}
