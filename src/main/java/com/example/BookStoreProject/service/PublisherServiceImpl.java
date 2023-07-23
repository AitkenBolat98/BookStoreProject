package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.manager.publisher.PublisherUpdateDescriptionDtoRequest;
import com.example.BookStoreProject.dto.request.manager.publisher.PublisherUpdateNameDtoRequest;
import com.example.BookStoreProject.module.Books;
import com.example.BookStoreProject.module.Publishers;
import com.example.BookStoreProject.repository.PublishersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService{
    private final PublishersRepository publishersRepository;
    @Override
    public Publishers getByName(String publisher) {
        return publishersRepository.findByName(publisher);
    }

    @Override
    public Publishers assignPublisherToBook(String publisher) {
        if(this.getByName(publisher) == null){
            Publishers newPublisher = new Publishers();
            newPublisher.setName(publisher);
            newPublisher.setDescription(null);
            newPublisher.setPublisherBooks(null);
            return newPublisher;
        }else{
            Publishers existingPublisher = this.getByName(publisher);
            return existingPublisher;
        }
    }

    @Override
    public void assignBooksToPublisher(Books book) {
        Publishers publisher = book.getPublisher();
        ArrayList<Books> newBooks = new ArrayList<>();
        newBooks.add(book);
        publisher.setPublisherBooks(newBooks);
        this.save(publisher);
    }

    @Override
    public Optional<Publishers> getById(Long id) {
        return publishersRepository.findById(id);
    }

    @Override
    public void updatePublisherName(Principal principal, PublisherUpdateNameDtoRequest request) {
        Publishers publishers = this.getById(request.getPublisherId()).orElseThrow();
        try {
            publishers.setName(request.getNewName());
            this.save(publishers);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("update publisher name");
        }
    }

    @Override
    public void updatePublisherDescription(Principal principal, PublisherUpdateDescriptionDtoRequest request) {
        Publishers publishers = this.getById(request.getPublisherId()).orElseThrow();
        try {
            publishers.setName(request.getNewDescription());
            this.save(publishers);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("update publisher description");
        }
    }

    public Publishers save(Publishers publisher){
        return publishersRepository.save(publisher);
    }
}
