package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.manager.publisher.PublisherUpdateDescriptionDtoRequest;
import com.example.BookStoreProject.dto.request.manager.publisher.PublisherUpdateNameDtoRequest;
import com.example.BookStoreProject.module.Books;
import com.example.BookStoreProject.module.Publishers;

import java.security.Principal;
import java.util.Optional;

public interface PublisherService {
    Publishers getByName(String publisher);
    Publishers assignPublisherToBook(String publisher);
    void assignBooksToPublisher(Books book);
    Optional<Publishers> getById(Long id);
    void updatePublisherName(Principal principal, PublisherUpdateNameDtoRequest request);
    void updatePublisherDescription(Principal principal, PublisherUpdateDescriptionDtoRequest request);

}
