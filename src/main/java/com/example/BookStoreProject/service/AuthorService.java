package com.example.BookStoreProject.service;

import com.example.BookStoreProject.module.Authors;

public interface AuthorService {
    Authors getByName(String authorName);
}
