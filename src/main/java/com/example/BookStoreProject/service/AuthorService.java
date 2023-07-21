package com.example.BookStoreProject.service;

import com.example.BookStoreProject.module.Authors;

import java.util.List;

public interface AuthorService {
    Authors getByName(String authorName);

    List<Authors> assignAuthorsToBook(List<String> authorList);

}
