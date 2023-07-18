package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.manager.BookCreateDtoRequest;
import com.example.BookStoreProject.module.Books;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BookService {

    Optional<Books> getById(Long id);

    Set<Books> searchBooks(String query);

    void updateBooks(Long id,Integer quantity);

    void createBooks(Principal principal, List<BookCreateDtoRequest> requests);
}
