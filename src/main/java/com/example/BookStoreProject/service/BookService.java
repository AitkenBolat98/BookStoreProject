package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.response.books.BooksSearchDtoResponse;
import com.example.BookStoreProject.module.Books;

import java.util.Optional;
import java.util.Set;

public interface BookService {

    Optional<Books> getById(Long id);

    BooksSearchDtoResponse searchBooks(String query);

    void updateBooks(Long id,Integer quantity);
}
