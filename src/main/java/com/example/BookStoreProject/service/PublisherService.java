package com.example.BookStoreProject.service;

import com.example.BookStoreProject.module.Publishers;

public interface PublisherService {
    Publishers getByName(String publisher);
    Publishers assignPublisherToBook(String publisher);
}
