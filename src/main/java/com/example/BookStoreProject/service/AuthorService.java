package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.manager.author.AuthorUpdateDescriptionDtoRequest;
import com.example.BookStoreProject.dto.request.manager.author.AuthorUpdateNameDtoRequest;
import com.example.BookStoreProject.module.Authors;
import com.example.BookStoreProject.module.Books;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Authors getByName(String authorName);

    Optional<Authors> getById(Long id);
    List<Authors> assignAuthorsToBook(List<String> authorList);
    void assignBooksToAuthors(Books book);
    void updateAuthorName(Principal principal, AuthorUpdateNameDtoRequest request);
    void updateAuthorDescription(Principal principal, AuthorUpdateDescriptionDtoRequest request);

}
