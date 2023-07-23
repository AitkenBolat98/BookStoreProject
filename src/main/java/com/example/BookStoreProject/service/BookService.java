package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.manager.book.*;
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
    void updateBookQuantity(Principal principal, BookUpdateQuantityDtoRequest request);
    void updateBookPrice(Principal principal, BookUpdatePriceDtoRequest request);
    void updateBookDescription(Principal principal, BookUpdateDescriptionDtoRequest request);
    void updateBookLanguage(Principal principal, BookUpdateLanguageDtoRequest request);
    void deleteBook(Principal principal, BookDeleteDtoRequest request);
    void updateBookTitle(Principal principal,BookUpdateTitleDtoRequest request);
    void updateBookGenre(Principal principal, BookUpdateGenreDtoRequest request);

}
