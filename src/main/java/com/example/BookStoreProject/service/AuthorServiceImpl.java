package com.example.BookStoreProject.service;

import com.example.BookStoreProject.module.Authors;
import com.example.BookStoreProject.repository.AuthorsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class AuthorServiceImpl implements AuthorService{
    private final AuthorsRepository authorsRepository;
    @Override
    public Authors getByName(String authorName) {
        return authorsRepository.findByName(authorName);
    }
}
