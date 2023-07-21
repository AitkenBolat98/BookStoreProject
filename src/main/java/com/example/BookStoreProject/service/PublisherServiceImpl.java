package com.example.BookStoreProject.service;

import com.example.BookStoreProject.module.Publishers;
import com.example.BookStoreProject.repository.PublishersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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
}
